package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_name,editText_email,editText_age;
    Button button_add,button_view;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.edittext_name);
        editText_email = findViewById(R.id.edittext_email);
        editText_age = findViewById(R.id.edittext_age);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringEmail = editText_email.getText().toString();
                String stringAge = editText_age.getText().toString();

                if(stringName.length() <=0 || stringEmail.length() <=0 || stringName.length() <=0){
                    Toast.makeText(MainActivity.this, "Enter All Data",Toast.LENGTH_SHORT).show();
                }else{
                    Database database = new Database(MainActivity.this);
                    UserModuleClass userModuleClass = new UserModuleClass(stringName,stringEmail,stringAge);
                    database.addUser(userModuleClass);
                    Toast.makeText(MainActivity.this, "Add User Successfully",Toast.LENGTH_SHORT).show();

                    finish();
                    startActivity(getIntent());
                }

            }
        });

        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ViewProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}