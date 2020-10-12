package com.example.mad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        TextView age = findViewById(R.id.age);

        Cursor cursor = databaseHelper.ViewData();

        StringBuilder stringBuilder = new StringBuilder();

        while (cursor.moveToNext()){

            name.setText(cursor.getString(1));
            email.setText(cursor.getString(2));
            age.setText(cursor.getString(3));

        button = findViewById(R.id.home1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,Home.class);
                startActivity(intent);
            }
        });
        }


    }
}