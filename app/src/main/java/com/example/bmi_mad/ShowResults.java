package com.example.bmi_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        final Intent intent = getIntent();
        float result = intent.getFloatExtra(MainActivity.EXTRA_NUMBER, 0);

        TextView textView1 = (TextView) findViewById(R.id.result1);
        textView1.setText("" + result);

        TextView res1;
        TextView res2;

        res1 = findViewById(R.id.result1);
        res2 = findViewById(R.id.result2);

        res1.setText(String.valueOf(result));

        if (result >= 25) {

            res2.setText("Over-Weight");

        } else if (result < 18) {

            res2.setText("Skinny");
        } else {
            res2.setText("Normal");
        }

        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }
    public void openMainActivity(){
        Intent intent1 = new Intent(this,MainActivity.class);
        startActivity(intent1);
    }

}


