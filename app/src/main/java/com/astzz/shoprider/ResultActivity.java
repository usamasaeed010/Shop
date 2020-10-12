package com.astzz.shoprider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText txt_name;
    private EditText txt_email;
    private EditText txt_phone;
    private EditText txt_address;
    private EditText txt_age;
    private EditText txt_cnic;
    private int contact_id = 0;
    private Button btn_add, btn_edit, btn_delete;
    private DBValues database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Bundle data = getIntent().getBundleExtra("data");

        txt_name = findViewById(R.id.txt_name);
        txt_email = findViewById(R.id.txt_email);
        txt_phone = findViewById(R.id.txt_phone);
        txt_address = findViewById(R.id.txt_address);
        txt_age = findViewById(R.id.txt_age);
        txt_cnic = findViewById(R.id.txt_cnic);

        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        btn_edit = findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(this);

        btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);

        database = new DBValues(this);

        if (data != null) {
            contact_id = Integer.valueOf(data.getString("id"));
            //txt_id.setText(data.getString("id"));
            txt_name.setText(data.getString("name"));
            txt_email.setText(data.getString("email"));
            txt_phone.setText(data.getString("phone"));
            txt_address.setText(data.getString("address"));
            txt_age.setText(data.getString("age"));
            txt_cnic.setText(data.getString("cnic"));

            btn_delete.setVisibility(View.VISIBLE);
            btn_edit.setVisibility(View.VISIBLE);
            btn_add.setVisibility(View.GONE);
        } else {
            btn_delete.setVisibility(View.GONE);
            btn_edit.setVisibility(View.GONE);
            btn_add.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view == btn_add) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("shop-ridee").child("user");

            HashMap hashMap = new HashMap();
            hashMap.put("name", txt_name.getText().toString());
            hashMap.put("address", txt_email.getText().toString());
            hashMap.put("phnnumber", txt_phone.getText().toString());
            hashMap.put("Machine", txt_age.getText().toString());
            hashMap.put("Machanic", txt_cnic.getText().toString());


            databaseReference.push().updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o){
                                }
            });

            CheckData(1);
        } else if (view == btn_edit) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("shop-ridee").child("user");

            HashMap hashMap = new HashMap();
            hashMap.put("name", txt_name.getText().toString());
            hashMap.put("address", txt_email.getText().toString());
            hashMap.put("phnnumber", txt_phone.getText().toString());
            hashMap.put("Machine", txt_age.getText().toString());
            hashMap.put("Machanic", txt_cnic.getText().toString());


            databaseReference.push().updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    Toast.makeText(ResultActivity.this, "succuessul", Toast.LENGTH_SHORT).show();
                }
            });

            CheckData(2);
        } else if (view == btn_delete) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("shop-ridee").child("user");

            HashMap hashMap = new HashMap();
            hashMap.put("name", txt_name.getText().toString());
            hashMap.put("address", txt_email.getText().toString());
            hashMap.put("phnnumber", txt_phone.getText().toString());
            hashMap.put("Machine", txt_age.getText().toString());
            hashMap.put("Machanic", txt_cnic.getText().toString());


            databaseReference.push().updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    Toast.makeText(ResultActivity.this, "succuessul", Toast.LENGTH_SHORT).show();
                }
            });
            CheckData(3);
        }
    }

    private void CheckData(int num) {

        String name = txt_name.getText().toString();
        String email = txt_email.getText().toString();
        String phone = txt_phone.getText().toString();
        String address = txt_address.getText().toString();
        String age = txt_age.getText().toString();
        String cnic = txt_cnic.getText().toString();

        if (TextUtils.isEmpty(name)) {
            showToast("Please enter your name.");
        } else if (TextUtils.isEmpty(email)) {
            showToast("Please enter valid email address.");
        } else if (TextUtils.isEmpty(phone)) {
            showToast("Please enter valid phone number.");
        } else if (TextUtils.isEmpty(address)) {
            showToast("Please enter home address.");
        } else if (TextUtils.isEmpty(age)) {
            showToast("Please enter your age.");
        } else if (TextUtils.isEmpty(cnic)) {
            showToast("Please enter your CNIC #.");
        } else {
            Contact contact = new Contact();

            contact.setContactID(contact_id);
            contact.setContactName(name);
            contact.setContactEmail(email);
            contact.setContactAddress(address);
            contact.setContactPhone(phone);
            contact.setContactAge(age);
            contact.setContactCNIC(cnic);

            if (num == 1) {
                //showToast("Add Contact.");
                int row_id = database.AddContactinDB(contact);

                showToast("Row Id of Contact is : " + row_id);

                onBackPressed();
                //database.AddContactinDB(name, email, phone, address, age, cnic);
            } else if (num == 2) {
                int updated_row_id = database.editContact(contact);
                showToast("Row Id of Contact is : " + updated_row_id);
                onBackPressed();
            } else if (num == 3) {
                database.deleteContact(contact_id);
                showToast("Your Contact delete successfully.");
                onBackPressed();
            }
        }
    }

    // this method is used for showing toast
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
