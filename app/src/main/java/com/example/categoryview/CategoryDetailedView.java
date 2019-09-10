package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoryDetailedView extends AppCompatActivity {

    TextView type;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detailed_view);

        type = findViewById(R.id.textView8);
        type.setText(R.string.type);
        txt1 = findViewById(R.id.textView9);
        txt1.setText(R.string.desc);
        txt2 = findViewById(R.id.textView10);
        txt2.setText(R.string.price);
        txt3 = findViewById(R.id.textView11);
        txt3.setText(R.string.desc);
        txt4 = findViewById(R.id.textView12);
        txt4.setText(R.string.price);
        txt5 = findViewById(R.id.textView13);
        txt5.setText(R.string.desc);
        txt6 = findViewById(R.id.textView14);
        txt6.setText(R.string.price);
        txt7 = findViewById(R.id.textView15);
        txt7.setText(R.string.desc);
        txt8 = findViewById(R.id.textView16);
        txt8.setText(R.string.price);

    }
    public void ItemView(View view){
        Intent intent01 = new Intent(CategoryDetailedView.this,ItemDetailView.class);
        startActivity(intent01);

    }
}
