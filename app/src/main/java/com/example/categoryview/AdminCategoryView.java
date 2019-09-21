package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCategoryView extends AppCompatActivity {

    private ImageView Paintings,Sculptures,Drawings,Photographs,Posters,Prints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category_view);

        Paintings = (ImageView) findViewById(R.id.Paintings_image);
        Sculptures = (ImageView) findViewById(R.id.Sculptres);
        Drawings = (ImageView) findViewById(R.id.Drawings_image);
        Photographs = (ImageView) findViewById(R.id.Photographs_image);
        Posters = (ImageView) findViewById(R.id.Posters_image);
        Prints = (ImageView) findViewById(R.id.Prints_image);


        Paintings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryView.this,AdminAddProduct.class);
                intent.putExtra("category", "Paintings");
                startActivity(intent);
            }
        });

        Sculptures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryView.this,AdminAddProduct.class);
                intent.putExtra("category", "Sculptures");
                startActivity(intent);
            }
        });

        Drawings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryView.this,AdminAddProduct.class);
                intent.putExtra("category", "Drawings");
                startActivity(intent);
            }
        });

        Photographs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryView.this,AdminAddProduct.class);
                intent.putExtra("category", "Photographs");
                startActivity(intent);
            }
        });

        Posters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryView.this,AdminAddProduct.class);
                intent.putExtra("category", "Posters");
                startActivity(intent);
            }
        });

        Prints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryView.this,AdminAddProduct.class);
                intent.putExtra("category", "Prints");
                startActivity(intent);
            }
        });
    }
}
