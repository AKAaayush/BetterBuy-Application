package com.example.betterbuy.ui.home;

import com.example.betterbuy.models.products.CartModel;

import java.util.List;

public interface CartUpdateInterface {

    void updateCart(List<CartModel> cartModelList);
}
