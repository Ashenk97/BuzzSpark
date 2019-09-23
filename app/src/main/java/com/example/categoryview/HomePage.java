package com.example.categoryview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;


public class HomePage extends AppCompatActivity {

    private int[] mImages = new int[]{
            R.drawable.art6, R.drawable.art2, R.drawable.art5, R.drawable.art1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        CarouselView carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(HomePage.this, "BUZZ-SPARK", Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView navigationView = findViewById(R.id.btm_nav);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.home){
                    HomeFragment fragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, fragment);
                    fragmentTransaction.commit();
                }

                if (id == R.id.categories){
                    Intent intent = new Intent(HomePage.this, CategoryView.class);
                    startActivity(intent);
                    return false;

//                    CategoryFragment fragment = new CategoryFragment();
//                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.frame_layout, fragment);
//                    fragmentTransaction.commit();
                }

                if (id == R.id.cart){


                    Intent intent = new Intent(HomePage.this, CartActivity.class);
                    startActivity(intent);
                    return false;
                }

                if (id == R.id.searchFunction){
                    Intent intent = new Intent(HomePage.this, searchProduct.class);
                    startActivity(intent);
                    return false;
                }

                if (id == R.id.profile){
                    Intent intent = new Intent(HomePage.this, ProfileDash.class);
                    startActivity(intent);
                    return false;
                }

                return true;
            }
        });

        navigationView.setSelectedItemId(R.id.home);

    }
}
