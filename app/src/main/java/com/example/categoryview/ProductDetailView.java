package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.categoryview.Model.Products;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProductDetailView extends AppCompatActivity {
    private ImageView productImage;
    private TextView productPrice, productName, productDescription;
    private String productID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_view);

        productID = getIntent().getStringExtra("pid");

        productName = findViewById(R.id.product_name_details);
        productDescription = findViewById(R.id.product_description_details);
        productPrice = findViewById(R.id.product_price_details);
        productImage = findViewById(R.id.product_image_detail);

        getProductDetails(productID);
    }

    private void getProductDetails(final String productID) {
        DatabaseReference productRef = FirebaseDatabase.getInstance().getReference().child("Products");

        productRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    Products products = dataSnapshot.getValue(Products.class);

                    productName.setText("Name : " +products.getPname());
                    productPrice.setText("Price : Rs." +products.getPrice());
                    productDescription.setText("Description: " +products.getDescription());
                    Picasso.get().load(products.getImage()).into(productImage);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
