package com.example.gym;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import static com.example.gym.TrainingActivity.TRAINING_KEY;

public class PlanRecViewAdapter extends RecyclerView.Adapter<PlanRecViewAdapter.ViewHolder> {
    public interface RemovePlan {
        void onRemovePlanResult(Plan plan);
    }

    private RemovePlan removeplan;
    private ArrayList<Plan> plans = new ArrayList<>();
    private Context context;
    private String type = "";

    public PlanRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanRecViewAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(plans.get(position).getTraining().getName());
        holder.txtDescription.setText(plans.get(position).getTraining().getShortDesc());
        holder.txtTime.setText(String.valueOf(plans.get(position).getMinutes()));
        Glide.with(context).asBitmap().load(plans.get(position).getTraining().getImageUrl()).into(holder.image);
        if (plans.get(position).isAccomplished()) {
            holder.unchecked.setVisibility(View.GONE);
            holder.checked.setVisibility(View.VISIBLE);
        } else {
            holder.unchecked.setVisibility(View.VISIBLE);
            holder.checked.setVisibility(View.GONE);
        }

        if (type.equals("Edit")) {
            holder.unchecked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Finished")
                            .setMessage("Have you finished " + plans.get(position).getTraining().getName() + " ?")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    for (Plan p : Utils.getPlans()) {
                                        if (plans.get(position) == p) {
                                            p.setAccomplished(true);

                                        }
                                    }
                                    notifyDataSetChanged();
                                }
                            });
                    builder.create().show();
                }
            });
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TrainingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(TRAINING_KEY, plans.get(position).getTraining());
                    context.startActivity(intent);
                }
            });

            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Delete Activity")
                            .setMessage("Do you really want to delete " + plans.get(position).getTraining().getName() + " ?")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try{
                                        removeplan=(RemovePlan) context;
                                        removeplan.onRemovePlanResult(plans.get(position));


                                    }catch(ClassCastException e){
                                        e.printStackTrace();
                                    }
                                }
                            });
                    builder.create().show();
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTime, txtDescription, txtName;
        private ImageView checked, unchecked, image;
        private MaterialCardView parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTime = itemView.findViewById(R.id.txtTime);
            checked = itemView.findViewById(R.id.checked);
            unchecked = itemView.findViewById(R.id.unchecked);
            image = itemView.findViewById(R.id.image);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
