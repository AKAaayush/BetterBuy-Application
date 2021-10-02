package com.example.betterbuy.presenters.product;

import com.example.betterbuy.data.interactors.product.ProductInteractor;
import com.example.betterbuy.views.ProductContract;
import com.example.betterbuy.models.products.Product;
import com.example.betterbuy.models.review.Rating;

import java.util.List;

public class ProductPresenter implements ProductContract.Presenter {

    private ProductContract.View view;
    private ProductInteractor interactor;


    public ProductPresenter(ProductContract.View view) {
        this.view = view;
        interactor  = new ProductInteractor(this);
    }

    public void getProductById(String id){
        interactor.getProductById(id);
    }

    public void getProductsByBrand(String brand, String id){
        interactor.getSimilarProducts(brand, id);
    }

    public void getReviews(String productid){
        interactor.getReviews(productid);
    }

    @Override
    public void getSimilarProducts(List<Product> product) {
        view.getSimilarProducts(product);
    }

    @Override
    public void onSuccess(Product product, float rating) {
        view.onSuccess(product, rating);
    }

    @Override
    public void getProductReviews(List<Rating> ratingList) {
        view.getProductReviews(ratingList);
    }

    @Override
    public void onFailed(String message) {
        view.onFailed(message);
    }
}
