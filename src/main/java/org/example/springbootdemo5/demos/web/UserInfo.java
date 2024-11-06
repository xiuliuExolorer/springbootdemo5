package org.example.springbootdemo5.demos.web;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private String userName;
    private String userId;
    private String address;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
