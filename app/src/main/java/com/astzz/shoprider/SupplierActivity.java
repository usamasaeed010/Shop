package com.astzz.shoprider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SupplierActivity extends AppCompatActivity {

    private RecyclerView customerRecyclerView;
    private ArrayList<Contact> contact_array;

    private RecyclerView.LayoutManager layoutManager;
    private DBValues database;

    private ContactAdapter mAdapter;

    private Button send,switchButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);


        contact_array = new ArrayList<Contact>();
        database = new DBValues(this);

        send = findViewById(R.id.sendMasageCustomer);
        switchButon =findViewById(R.id.swichButtonCustomer);
        switchButon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DataEntryActivity.class);
                startActivity(intent);
            }
        });

        customerRecyclerView = findViewById(R.id.customerRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        customerRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ContactAdapter(this, contact_array);
        customerRecyclerView.setAdapter(mAdapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
        getContactFromDatabase();
    }
    private void getContactFromDatabase() {
        contact_array.clear();
        Cursor cursor = database.getContactFromDB();

        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                Contact contact = new Contact();
                contact.setContactID(cursor.getInt(0));
                contact.setContactName(cursor.getString(1));
                contact.setContactPhone(cursor.getString(2));
                contact.setContactEmail(cursor.getString(3));
                contact.setContactAddress(cursor.getString(4));
                contact.setContactAge(cursor.getString(5));
                contact.setContactCNIC(cursor.getString(6));
                cursor.moveToNext();
                contact_array.add(contact);
            }
        }

//        if (cursor.moveToFirst()) {
//            do {
//                Contact contact = new Contact();
//                contact.setContactID(cursor.getInt(0));
//                contact.setContactName(cursor.getString(1));
//                contact.setContactPhone(cursor.getString(2));
//                contact.setContactEmail(cursor.getString(3));
//                contact.setContactAddress(cursor.getString(4));
//                contact.setContactAge(cursor.getString(5));
//                contact.setContactCNIC(cursor.getString(6));
//
//                mArrayList.add(contact);
//
//            } while (cursor.moveToNext());
//        }

        mAdapter.notifyDataSetChanged();

    }

}