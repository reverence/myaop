package com.my.aop;

/**
 * Created by tufei on 2017/12/13.
 */
public class BeanUtils {

    private static AbastractApplicationContext applicationContext;

    public static void setAbastractApplicationContext(AbastractApplicationContext context){
        synchronized (BeanUtils.class){
            if(null == applicationContext){
                synchronized (BeanUtils.class){
                    applicationContext = context;
                }
            }
        }
    }

    public static Object getBean(String beanName){
        return ((BeanFactory)applicationContext).getBean(beanName);
    }
}
