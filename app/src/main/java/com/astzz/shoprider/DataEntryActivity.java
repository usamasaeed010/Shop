package com.astzz.shoprider;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataEntryActivity extends AppCompatActivity implements View.OnClickListener {

    private Button send, customer2, machanic2, supplier2, swichBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);


        send = findViewById(R.id.sendMasage);
        send.setOnClickListener(this);
        customer2 = findViewById(R.id.customer2);
        customer2.setOnClickListener(this);
        machanic2 = findViewById(R.id.machanic2);
        machanic2.setOnClickListener(this);
        supplier2 = findViewById(R.id.supplier2);
        supplier2.setOnClickListener(this);
        swichBtn = findViewById(R.id.swichButton2);
        swichBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == swichBtn){
            Intent intent = new Intent(getApplicationContext(), SearchDetail.class);
            startActivity(intent);
        }

        else if(view == customer2){
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class).putExtra("data","customer");
            startActivity(intent);
        }else if(view == machanic2){
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class).putExtra("data","mechanic");
            startActivity(intent);
        }else if(view == supplier2){
            Intent supplier = new Intent(getApplicationContext(), ResultActivity.class).putExtra("data","supplier");
            startActivity(supplier);
        }else if(view == send){
            Intent supplier = new Intent(getApplicationContext(), ResultActivity.class);
            startActivity(supplier);
        }
    }
}