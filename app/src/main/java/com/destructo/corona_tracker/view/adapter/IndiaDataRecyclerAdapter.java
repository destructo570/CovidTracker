package com.destructo.corona_tracker.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.model.IndiaStateModel;

import java.util.ArrayList;

public class IndiaDataRecyclerAdapter extends RecyclerView.Adapter<IndiaDataRecyclerAdapter.MyViewHolder> {

    private ArrayList<IndiaStateModel> mStateList;
    private onStateClickListener mOnStateClickListener;

    public IndiaDataRecyclerAdapter(ArrayList<IndiaStateModel> stateData, onStateClickListener stateClickListener) {

        mStateList = stateData;
        mOnStateClickListener = stateClickListener;
    }

    @NonNull
    @Override
    public IndiaDataRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.india_data_item_view, parent, false);

        return new MyViewHolder(itemView, mOnStateClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        IndiaStateModel currentCountry = mStateList.get(position);

        holder.state.setText(currentCountry.getState());

        holder.infected.setText(Utils.formatNumber(currentCountry.getTotalConfirmed()));
    }


    @Override
    public int getItemCount() {
        return mStateList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView state, infected;
        onStateClickListener stateListener;

        MyViewHolder(@NonNull View itemView, onStateClickListener listener) {
            super(itemView);

            state = itemView.findViewById(R.id.country_name_id);
            infected = itemView.findViewById(R.id.country_infected_id);
            stateListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            stateListener.onStateClick(getAdapterPosition());
        }
    }

    public interface onStateClickListener{

        void onStateClick(int position);
    }
}
