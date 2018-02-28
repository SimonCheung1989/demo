package com.example.demo.exception;

public class DemoException extends Exception {

    private String errorCode;
    private String errorMsg;

    public DemoException(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "DemoException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
