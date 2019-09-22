package com.example.categoryview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.categoryview.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ConfirmFinalOrderActivity extends AppCompatActivity {

    private EditText nameEditText,phoneEdittext,addressEditText,cityEditText;
    private Button confirmOrderBtn,buyBtn;


    private String totalAmount="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order);


        totalAmount=getIntent().getStringExtra("Total Price");
        Toast.makeText(this,"Total Price = LKR " + totalAmount,Toast.LENGTH_SHORT).show();

        confirmOrderBtn=(Button) findViewById(R.id.confirm_final_order_btn);
        buyBtn=(Button) findViewById(R.id.buy_btn);
        nameEditText=(EditText) findViewById(R.id.shipment_name);
        phoneEdittext=(EditText) findViewById(R.id.shipment_phone_number);
        addressEditText=(EditText) findViewById(R.id.shipment_address);
        cityEditText=(EditText) findViewById(R.id.shipment_city);


        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Check();

            }
        });
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ConfirmFinalOrderActivity.this,OrderSuccessfullActivity.class);

                startActivity(intent);

            }
        });




}

    private void Check() {
        if(TextUtils.isEmpty(nameEditText.getText().toString()))
        {
            Toast.makeText(this,"Please provide your full name.",Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(phoneEdittext.getText().toString()))
        {
            Toast.makeText(this,"Please provide your phone number.",Toast.LENGTH_SHORT).show();


        }

        else if(TextUtils.isEmpty(addressEditText.getText().toString()))
        {
            Toast.makeText(this,"Please provide your address.",Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(cityEditText.getText().toString()))
        {
            Toast.makeText(this,"Please provide your city.",Toast.LENGTH_SHORT).show();

        }
        else
        {

            ConfirmOrder();
        }

    }

    private void ConfirmOrder() {

        final String saveCurrentDate,saveCurrentTime;

        Calendar calForDate=Calendar.getInstance();
        SimpleDateFormat currentDate=new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate=currentDate.format(calForDate.getTime());


        SimpleDateFormat currentTime=new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime=currentDate.format(calForDate.getTime());

        final DatabaseReference ordersRef= FirebaseDatabase.getInstance().getReference()
                .child("Orders")
                .child(Prevalent.currentOnlineUser.getPhone());


        HashMap<String,Object> ordersMap=new HashMap<>();
        ordersMap.put("totalAmount",totalAmount);
        ordersMap.put("name",nameEditText.getText().toString());
        ordersMap.put("phone",phoneEdittext.getText().toString());
        ordersMap.put("address",addressEditText.getText().toString());
        ordersMap.put("city",cityEditText.getText().toString());
        ordersMap.put("date",saveCurrentDate);
        ordersMap.put("time",saveCurrentTime);
        ordersMap.put("state","Not delivered");

        ordersRef.updateChildren(ordersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    FirebaseDatabase.getInstance().getReference()
                            .child("Cart List")
                            .child("User View")
                            .child(Prevalent.currentOnlineUser.getPhone())
                            .removeValue()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(ConfirmFinalOrderActivity.this,"Your final order has been placed successfully.",Toast.LENGTH_SHORT).show();

                                        Intent intent=new Intent(ConfirmFinalOrderActivity.this,ProductListView.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        finish();
                                    }

                                }
                            });


                }

            }
        });

    }
}
