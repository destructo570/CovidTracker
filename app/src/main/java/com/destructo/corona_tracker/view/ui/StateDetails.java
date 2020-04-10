package com.destructo.corona_tracker.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.model.IndiaStateModel;
import com.destructo.corona_tracker.view.adapter.Utils;
import com.google.gson.Gson;

public class StateDetails extends AppCompatActivity {

    private TextView stateName;
    private TextView totalCases;
    private TextView totalIndian;
    private TextView totalForeign;
    private TextView totalActive;
    private TextView totalRecovered;
    private TextView totalDeaths;

    private IndiaStateModel data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_details);

        stateName = findViewById(R.id.state_name);
        totalCases = findViewById(R.id.total_infected);
        totalIndian = findViewById(R.id.total_indian);
        totalForeign = findViewById(R.id.total_foreign);
        totalActive = findViewById(R.id.total_active);
        totalRecovered = findViewById(R.id.total_recovered);
        totalDeaths = findViewById(R.id.total_deaths);

        updateUi();

    }

    private void updateUi() {

        Gson gson = new Gson();
        data = gson.fromJson(getIntent().getStringExtra("SUMMARY"), IndiaStateModel.class);

        setTitle(data.getState());

        stateName.setText(data.getState());
        totalCases.setText(Utils.formatNumber(data.getTotalConfirmed()));
        totalIndian.setText(Utils.formatNumber(data.getInfectedIndian()));
        totalForeign.setText(Utils.formatNumber(data.getInfectedForeign()));
        totalActive.setText(Utils.formatNumber(data.getActiveCases()));
        totalRecovered.setText(Utils.formatNumber(data.getRecovered()));
        totalDeaths.setText(Utils.formatNumber(data.getDeaths()));

    }
}
