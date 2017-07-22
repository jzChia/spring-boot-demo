package com.example.demo.exception;

/**
 * Created by jiazhijie on 2017/6/20.
 */
public class MyException extends Exception {

    private String data = "";
    public MyException(String message,String data) {
        super(message);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
