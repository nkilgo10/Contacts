package com.example.contactmanagersqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactmanagersqlite.Data.DatabaseHandler;
import com.example.contactmanagersqlite.Model.Contact;
import com.example.contactmanagersqlite.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactArrayList = new ArrayList<>();

        List<Contact> contactList = db.getAllContacts();

        for(Contact contact: contactList) {
            Log.d("Main Activity", "onCreate: " +contact.getName());
            contactArrayList.add(contact);
        }

        //Set up adapter
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);

        recyclerView.setAdapter(recyclerViewAdapter);


    }
}