package com.example.betterbuy.data.interactors.order;

import com.example.betterbuy.views.CartOrdersContract;
import com.example.betterbuy.models.orders.Order;
import com.example.betterbuy.network.API.OrderApi;
import com.example.betterbuy.network.RetrofitIniti;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartOrdersInteractor {

    private CartOrdersContract.Presenter presenter;

    public CartOrdersInteractor(CartOrdersContract.Presenter presenter) {
        this.presenter = presenter;
    }


    public void addOrders(List<Order> orders, String token){

        OrderApi api = RetrofitIniti.initialize().create(OrderApi.class);
        Call<Order> responseCall = api.addOrders(token, orders);

        responseCall.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if(response.isSuccessful()){
                    if(response.body().isSuccess()){
                        presenter.onSuccess();
                    }else{
                        presenter.onFailed("Couldn't place orders");
                    }
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                presenter.onFailed("Something Went Wrong!");
            }
        });
    }

}
