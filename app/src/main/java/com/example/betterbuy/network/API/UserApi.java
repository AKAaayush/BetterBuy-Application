package com.example.betterbuy.network.API;
import com.example.betterbuy.models.user.ShippingAddress;
import com.example.betterbuy.models.user.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserApi {


    @GET("user")
    Call<User> getUser(@Header("authorization") String token);

    @GET("user/shippingAddress")
    Call<User> getShippingAddress(@Header("authorization") String token);

    @POST("user/shippingAddress")
    Call<User> addShippingAddress(@Header("authorization") String token,
                                  @Body ShippingAddress shippingAddress);


    @HTTP(method = "PUT", path = "user", hasBody = true)
    Call<User> updateUserDetails(@Header("authorization") String token,
                             @Body User user);

}
