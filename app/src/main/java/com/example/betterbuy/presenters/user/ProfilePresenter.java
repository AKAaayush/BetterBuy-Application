package com.example.betterbuy.presenters.user;

import com.example.betterbuy.data.interactors.user.ProfileInteractor;
import com.example.betterbuy.views.ProfileContract;
import com.example.betterbuy.models.user.User;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileInteractor interactor;
    private ProfileContract.View view;

    public ProfilePresenter(ProfileContract.View view){
        this.view = view;

        interactor = new ProfileInteractor(this);
    }

    public void getProfile(String token){
        interactor.getUser(token);
    }

    @Override
    public void getUser(User user) {
        view.getUser(user);
    }

    @Override
    public void onFailed(String message) {
        view.onFailed(message);
    }
}
