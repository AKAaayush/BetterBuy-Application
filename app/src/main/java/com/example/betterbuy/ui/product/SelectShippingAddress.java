package com.example.betterbuy.ui.product;

import androidx.annotation.Nullable;

import com.example.betterbuy.models.user.ShippingAddress;

public interface SelectShippingAddress {

     void selectedShippingAddress(@Nullable  ShippingAddress shippingAddress);
    void isShippingAddressSelected(boolean isSelected);
}
