package com.example.requestcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button button_adc1,button_adc2;
    Button button_cnc1,button_cnc2;
    Button button;
    TextView txt_c1,txt_c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.btntodo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity5.class);
                startActivity(intent);
            }
        });

        button_adc1 = findViewById(R.id.btnadc1);
        button_cnc1 = findViewById(R.id.btncnc1);

        button_adc1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                txt_c1 = findViewById(R.id.txtc1);
                txt_c1.setText("Requested");
            }
        });

        button_cnc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_c1 = findViewById(R.id.txtc1);
                txt_c1.setText("+Add Coach");
            }
        });

    button_adc2 = findViewById(R.id.btnadc2);
    button_cnc2 = findViewById(R.id.btncnc2);

        button_adc2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){
            txt_c2 = findViewById(R.id.txtc2);
            txt_c2.setText("Requested");
        }
    });

        button_cnc1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txt_c2 = findViewById(R.id.txtc2);
            txt_c2.setText("+Add Coach");
        }
    });
}
}
