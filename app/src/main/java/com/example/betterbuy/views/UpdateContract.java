package com.example.betterbuy.views;

import com.example.betterbuy.models.user.User;

public interface UpdateContract {

    interface View{
        void onUpdateUser(User user);
        void onFailed(String message);
    }


    interface Presenter{
        void onUpdateUser(User user);
        void onFailed(String message);
    }
}
