package com.example.betterbuy.presenters.search;

import com.example.betterbuy.data.interactors.search.SearchInteractor;
import com.example.betterbuy.views.SearchContract;
import com.example.betterbuy.models.products.res.ProductRes;

import java.util.List;

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View view;
    private SearchInteractor interactor;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        interactor = new SearchInteractor(this);
    }

    public void getProductsBySearch(String search){
        interactor.getProductsBySearch(search);
    }

    @Override
    public void getSearchProducts(List<ProductRes> products) {
        view.getSearchProducts(products);
    }

    @Override
    public void onFailed(String message) {
        view.onFailed(message);
    }
}
