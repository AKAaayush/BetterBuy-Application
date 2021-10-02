package com.example.betterbuy.presenters.order;

import com.example.betterbuy.data.interactors.order.CartOrdersInteractor;
import com.example.betterbuy.views.CartOrdersContract;
import com.example.betterbuy.models.orders.Order;

import java.util.List;

public class CartOrdersPresenter implements CartOrdersContract.Presenter {

    private CartOrdersContract.View view;
    private CartOrdersInteractor ordersInteractor;

    public CartOrdersPresenter(CartOrdersContract.View view) {
        this.view = view;
        ordersInteractor = new CartOrdersInteractor(this);
    }

    public void addOrders(List<Order> orders, String token){
            ordersInteractor.addOrders(orders, token);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void onFailed(String message) {
        view.onFailed(message);
    }
}
