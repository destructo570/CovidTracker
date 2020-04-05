package com.destructo.corona_tracker.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destructo.corona_tracker.Model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.R;

import java.util.ArrayList;

public class GlobalDataRecyclerAdapter extends RecyclerView.Adapter<GlobalDataRecyclerAdapter.MyViewHolder> {

    private ArrayList<GlobalCoronaCountryStatistics> mCountryStatList;
    private onCountryClickListener onCountryClickListener;


    public GlobalDataRecyclerAdapter(ArrayList<GlobalCoronaCountryStatistics> globalCoronaCountryStats, onCountryClickListener listener) {

        mCountryStatList = globalCoronaCountryStats;
        onCountryClickListener = listener;
    }

    @NonNull
    @Override
    public GlobalDataRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_data_item_view, parent, false);
        return new MyViewHolder(itemView, onCountryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GlobalDataRecyclerAdapter.MyViewHolder holder, int position) {

        GlobalCoronaCountryStatistics currentCountry = mCountryStatList.get(position);

        holder.country.setText(currentCountry.getCountry());
        holder.infected.setText(Utils.formatNumber(currentCountry.getInfected()));
        if(currentCountry.getCasesToday() == 0){
            holder.increaseIcon.setVisibility(View.GONE);
        }else {
            holder.casesToday.setText(Utils.formatNumber(currentCountry.getCasesToday()));
        }

    }

    @Override
    public int getItemCount() {
        return mCountryStatList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView country, infected, casesToday;
        onCountryClickListener countryListener;
        ImageView increaseIcon;

        public MyViewHolder(@NonNull View itemView, onCountryClickListener listener) {
            super(itemView);
            country = itemView.findViewById(R.id.country_name_id);
            infected = itemView.findViewById(R.id.country_infected_id);
            casesToday = itemView.findViewById(R.id.cases_today_id);
            increaseIcon = itemView.findViewById(R.id.increase_icon_id);
            countryListener = listener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            countryListener.onCountryClick(getAdapterPosition());
        }
    }

    public interface onCountryClickListener {

        void onCountryClick(int position);
    }
}
