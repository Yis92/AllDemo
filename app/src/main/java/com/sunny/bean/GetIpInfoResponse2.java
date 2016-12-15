package com.sunny.bean;

import com.sunny.http.CommResponse;

import java.util.List;

/**
 * Created by toreal on 2016/7/27.
 */
public class GetIpInfoResponse2 extends CommResponse<List<GetIpInfoResponse2>> {

    private int iid;
    private String name;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
