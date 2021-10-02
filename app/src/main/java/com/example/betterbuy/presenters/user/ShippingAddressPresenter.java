package com.example.betterbuy.presenters.user;

import com.example.betterbuy.data.interactors.user.ShippingAddressInteractor;
import com.example.betterbuy.views.ShippingAddressContract;
import com.example.betterbuy.models.user.ShippingAddress;

import java.util.List;

public class ShippingAddressPresenter implements ShippingAddressContract.Presenter {

    private ShippingAddressContract.View view;
    private ShippingAddressInteractor interactor;

    public ShippingAddressPresenter(ShippingAddressContract.View view){
        this.view = view;
        interactor = new ShippingAddressInteractor(this);
    }

    public void addShippingAddress(ShippingAddress shippingAddress, String token){
        interactor.addShippingAddress(shippingAddress, token);
    }

    public void getShippingAddress(String token){
        interactor.getShippingAddress(token);
    }



    @Override
    public void onAddShippingAddress() {
        view.onAddShippingAddress();
    }

    @Override
    public void getShippingAddress(List<ShippingAddress> shippingAddress) {
        view.getShippingAddress(shippingAddress);
    }

    @Override
    public void onFailed(String message) {
        view.onFailed(message);
    }
}
