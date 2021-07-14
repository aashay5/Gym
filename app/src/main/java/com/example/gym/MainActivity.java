package com.example.gym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSeePlan, btnSeeActivities, btnAbout, btnTutorials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Utils.initTrainings();
        btnSeeActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, AllTrainingsActivity.class);
                startActivity(intent);
            }
        });
        btnSeePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, PlanActivity.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                        .setTitle("About")
                        .setMessage("I had a goal to work out every day for 3 hours no"+"\nmatter what, in order to make that goal a reality,"+"\nI made this simple application. I hope you like it.")
                        .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
            }
        });
        btnTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TutorialActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initViews(){
        btnSeeActivities=findViewById(R.id.btnSeeActivities);
        btnSeePlan=findViewById(R.id.btnSeePlan);
        btnAbout=findViewById(R.id.btnAbout);
        btnTutorials=findViewById(R.id.btnTutorials);
    }
}