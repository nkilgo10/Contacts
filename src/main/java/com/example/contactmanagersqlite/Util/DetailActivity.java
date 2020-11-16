package com.example.contactmanagersqlite.Util;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.contactmanagersqlite.R;

public class DetailActivity extends AppCompatActivity {
    private TextView detsName, detsPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detsName = findViewById(R.id.details_name);
        detsPhone = findViewById(R.id.details_phone);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");

            detsName.setText(name);
            detsPhone.setText(phone);
        }

    }
}