package com.sunny.vm.rxjava_retrofit.service;

import com.sunny.bean.GetIpInfoResponse;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by toreal on 2016/8/1.
 */
public interface MyService {

    @POST("/index/index.php?c=index&m=article&a=interests")
    Observable<GetIpInfoResponse> login(@Query("uid") int uid,@Query("token") String token);
}
