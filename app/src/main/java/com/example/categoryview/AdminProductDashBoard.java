package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminProductDashBoard extends AppCompatActivity {

    Button addItembtn, Maintainbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_product_dash_board);

        addItembtn = findViewById(R.id.add_btn);

        Maintainbtn = findViewById(R.id.maintain_btn);

        Maintainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminProductDashBoard.this,ProductListView.class);
                startActivity(intent);
            }
        });

    }

    public void AdminCategoryView(View view){
        Intent intent = new Intent(AdminProductDashBoard.this,AdminCategoryView.class);
        startActivity(intent);

    }
}
