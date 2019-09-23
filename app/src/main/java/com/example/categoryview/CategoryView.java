package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryView extends AppCompatActivity {

    TextView category;
    ImageView Paintings,Sculptures,Drawings,Photographs,Posters,Prints;
    TextView Paintingstxt,Sculpturestxt,Drawingstxt,Photographstxt,Posterstxt,Printstxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        category = findViewById(R.id.textView);
        category.setText(R.string.category);

        Paintingstxt = findViewById(R.id.painting_txt);
        Sculpturestxt = findViewById(R.id.sculpture_txt);
        Drawingstxt = findViewById(R.id.drawing_txt);
        Photographstxt = findViewById(R.id.photography_txt);
        Posterstxt = findViewById(R.id.poster_txt);
        Printstxt = findViewById(R.id.print_txt);;

        Paintings = findViewById(R.id.Paintings_image);
        Sculptures = findViewById(R.id.Sculputres_image);
        Drawings = findViewById(R.id.Drawings_image);
        Prints = findViewById(R.id.Prints_image);
        Photographs = findViewById(R.id.Photographs_image);
        Posters = findViewById(R.id.Posters_image);

        Paintings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryView.this,ProductListView.class);
                startActivity(intent);
            }
        });

        Sculptures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryView.this,ProductListView.class);
                startActivity(intent);
            }
        });

        Drawings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryView.this,ProductListView.class);
                startActivity(intent);
            }
        });

        Photographs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryView.this,ProductListView.class);
                startActivity(intent);
            }
        });

        Posters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryView.this,ProductListView.class);
                startActivity(intent);
            }
        });

        Prints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryView.this,ProductListView.class);
                startActivity(intent);
            }
        });


        Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryView.this, CartActivity.class);
                startActivity(intent);
            }
        });

    }

   public void catDetailView(View view){
        Intent intent01 = new Intent(CategoryView.this, ProductListView.class);
        startActivity(intent01);

    }




}
