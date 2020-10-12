package com.example.bmi_mad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowDietPlan extends AppCompatActivity {

    private Button add;
    private ListView listView;
    Context context;
    private List<Dplan> dplanList;
    private DbHandle dbHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diet_plan);
        context = this;

        dbHandle = new DbHandle(context);
        add = findViewById(R.id.button4);
        listView = findViewById(R.id.planlist);
        context = this;
        dplanList =new ArrayList<>();

        dplanList = dplanList = dbHandle.getAllDplan();
        DplanAdapter adapter = new DplanAdapter(context,R.layout.activity_diet_plan,dplanList);

        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddDietPlan.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Dplan dplan = dplanList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(dplan.getDtitle());
                builder.setMessage(dplan.getDes());
                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(context,ShowDietPlan.class));
                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandle.deleteDplan(dplan.getId());
                        startActivity(new Intent(context,ShowDietPlan.class));
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context,EditDietPlan.class);
                            intent.putExtra("id",String.valueOf(dplan.getId()));
                            startActivity(intent);

                    }
                });
                builder.show();
            }
        });

    }
}