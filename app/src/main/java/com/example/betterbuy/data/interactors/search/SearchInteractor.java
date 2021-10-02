package com.example.betterbuy.data.interactors.search;

import android.util.Log;

import com.example.betterbuy.views.SearchContract;
import com.example.betterbuy.models.products.res.ProductRes;
import com.example.betterbuy.network.API.ProductApi;
import com.example.betterbuy.network.RetrofitIniti;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchInteractor {

    private SearchContract.Presenter presenter;
    private static final String TAG = "SearchInteractor";

    public SearchInteractor(SearchContract.Presenter presenter) {
        this.presenter = presenter;
    }


    public void getProductsBySearch(String search){
        ProductApi api = RetrofitIniti.initialize().create(ProductApi.class);
        Call<ProductRes> responseCall = api.getProductBySearch(search);

        responseCall.enqueue(new Callback<ProductRes>() {
            @Override
            public void onResponse(Call<ProductRes> call, Response<ProductRes> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        presenter.getSearchProducts(response.body().getProducts());
                    }else{
                        presenter.onFailed("Couldn't get products");
                    }
                }else{
                    presenter.onFailed("Couldn't get products");
                }
            }

            @Override
            public void onFailure(Call<ProductRes> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                t.printStackTrace();
                presenter.onFailed("Connection Error!");
            }
        });

    }
}
