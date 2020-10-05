package com.example.myapplication123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewProfileActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Database database = new Database(this);
        List<UserModuleClass> userModuleClasses = database.getUserList();

        if (userModuleClasses.size()>0){
            UserAdapterClass useradapterclass = new UserAdapterClass(userModuleClasses,ViewProfileActivity.this);
        }else{
            Toast.makeText(this,"There is no any user",Toast.LENGTH_SHORT).show();
        }

    }
}