package com.example.contactmanagersqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactmanagersqlite.Model.Contact;
import com.example.contactmanagersqlite.R;
import com.example.contactmanagersqlite.Util.DetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView contactName;
        public TextView phoneNumber;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            contactName = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phone_number);
            icon = itemView.findViewById(R.id.imageview);

        }

        @Override
        public void onClick(View v) {

           int position =  getAdapterPosition();
           Contact contact = contactList.get(position);

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", contact.getName());
            intent.putExtra("phone", contact.getPhoneNumber());
            context.startActivity(intent);

        }
    }
}
