package com.example.categoryview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    private int[] mImages = new int[]{

            R.drawable.art1, R.drawable.art2, R.drawable.art4
    };

    private String[] mImagesTitle = new String[]{
            "ART", "ABSTRACT", "LOVE"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

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
                    Intent intent = new Intent(HomePage.this, cart.class);
                    startActivity(intent);
                    return false;
                }

                if (id == R.id.profile){
                    Intent intent = new Intent(HomePage.this, Account.class);
                    startActivity(intent);
                    return false;
                }

                if (id == R.id.chat){
                    Intent intent = new Intent(HomePage.this, FeedBack.class);
                    startActivity(intent);
                    return false;
                }

                return true;
            }
        });

        navigationView.setSelectedItemId(R.id.home);

    }
}
