package com.example.walkplanetcat_mobile.APIS;

import com.example.walkplanetcat_mobile.MODELS.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserHandle {

    // 서버로 전송할 Handler
    @Headers("Content-Type: application/json; charset=UTF-8")
    @POST("/user/login")
    Call<Login> login(@Body Login login);

}