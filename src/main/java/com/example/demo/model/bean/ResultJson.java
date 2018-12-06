package com.example.demo.model.bean;

import java.io.Serializable;

/**
 * Created by vickl on 2018/12/5.
 */
public class ResultJson implements Serializable {

    public static final String ERROR="error";
    public static final String SUCCESS="success";

    /**
     * 状态
     */
    private String status;
    /**
     * 消息
     */
    private String message;

    public ResultJson(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResultJson(String status, String message) {

        this.status = status;
        this.message = message;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**

     * 数据
     */
    private Object data;

}
