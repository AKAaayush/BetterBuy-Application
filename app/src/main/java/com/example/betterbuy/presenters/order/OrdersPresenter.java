package com.example.betterbuy.presenters.order;

import com.example.betterbuy.data.interactors.order.OrdersInteractor;
import com.example.betterbuy.views.OrdersContract;
import com.example.betterbuy.models.orders.OrderRes;

import java.util.List;

public class OrdersPresenter implements OrdersContract.Presenter {

    private OrdersContract.View view;
    private OrdersInteractor interactor;

    public OrdersPresenter(OrdersContract.View view) {
        this.view = view;
        interactor = new OrdersInteractor(this);
    }


    public void getOrdersByUser(String token){
        interactor.getOrdersByUser(token);
    }

    public void cancelOrders(String token, List<String> productid){
        interactor.calcelOrders(token, productid);
    }

    @Override
    public void ordersByUsers(List<OrderRes> orders) {
        view.ordersByUsers(orders);
    }

    @Override
    public void cancelOrders(String message) {
        view.cancelOrders(message);
    }

    @Override
    public void onFailed(String message) {
        view.onFailed(message);
    }
}
