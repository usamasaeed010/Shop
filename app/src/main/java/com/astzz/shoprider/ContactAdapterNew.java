//package com.astzz.shoprider;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//
//public class ContactAdapterNew extends RecyclerView.Adapter<ContactAdapterNew.ContactViewHolder>{
//
//    private ArrayList<User> contactList;
//    private Context mContext;
//
//    public ContactAdapterNew(Context context, ArrayList<Contact> contact_list){
//        this.contactList = contact_list;
//        this.mContext = context;
//    }
//
//    @NonNull
//    @Override
//    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
//        ContactViewHolder holder = new ContactViewHolder(view);
//        return holder;
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
//
//        User contact = contactList.get(position);
//        holder.NameList.setText("Name: " + contact.getName1());
//        holder.adresList.setText("Address: " + contact.getAddress1());
//        holder.PhoneNumberList.setText("Phone: " + contact.getPhnNumber1());
//        holder.MachineList.setText("Machine: " + contact.getMachine1());
//        holder.MachanicNameList.setText("Machanic: " + contact.getMachanic1());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return contactList.size();
//    }
//
//    class ContactViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView NameList;
//        public TextView adresList;
//        public TextView PhoneNumberList;
//        public TextView MachineList;
//        public TextView MachanicNameList;
//
//
//        public ContactViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            NameList = itemView.findViewById(R.id.txt_name);
//            adresList = itemView.findViewById(R.id.txt_address);
//            PhoneNumberList = itemView.findViewById(R.id.txt_phone);
//            MachineList = itemView.findViewById(R.id.machine_name);
//            MachanicNameList = itemView.findViewById(R.id.txt_machanic_name);
//
//        }
//    }
//}
