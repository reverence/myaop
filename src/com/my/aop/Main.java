package com.my.aop;

/**
 * Created by tufei on 2017/12/10.
 */
public class Main {

    public static void main(String[] args) throws Exception{
//        UserService user = new UserService();
//        IUserService userService = (IUserService)AopFactory.getBean(user, new AopMethod() {
//            @Override
//            public void before() {
//                System.out.println("before......");
//            }
//
//            @Override
//            public void after() {
//                System.out.println("after.....");
//            }
//        });
//        userService.saveUser();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = (IUserService) context.getBean("userService");
        userService.saveUser();
    }
}
