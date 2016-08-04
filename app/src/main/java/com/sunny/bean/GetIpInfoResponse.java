package com.sunny.bean;

import java.util.List;

/**
 * Created by toreal on 2016/7/27.
 */
public class GetIpInfoResponse {

    private String status;
    private String message;
    private List<Bean> data;

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

    public List<Bean> getData() {
        return data;
    }

    public void setData(List<Bean> data) {
        this.data = data;
    }
}
