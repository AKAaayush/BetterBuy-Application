package com.example.betterbuy.ui.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.betterbuy.views.SearchContract;
import com.example.betterbuy.R;
import com.example.betterbuy.adapters.HomeProductsAdapter;
import com.example.betterbuy.models.products.res.ProductRes;
import com.example.betterbuy.presenters.search.SearchPresenter;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {

    private EditText searchbar;
    private RecyclerView searchproductview;
    private String search;
    private SearchPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        viewInit();
    }

    private void viewInit(){
        searchbar = findViewById(R.id.searchbar);
        searchproductview = findViewById(R.id.searchproductview);

        Intent intent = getIntent();
        search = intent.getStringExtra("search");
        presenter  = new SearchPresenter(this);

        presenter.getProductsBySearch(search);


    }


    @Override
    public void getSearchProducts(List<ProductRes> products) {
        HomeProductsAdapter adapter = new HomeProductsAdapter(SearchActivity.this, products);
        searchproductview.setLayoutManager(new StaggeredGridLayoutManager(2  , LinearLayoutManager.VERTICAL));

        searchproductview.setAdapter(adapter);
        ViewCompat.setNestedScrollingEnabled(searchproductview, false);
    }

    @Override
    public void onFailed(String message) {

    }
}