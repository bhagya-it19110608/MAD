package com.example.mad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editEmail,editAge;
    Button btnAddData,btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_Name);
        editEmail =(EditText)findViewById(R.id.editText_Email);
        editAge = (EditText) findViewById(R.id.editText_Age);
        btnViewAll = (Button)findViewById(R.id.button1);
        btnAddData = (Button)findViewById(R.id.button_add);

        AddData();
        ViewData();


    }


// ADD DATA
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editName.getText().toString().equals("")|| editEmail.getText().toString().equals("")|| editAge.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            boolean isInserted = myDb.insertData(editName.getText().toString(),editEmail.getText().toString(),editAge.getText().toString());
                            if (isInserted == true)
                                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );


    }
//View

    public void ViewData(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Profile.class);
                        startActivity(intent);
                    }
                }
        );
    }

}