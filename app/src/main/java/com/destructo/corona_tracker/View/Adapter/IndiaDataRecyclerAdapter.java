package com.destructo.corona_tracker.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.Model.IndiaStateModel;

import java.util.ArrayList;

public class IndiaDataRecyclerAdapter extends RecyclerView.Adapter<IndiaDataRecyclerAdapter.MyViewHolder> {

    private ArrayList<IndiaStateModel> mStateList;

    public IndiaDataRecyclerAdapter(ArrayList<IndiaStateModel> stateData) {

        mStateList = stateData;
    }

    @NonNull
    @Override
    public IndiaDataRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.india_data_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        IndiaStateModel currentCountry = mStateList.get(position);

        holder.state.setText(currentCountry.getState());

        holder.infected.setText(Utils.formatNumber(currentCountry.getInfectedIndian()));
    }


    @Override
    public int getItemCount() {
        return mStateList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView state, infected;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            state = itemView.findViewById(R.id.country_name_id);

            infected = itemView.findViewById(R.id.country_infected_id);
        }
    }
}
