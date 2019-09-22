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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AddAccountDetails extends AppCompatActivity {

    private EditText editName,editBirthday,editAddress,editPhone,editGender;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account_details);

        editName = (EditText) findViewById(R.id.name_txt);
        editBirthday = (EditText) findViewById(R.id.birthday);
        editAddress = (EditText) findViewById(R.id.address);
        editPhone = (EditText) findViewById(R.id.phone);
        editGender = (EditText) findViewById(R.id.gender);
        buttonSave = (Button) findViewById(R.id.save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateProfile();
            }
        });


    }

    private void CreateProfile() {
        String name = editName.getText().toString();
        String birthday = editBirthday.getText().toString();
        String address = editAddress.getText().toString();
        String phone = editPhone.getText().toString();
        String gender = editGender.getText().toString();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please Enter Your Name..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(birthday)){
            Toast.makeText(this,"Please Enter Your Birthday..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(address)){
            Toast.makeText(this,"Please Enter Your Address..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phone)){
            Toast.makeText(this,"Please Enter Your Phone..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(gender)){
            Toast.makeText(this,"Please Enter Your Gender..", Toast.LENGTH_SHORT).show();
        }
        else{

            Validatedetails(name,birthday,address,phone,gender);
        }

    }

    private void Validatedetails(final String name, final String birthday, final String address, final String phone, final String gender) {

        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Profile").child(name).exists())){

                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("Name",name);
                    userdataMap.put("Birthday",birthday);
                    userdataMap.put("Address",address);
                    userdataMap.put("Phone",phone);
                    userdataMap.put("Gender",gender);

                    ref.child("Profile").child(name).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(AddAccountDetails.this,"Your Profile Detail has added Successfully..",Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(AddAccountDetails.this,AdminProductDashBoard.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(AddAccountDetails.this,"Network error..",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
                else{
                    Intent intent = new Intent(AddAccountDetails.this,AdminProductDashBoard.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
