package com.example.betterbuy.views;

import com.example.betterbuy.models.user.ShippingAddress;

import java.util.List;

public interface ShippingAddressContract {

    interface View{
        void onAddShippingAddress();
        void getShippingAddress(List<ShippingAddress> shippingAddress);
        void onFailed(String message);
    }

    interface Presenter{
        void onAddShippingAddress();
        void getShippingAddress(List<ShippingAddress> shippingAddress);
        void onFailed(String message);
    }
}
