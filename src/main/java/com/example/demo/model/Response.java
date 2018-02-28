package com.example.demo.model;

import java.io.Serializable;

public class Response implements Serializable{

    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
