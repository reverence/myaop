package com.my.aop;

/**
 * Created by tufei on 2017/12/10.
 */
public class ContactInfo {

    private String mobile;

    private String mail;

    public ContactInfo(String mobile,String mail){
        this.mobile = mobile;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
