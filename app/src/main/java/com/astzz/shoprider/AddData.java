//package com.astzz.shoprider;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnSuccessListener;
////
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class AddData extends AppCompatActivity {
//
//    private EditText Name, Address, phoneNumber, Machine, Machanic;
//    Button addbutton;
//
//    private ArrayList<String> contact_array;
//    private DBValues database;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_data);
//
//
//        Name = findViewById(R.id.name);
//        Address = findViewById(R.id.address);
//        phoneNumber = findViewById(R.id.phn_number);
//        Machine = findViewById(R.id.machineData);
//        Machanic = findViewById(R.id.Refral_Machinic);
//
//        database = new DBValues(this);
//
//        contact_array = new ArrayList<String>();
//        addbutton = findViewById(R.id.btn);
//
//        Bundle data = getIntent().getBundleExtra("data");
//
//
//        addbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("shop-ridee").child("user");
//
//                HashMap hashMap = new HashMap();
//                hashMap.put("name", Name.getText().toString());
//                hashMap.put("address", Address.getText().toString());
//                hashMap.put("phnnumber", phoneNumber.getText().toString());
//                hashMap.put("Machine", Machine.getText().toString());
//                hashMap.put("Machanic", Machanic.getText().toString());
//
//
//                databaseReference.push().updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
//                    @Override
//                    public void onSuccess(Object o) {
//                        Toast.makeText(AddData.this, "succuessul", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//            }
//        });
//
//
//
//        if (data != null) {
//
//            Name.setText(data.getString("name"));
//            Address.setText(data.getString("address"));
//            phoneNumber.setText(data.getString("phone"));
//            Machine.setText(data.getString("machine"));
//            Machanic.setText(data.getString("machanic"));
//        }
//    }
//
//    private void CheckData(int num) {
//
//        String name = Name.getText().toString();
//        String address = Address.getText().toString();
//        String phone = phoneNumber.getText().toString();
//        String machine = Machine.getText().toString();
//        String machanic = Machanic.getText().toString();
//
//        if (TextUtils.isEmpty(name)) {
//            showToast("Please enter your name.");
//        } else if (TextUtils.isEmpty(address)) {
//            showToast("PPlease enter home address.");
//        } else if (TextUtils.isEmpty(phone)) {
//            showToast("Please enter valid phone number.");
//        } else if (TextUtils.isEmpty(machine)) {
//            showToast("Please enter machine Name.");
//        } else if (TextUtils.isEmpty(machanic)) {
//            showToast("Please enter your Machanic Name");
//        } else {
//            User contact = new User();
//
//            contact.setName1(name);
//            contact.setAddress1(address);
//            contact.setPhnNumber1(phone);
//            contact.setMachine1(machine);
//            contact.setMachanic1(machanic);
//
//            if (num == 1) {
//                int row_id = database.AddContactinDB(contact);
//                showToast("Row Id of Contact is : " + row_id);
//                onBackPressed();
//            }
//        }
//    }
//
//    // this method is used for showing toast
//    private void showToast(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }
//
//}