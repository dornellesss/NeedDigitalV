package com.example.marcos.needdigitalv;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RequestInterface {

    @FormUrlEncoded
    @POST("register.php")
    Call<JsonResponse> create(@Field( "name" )String name,@Field( "password" ) String password, @Field( "email" ) String email);

    @FormUrlEncoded
    @POST("login.php")
    Call<JsonResponse> login(@Field( "email" ) String email,@Field("password") String password);
}
