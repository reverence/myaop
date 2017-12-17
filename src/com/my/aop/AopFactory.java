package com.my.aop;

import java.lang.reflect.Proxy;

/**
 * Created by tufei on 2017/12/16.
 */
public class AopFactory {
    public static Object getBean(Object object,AopMethod method){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),new AopHandler(method,object));
    }
}
