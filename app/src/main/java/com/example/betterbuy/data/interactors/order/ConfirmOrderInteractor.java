package com.example.betterbuy.data.interactors.order;

import android.util.Log;

import com.example.betterbuy.views.ConfirmOrderContract;
import com.example.betterbuy.models.orders.Order;
import com.example.betterbuy.network.API.OrderApi;
import com.example.betterbuy.network.RetrofitIniti;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmOrderInteractor {

    private ConfirmOrderContract.Presenter presenter;
    private static final String TAG = "ConfirmOrderInteractor";

    public ConfirmOrderInteractor(ConfirmOrderContract.Presenter presenter) {
        this.presenter = presenter;
    }


    public void addOrder(String token, Order order){

        OrderApi api = RetrofitIniti.initialize().create(OrderApi.class);
        Call<Order> responseCall = api.addOrder(token, order);

        responseCall.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                    if(response.isSuccessful()){
                        if(response.body().isSuccess()){
                            presenter.onSuccess();
                        }else{
                            presenter.onFailed("Couldn't add Order");
                        }
                    }else{
                        presenter.onFailed("Couldn't add Order");
                        Log.d(TAG, "onResponse: " + response.message());

                    }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                presenter.onFailed("Something Went Wrong!");
                Log.d(TAG, "onResponse: " + t.toString());
            }
        });

    }

}
