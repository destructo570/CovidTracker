package com.destructo.corona_tracker.ViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.destructo.corona_tracker.Model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.View.Adapter.Utils;
import com.google.gson.Gson;

public class CountryDetails extends AppCompatActivity {

    private TextView totalCases;
    private TextView totalDeaths;
    private TextView totalRecovered;
    private TextView totalActive;
    private TextView critical;
    private TextView todayCases;
    private TextView todayDeaths;
    private TextView casesPerMillion;
    private TextView deathsPerMillion;
    private TextView lastUpdated;

    private GlobalCoronaCountryStatistics mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        totalCases = findViewById(R.id.total_cases);
        totalActive = findViewById(R.id.total_active);
        totalRecovered =findViewById(R.id.total_recovered);
        totalDeaths = findViewById(R.id.total_deaths);

        critical = findViewById(R.id.total_critical);
        todayCases = findViewById(R.id.total_new_cases);
        todayDeaths =findViewById(R.id.total_new_deaths);
        casesPerMillion = findViewById(R.id.cases_per_million);
        deathsPerMillion = findViewById(R.id.death_per_million);
        lastUpdated = findViewById(R.id.last_update);

        upDateUi();

    }

    private void upDateUi(){
        Gson gson = new Gson();
        mData = gson.fromJson(getIntent().getStringExtra("SUMMARY"), GlobalCoronaCountryStatistics.class);

        setTitle(mData.getCountry());

        totalCases.setText(Utils.formatNumber(mData.getInfected()));
        totalActive.setText(Utils.formatNumber(mData.getActive()));
        totalRecovered.setText(Utils.formatNumber(mData.getRecovered()));
        totalDeaths.setText(Utils.formatNumber(mData.getDeath()));
        critical.setText(Utils.formatNumber(mData.getmCriticalCases()));
        todayCases.setText(Utils.formatNumber(mData.getCasesToday()));
        todayDeaths.setText(Utils.formatNumber(mData.getDeathsToday()));
        casesPerMillion.setText(Utils.formatNumber(mData.getCasesPerMillion()));
        deathsPerMillion.setText(Utils.formatNumber(mData.getDeathsPerMillion()));
        lastUpdated.setText("LAST UPDATED ON " + Utils.formatDate(mData.getLastUpdate()));


    }
}
