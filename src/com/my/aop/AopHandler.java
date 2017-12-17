package com.my.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tufei on 2017/12/16.
 */
public class AopHandler implements InvocationHandler {

    private AopMethod aopMethod;

    private Object needProxyObject;

    public AopHandler(AopMethod method,Object object){
        this.aopMethod = method;
        this.needProxyObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("saveUser"))
            aopMethod.before();
        Object object = method.invoke(needProxyObject,args);
        if(method.getName().equals("saveUser"))
            aopMethod.after();
        return object;
    }
}
