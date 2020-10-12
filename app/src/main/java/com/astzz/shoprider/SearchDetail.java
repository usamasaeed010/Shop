package com.astzz.shoprider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchDetail extends AppCompatActivity {

    private Button customer,Machanic,supplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);

        customer = findViewById(R.id.customer2);
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivity(intent);
            }
        });
        Machanic = findViewById(R.id.machanic2);
        Machanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MachanicActivity.class);
                startActivity(intent);
            }
        });
        supplier = findViewById(R.id.supplier2);
        supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SupplierActivity.class);
                startActivity(intent);
            }
        });


    }
}