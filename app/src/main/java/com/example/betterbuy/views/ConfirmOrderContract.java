package com.example.betterbuy.views;

public interface ConfirmOrderContract {
    interface View{
       void onSuccess();
        void onFailed(String message);
    }

    interface Presenter{
        void onSuccess();
        void onFailed(String message);
    }

}
