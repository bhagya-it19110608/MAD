package com.example.requestcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddToDo extends AppCompatActivity {
    private EditText title, desc;
    private Button add;
    private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        title = findViewById(R.id.editTextTitle);
        desc = findViewById(R.id.editTextDescription);
        add = findViewById(R.id.buttonAdd);
        context = this;
        dbHandler = new DBHandler(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userTitle = title.getText().toString();
                String userDEsc = desc.getText().toString();
                long started = System.currentTimeMillis();

                ToDo toDo = new ToDo(userTitle,userDEsc,started,0);
                dbHandler.addToDo(toDo);

                startActivity(new Intent(context,MainActivity5.class));

            }
        });
    }
}