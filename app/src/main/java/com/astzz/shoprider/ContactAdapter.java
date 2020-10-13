package com.astzz.shoprider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private ArrayList<Contact> contact_array;
    private Activity mContext;

    public ContactAdapter(Activity context, ArrayList<Contact> contact_array) {
        this.contact_array = contact_array;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item_row, parent, false);
        ContactHolder holder = new ContactHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactHolder holder, int position) {

        final Contact contact = contact_array.get(position);




            holder.txt_id.setText("ID: " + contact.getContactID());
            holder.txt_name.setText("Name: " + contact.getContactName());
            holder.txt_phone.setText("Phone: " + contact.getContactPhone());
            holder.txt_address.setText("Address: " + contact.getContactAddress());
            holder.txt_age.setText("Age: " + contact.getContactAge());
            holder.txt_cnic.setText("Cnic: " + contact.getContactCNIC());












        holder.ll_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("id", "" + contact.getContactID());
                data.putString("name", contact.getContactName());
                data.putString("phone", contact.getContactPhone());
                data.putString("email", contact.getContactEmail());
                data.putString("address", contact.getContactAddress());
                data.putString("age", contact.getContactAge());
                data.putString("cnic", contact.getContactCNIC());

                Intent intent = new Intent(mContext, ResultActivity.class);
                intent.putExtra("data", data);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contact_array.size();
    }

    class ContactHolder extends RecyclerView.ViewHolder {

        public ImageView contact_image;
        public TextView txt_id;
        public TextView txt_name;
        public TextView txt_email;
        public TextView txt_phone;
        public TextView txt_address;
        public TextView txt_age;
        public TextView txt_cnic;
        public LinearLayout ll_main, ll_bottom;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            ll_main = itemView.findViewById(R.id.ll_main);

            ll_bottom = itemView.findViewById(R.id.ll_bottom);

            txt_id = itemView.findViewById(R.id.txt_id);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_email = itemView.findViewById(R.id.txt_email);
            txt_phone = itemView.findViewById(R.id.txt_phone);
            txt_address = itemView.findViewById(R.id.txt_address);
            txt_age = itemView.findViewById(R.id.txt_age);
            txt_cnic = itemView.findViewById(R.id.txt_cnic);

        }
    }
}
