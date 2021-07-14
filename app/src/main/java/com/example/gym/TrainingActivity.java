package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements PlanDetailDialog.PassPlanInterface {
    private Button btnAddToPlan;
    private TextView txtName, txtDescription;
    private ImageView trainingImage;
    public static  final String TRAINING_KEY="training";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        initView();

        Intent intent =getIntent();
        if(null!=intent){
            Training training=intent.getParcelableExtra(TRAINING_KEY);
            if(null!=training){
                txtName.setText(training.getName());
                txtDescription.setText((training.getLongDesc()));
                Glide.with(this).asBitmap().load(training.getImageUrl()).into(trainingImage);
                btnAddToPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PlanDetailDialog dialog=new PlanDetailDialog();
                        Bundle bundle=new Bundle();
                        bundle.putParcelable(TRAINING_KEY, training);
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(), "plan");

                    }
                });
            }
        }
    }
    private void initView(){
        txtName=findViewById(R.id.txtName);
        txtDescription=findViewById(R.id.txtDescription);
        btnAddToPlan=findViewById(R.id.btnAddToPlan);
        trainingImage=findViewById(R.id.trainingImage);
    }

    @Override
    public void getPlan(Plan plan) {
        if(Utils.addPlan(plan)){
            Toast.makeText(this, "Plan added successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}