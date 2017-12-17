package com.my.aop;

/**
 * Created by tufei on 2017/12/16.
 */
@MyService
public class UserService implements IUserService{

    @After
    @Before
    @Override
    public void saveUser(){
        System.out.println("saving user...");
    }
}
