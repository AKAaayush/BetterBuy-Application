package com.example.betterbuy.views;

import com.example.betterbuy.models.orders.OrderRes;

import java.util.List;

public interface OrdersContract {

    interface View{
        void ordersByUsers(List<OrderRes> orders);
        void cancelOrders(String message);
            void onFailed(String message);
    }



    interface Presenter{
        void ordersByUsers(List<OrderRes> orders);
        void cancelOrders(String message);
        void onFailed(String message);
    }
}
