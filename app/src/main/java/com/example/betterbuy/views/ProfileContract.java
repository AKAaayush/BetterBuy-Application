package com.example.betterbuy.views;

import com.example.betterbuy.models.user.User;

public interface ProfileContract {
    interface View{
        void getUser(User user);
        void onFailed(String message);
    }


    //User Authentication Presenter
    interface Presenter{
        void getUser(User user);
        void onFailed(String message);
    }
}
