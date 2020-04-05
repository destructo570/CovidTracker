package com.destructo.corona_tracker.View.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.destructo.corona_tracker.Model.GlobalCoronaStatistics;
import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.View.Adapter.Utils;
import com.google.gson.Gson;

public class GlobalDetails extends AppCompatActivity {

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
    private TextView countriesAffected;

    private GlobalCoronaStatistics mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_details);

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
        countriesAffected = findViewById(R.id.total_affected_countries);

        upDateUi();

    }

    private void upDateUi(){
        Gson gson = new Gson();
        mData = gson.fromJson(getIntent().getStringExtra("SUMMARY"), GlobalCoronaStatistics.class);

        setTitle("Global Statistics");

        totalCases.setText(Utils.formatNumber(mData.getTotalInfected()));
        totalActive.setText(Utils.formatNumber(mData.getTotalActive()));
        totalRecovered.setText(Utils.formatNumber(mData.getTotalRecovered()));
        totalDeaths.setText(Utils.formatNumber(mData.getTotalDeaths()));
        critical.setText(Utils.formatNumber(mData.getTotalCriticalCases()));
        todayCases.setText(Utils.formatNumber(mData.getTodayCasesToday()));
        todayDeaths.setText(Utils.formatNumber(mData.getTotalDeathsToday()));
        casesPerMillion.setText(Utils.formatNumber(mData.getTotalCasesPerMillion()));
        deathsPerMillion.setText(Utils.formatNumber(mData.getTotalDeathsPerMillion()));
        countriesAffected.setText(Utils.formatNumber(mData.getTotalAffectedCountries()));
        lastUpdated.setText("LAST UPDATED ON " + Utils.formatDate(mData.getLastUpdate()));


    }
}
