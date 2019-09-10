package com.example.categoryview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class shipping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        Spinner mySpinner=(Spinner) findViewById(R.id.ddCountry);
        ArrayAdapter<String> myAdapter =new  ArrayAdapter<String>(shipping.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.country));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        Button btnConfirm=(Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(shipping.this,Order_Confirmation.class);
                startActivity(intent);


            }
        });




    }
}