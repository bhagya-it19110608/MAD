package com.example.bmi_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.example.bmi.EXTRA_NUMBER";


    Button gen;
    EditText wt;
    EditText ht;



    float weight, height, result;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_diet_plan,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gen = findViewById(R.id.button);
        wt = findViewById(R.id.weight);
        ht = findViewById(R.id.height);


        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShowResults();
            }
        });
    }
    public void openShowResults() {
        weight = Float.parseFloat(wt.getText().toString());
        height = Float.parseFloat(ht.getText().toString());

        result = weight / (height * height);

        EditText weight = (EditText) findViewById(R.id.weight);
        float number1 = Float.parseFloat(weight.getText().toString());

        EditText height = (EditText) findViewById(R.id.height);
        float number2 = Float.parseFloat(height.getText().toString());

        Intent intent = new Intent(this, ShowResults.class);
        intent.putExtra(EXTRA_NUMBER, result);
        startActivity(intent);
    }
}