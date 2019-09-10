package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CategoryView extends AppCompatActivity {

    TextView category;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        category = findViewById(R.id.textView);
        category.setText(R.string.category);

        txt1 = findViewById(R.id.textView2);
        txt1.setText(R.string.cat1);
        txt2 = findViewById(R.id.textView3);
        txt2.setText(R.string.cat2);
        txt3 = findViewById(R.id.textView4);
        txt3.setText(R.string.cat3);
        txt4 = findViewById(R.id.textView5);
        txt4.setText(R.string.cat4);
        txt5 = findViewById(R.id.textView7);
        txt5.setText(R.string.cat5);
        txt6 = findViewById(R.id.textView6);
        txt6.setText(R.string.cat6);

        Button btnHome=(Button) findViewById(R.id.button6);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //replace CategoryView -> HomeActivity
                Intent intent=new Intent(CategoryView.this, Account.class);
                startActivity(intent);


            }
        });

    }

    public void catDetailView(View view){
        Intent intent01 = new Intent(CategoryView.this,CategoryDetailedView.class);
        startActivity(intent01);

    }


}
