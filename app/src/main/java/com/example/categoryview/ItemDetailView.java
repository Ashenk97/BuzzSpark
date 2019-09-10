package com.example.categoryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemDetailView extends AppCompatActivity {

    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail_view);

        txt1 = findViewById(R.id.textView17);
        txt1.setText(R.string.desc);
        txt2 = findViewById(R.id.textView19);
        txt2.setText(R.string.price);
        txt3 = findViewById(R.id.textView20);
        txt3.setText(R.string.ship);
        txt4 = findViewById(R.id.textView21);
        txt4.setText(R.string.ret);
        txt5 = findViewById(R.id.textView22);
        txt5.setText(R.string.text);
        txt6 = findViewById(R.id.textView23);
        txt6.setText(R.string.text);
        txt7 = findViewById(R.id.textView24);
        txt7.setText(R.string.text);
        txt8 = findViewById(R.id.textView25);
        txt8.setText(R.string.text);
        btn1 = findViewById(R.id.button);
        btn1.setText(R.string.btn1);
        btn2 = findViewById(R.id.button2);
        btn2.setText(R.string.btn2);
        btn3 = findViewById(R.id.button3);
        btn3.setText(R.string.btn3);
        btn4 = findViewById(R.id.button4);
        btn4.setText(R.string.btn4);


        Button btnConfirm=(Button) findViewById(R.id.button3);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ItemDetailView.this, cart.class);
                startActivity(intent);


            }
        });

        Button btnConfirm1=(Button) findViewById(R.id.button2);
        btnConfirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ItemDetailView.this,shipping.class);
                startActivity(intent);


            }
        });

        Button btnConfirm11=(Button) findViewById(R.id.button4);
        btnConfirm11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ItemDetailView.this,FeedBack.class);
                startActivity(intent);


            }
        });

    }

       public void Back(View view){
            Intent intent01 = new Intent(ItemDetailView.this,CategoryDetailedView.class);
            startActivity(intent01);

        }

    public void Message(View view){
        Intent intent01 = new Intent(ItemDetailView.this,FeedBack.class);
        startActivity(intent01);

    }




}
