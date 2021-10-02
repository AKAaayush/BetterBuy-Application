package com.example.betterbuy.presenters.user;

import com.example.betterbuy.data.interactors.user.UpdateInteractor;
import com.example.betterbuy.views.UpdateContract;
import com.example.betterbuy.models.user.User;

public class UpdatePresenter implements UpdateContract.Presenter {

    private UpdateContract.View view;
    private UpdateInteractor interactor;

    public UpdatePresenter(UpdateContract.View view) {
        this.view = view;
        interactor = new UpdateInteractor(this);
    }


    public void updateUser(User user){
        interactor.updateUser(user);
    }


    @Override
    public void onUpdateUser(User user) {
        view.onUpdateUser(user);
    }

    @Override
    public void onFailed(String message) {
        view.onFailed(message);
    }
}
