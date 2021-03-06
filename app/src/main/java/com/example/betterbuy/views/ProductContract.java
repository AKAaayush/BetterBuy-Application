package com.example.betterbuy.views;

import com.example.betterbuy.models.products.Product;
import com.example.betterbuy.models.review.Rating;

import java.util.List;

public interface ProductContract {

    interface View{
        void getSimilarProducts(List<Product> product);
        void getProductReviews(List<Rating> ratingList);
        void onSuccess(Product product, float rating);
        void onFailed(String message);
    }


    //User Authentication Presenter
    interface Presenter{
        void getSimilarProducts(List<Product>  product);
        void onSuccess(Product product, float rating);
        void getProductReviews(List<Rating> ratingList);
        void onFailed(String message);
    }
}
