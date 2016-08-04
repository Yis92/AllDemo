package com.sunny.bean;


import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by toreal on 2016/7/27.
 */
public interface ApiService {
    @POST("/index/index.php?c=index&m=article&a=interests")
    Call<GetIpInfoResponse> getIpInfo(@Query("uid") int uid,@Query("token") String token);
}
