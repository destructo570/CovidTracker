package com.destructo.corona_tracker.View.Adapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.destructo.corona_tracker.Model.HelplineNumberModel;
import com.destructo.corona_tracker.R;

import java.util.ArrayList;

public class HelplineNumberAdapter extends RecyclerView.Adapter<HelplineNumberAdapter.MyViewHolder> {

    private ArrayList<HelplineNumberModel> mHelpData;
    private onHelpClickListener mOnHelpClickListener;

    public HelplineNumberAdapter(ArrayList<HelplineNumberModel> helpData, onHelpClickListener onHelpClickListener) {

        mHelpData = helpData;
        mOnHelpClickListener = onHelpClickListener;
    }

    @NonNull
    @Override
    public HelplineNumberAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.helpline_number_item, parent, false);

        return new MyViewHolder(view, mOnHelpClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HelplineNumberAdapter.MyViewHolder holder, int position) {

        HelplineNumberModel currentObject = mHelpData.get(position);
        holder.stateName.setText(currentObject.getStateName());
        holder.helplineNumber.setText(currentObject.getHelpLineNumber());

    }

    @Override
    public int getItemCount() {
        return mHelpData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView stateName;
        TextView helplineNumber;
        ImageView helplinecall;
        onHelpClickListener onHelpClickListener;

        public MyViewHolder(@NonNull View itemView, onHelpClickListener helpClickListener) {
            super(itemView);
            stateName = itemView.findViewById(R.id.helpline_state_name);
            helplineNumber = itemView.findViewById(R.id.helpline_phone_num);
            helplinecall = itemView.findViewById(R.id.helpline_call_img);
            onHelpClickListener = helpClickListener;
            helplinecall.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onHelpClickListener.onHelpClick(getAdapterPosition());

        }
    }

    public interface onHelpClickListener {
        void onHelpClick(int position);
    }
}
