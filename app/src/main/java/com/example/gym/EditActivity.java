package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanRecViewAdapter.RemovePlan {
    private TextView txtDay;


    @Override
    public void onRemovePlanResult(Plan plan) {
        if (Utils.removePlan(plan)) {
            Toast.makeText(this, "Plan removed Successfully", Toast.LENGTH_SHORT).show();
            adapter.setPlans(getPlansByDay(plan.getDay()));
        }
    }


    private RecyclerView recyclerView;
    private Button btnAddPlan;
    private PlanRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initView();

        adapter = new PlanRecViewAdapter(this);
        adapter.setType("edit");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=getIntent();
        if(null!=intent){
            String day=intent.getStringExtra("day");
            if(null!=day){
                txtDay.setText(day);

                ArrayList<Plan> plans=getPlansByDay(day);
                adapter.setPlans(plans);
            }
        }
        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlanIntent=new Intent(EditActivity.this, AllTrainingsActivity.class);
                startActivity(addPlanIntent);
            }
        });
    }
    private void initView(){
        txtDay=findViewById(R.id.txtDay);
        recyclerView=findViewById(R.id.recyclerView);
        btnAddPlan=findViewById(R.id.btnAddPlan);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private ArrayList<Plan> getPlansByDay(String day){
        ArrayList<Plan> allPlans=Utils.getPlans();
        ArrayList<Plan> plans=new ArrayList<>();
        for(Plan p: allPlans){
            if(p.getDay().equalsIgnoreCase(day)){
                plans.add(p);
            }
        }
        return plans;
    }


}