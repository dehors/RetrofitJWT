package com.example.slam24.retrofitjwt.pokeapi;

import com.example.slam24.retrofitjwt.models.Auth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by SLAM24 on 10/17/2017.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("authenticate")
    Call<Auth> userLogIn(@Field("username") String username,
                         @Field("password") String password);
}
