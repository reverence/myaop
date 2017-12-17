package com.my.aop;

/**
 * Created by tufei on 2017/12/10.
 */
public class User {

    private String name;

    private ContactInfo contactInfo;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "name:"+this.getName()+",contact info:"+contactInfo.getMobile()+","+contactInfo.getMail();
    }
}
