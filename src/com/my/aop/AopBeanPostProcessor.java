package com.my.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tufei on 2017/12/16.
 */
@MyService
public class AopBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object processBeanAfterInstance(Object bean) {
        Set<Method> methodList = new HashSet<Method>();
        Class cls = bean.getClass();
        Class[] interfaces = cls.getInterfaces();
        if(null != interfaces){//jdk动态代理一定是实现了接口的
            for(Class inter: interfaces){
                Method[] methods = inter.getDeclaredMethods();
                for(Method method : methods){
                    try {
                        Method m = cls.getDeclaredMethod(method.getName());
                        if(m.isAnnotationPresent(Before.class)){
                            methodList.add(m);
                        }
                        if(m.isAnnotationPresent(After.class)){
                            methodList.add(m);
                        }
                        //others
                    } catch (NoSuchMethodException e) {
                        //ignore
                    }
                }
            }
        }
        if(!methodList.isEmpty()){
            return createProxy(bean,methodList);
        }
        return bean;
    }

    private Object createProxy(Object bean, final Set<Method> methodList) {
        class AopMethodHandler implements InvocationHandler {

            private Object o;

            public AopMethodHandler(Object obj){
                this.o = obj;
            }

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (null != getMethod(methodList,method,Before.class)) {
                    //处理before
                    System.out.println("before.......");
                }
                Object object = method.invoke(o,args);

                if (null != getMethod(methodList,method,After.class)) {
                    //处理after
                    System.out.println("after.......");
                }

                return object;
            }

            private Object getMethod(Set<Method> methodList, Method method, Class cls) {
                for(Method m :methodList){
                    if(m.getName().equals(method.getName())){
                        if(m.isAnnotationPresent(cls)){
                            return m;
                        }
                    }
                }
                return null;
            }
        }
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(),bean.getClass().getInterfaces(),new AopMethodHandler(bean));
    }
}
