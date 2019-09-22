package com.example.categoryview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AccountMaintain extends AppCompatActivity {
    private Button userDeleteBtn, userUpdateBtn;
    private EditText nameUpdate, birthdayUpdate, addressUpdate, phoneUpdate, genderUpdate;

    private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_maintain);

        nameUpdate = findViewById(R.id.update_name_txt);
        birthdayUpdate = findViewById(R.id.update_birthday);
        addressUpdate = findViewById(R.id.update_address);
        phoneUpdate = findViewById(R.id.update_phone);
        genderUpdate = findViewById(R.id.update_gender);
        userUpdateBtn = findViewById(R.id.update_profile_btn);
        userDeleteBtn = findViewById(R.id.delete_profile_btn);

        userUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateProfile();
            }
        });

        userDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProfile();
            }
        });
    }

    private void deleteProfile() {
        userRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Intent intent = new Intent(AccountMaintain.this,AdminProductDashBoard.class);
                startActivity(intent);
                finish();

                Toast.makeText(AccountMaintain.this,"The Product has been Deleted Successfully",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void UpdateProfile() {
        String name = nameUpdate.getText().toString();
        String birthday = birthdayUpdate.getText().toString();
        String address = addressUpdate.getText().toString();
        String phone = phoneUpdate.getText().toString();
        String gender = genderUpdate.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please Enter Your Name..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(birthday)) {
            Toast.makeText(this, "Please Enter Your Birthday..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(address)) {
            Toast.makeText(this, "Please Enter Your Address..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Please Enter Your Phone..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(gender)) {
            Toast.makeText(this, "Please Enter Your Gender..", Toast.LENGTH_SHORT).show();
        } else {

            Validatedetails(name, birthday, address, phone, gender);
        }
    }

    private void Validatedetails(final String name, final String birthday, final String address, final String phone, final String gender) {

        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Profiles").child(name).exists())) {

                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("Name", name);
                    userdataMap.put("Birthday", birthday);
                    userdataMap.put("Address", address);
                    userdataMap.put("Phone", phone);
                    userdataMap.put("Gender", gender);

                    ref.child("Profiles").child(name).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(AccountMaintain.this, "Your Profile Detail has added Successfully..", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(AccountMaintain.this, CategoryView.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(AccountMaintain.this, "Network error..", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                } else {
                    Intent intent = new Intent(AccountMaintain.this, LoginActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
