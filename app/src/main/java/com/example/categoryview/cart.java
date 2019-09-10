package com.example.categoryview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        Button btnConfirm=(Button) findViewById(R.id.btnBuy);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(cart.this, shipping.class);
                startActivity(intent);


            }
        });

        Button btnHome=(Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //replace CategoryView -> HomeActivity
                Intent intent=new Intent(cart.this, CategoryView.class);
                startActivity(intent);


            }
        });



    }



}




