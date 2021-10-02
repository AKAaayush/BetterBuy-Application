package com.example.betterbuy.ui.acount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.betterbuy.views.ProfileContract;
import com.example.betterbuy.views.UpdateContract;
import com.example.betterbuy.R;
import com.example.betterbuy.models.user.User;
import com.example.betterbuy.presenters.user.ProfilePresenter;
import com.example.betterbuy.ui.auth.Logindashboard;
import com.example.betterbuy.utiils.Authenticator;
import com.example.betterbuy.utiils.Constants;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditUserInfo extends AppCompatActivity implements ProfileContract.View, UpdateContract.View {

    private SharedPreferences sharedPreferences;
    private EditText fnametxt, lnametxt, addresstxt, phonetxt;
    private Button editbtn;
    private TextView fullnametxt;
    private CircleImageView profileimg;
    private String profile_img, token;
        private ProfilePresenter profilePresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);


        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        profile_img = sharedPreferences.getString(Constants.PROFILE_PIC, null);
        token = sharedPreferences.getString(Constants.TOKEN, null);
        checkAuth();
        viewInit();





    }


    private void viewInit(){
        fullnametxt = findViewById(R.id.fullname);
        fnametxt = findViewById(R.id.fname);
        lnametxt = findViewById(R.id.lname);
        addresstxt = findViewById(R.id.address);
        phonetxt = findViewById(R.id.phone);

        profileimg = findViewById(R.id.profileimg);


        profilePresenter = new ProfilePresenter(this);

        profilePresenter.getProfile(token);


    }

    private void checkAuth(){
        if(!Authenticator.checkLoginStatus(sharedPreferences)){
            redirect();
        }
    }


    private void redirect(){
        finish();
        startActivity(new Intent(this, Logindashboard.class));
    }


    @Override
    public void getUser(User user) {
                fullnametxt.setText(user.getFirstname() + " " + user.getLastname());
                fnametxt.setText(user.getFirstname());
                lnametxt.setText(user.getLastname());
                addresstxt.setText(user.getLocation());
                phonetxt.setText(user.getPhone());


        Picasso.get().load(profile_img).into(profileimg);

    }

    @Override
    public void onUpdateUser(User user) {

    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}