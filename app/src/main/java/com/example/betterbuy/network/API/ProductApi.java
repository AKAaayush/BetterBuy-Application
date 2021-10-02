package com.example.betterbuy.network.API;

import com.example.betterbuy.models.products.Category;
import com.example.betterbuy.models.products.Product;
import com.example.betterbuy.models.products.res.ProductRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductApi {


    @GET("product/exclusive/discount")
    Call<Product> getExclusiveProducts();

    @GET("product/order/desc")
    Call<ProductRes> getLatestProducts();

    @GET("category/{limit}")
    Call<Category> getCategoriesWithLimit(@Path("limit") String limit);

    @GET("product/{id}")
    Call<ProductRes> getProductById(@Path("id") String id);

    @GET("product/brand/{brand}/{id}")
    Call<ProductRes> getProductsByBrand(@Path("brand") String brand,
                                        @Path("id") String id);

    @GET("product/search/{search}")
    Call<ProductRes> getProductBySearch(@Path("search") String search);
}
