package com.example.betterbuy.ui.acount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.betterbuy.R;

public class Contactus extends AppCompatActivity {

    ImageView clipart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        clipart = findViewById(R.id.contactusclipart);

        Animation contactclipart = AnimationUtils.loadAnimation(this,R.anim.zoomout);
        clipart.startAnimation(contactclipart);
    }
}