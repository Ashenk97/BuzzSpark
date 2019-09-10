package com.example.categoryview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Order_Confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__confirmation);


        Button btnConfirm=(Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Order_Confirmation.this,payment_method.class);
                startActivity(intent);


            }
        });

        Button btnConfirm1=(Button) findViewById(R.id.btnConfirm1);
        btnConfirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Order_Confirmation.this,shipping.class);
                startActivity(intent);


            }
        });
    }
}
