package com.destructo.corona_tracker.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.destructo.corona_tracker.Model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.Model.GlobalCoronaStatistics;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalRepository {

    private final String BASE_URL = "https://corona.lmao.ninja";
    private Retrofit retrofit;
    private GlobalDataApi globalDataApi;


    public LiveData<ArrayList<GlobalCoronaCountryStatistics>> getGlobalCountrySummary() {

        final MutableLiveData<ArrayList<GlobalCoronaCountryStatistics>> globalCountrySummary = new MutableLiveData<>();



        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        globalDataApi = retrofit.create(GlobalDataApi.class);

        Call<ArrayList<GlobalCoronaCountryStatistics>> call = globalDataApi.getGlobalCountrySummary();

        call.enqueue(new Callback<ArrayList<GlobalCoronaCountryStatistics>>() {
            @Override
            public void onResponse(Call<ArrayList<GlobalCoronaCountryStatistics>> call, Response<ArrayList<GlobalCoronaCountryStatistics>> response) {

                if (!response.isSuccessful()) {

                    Log.e("Global Repository", "Country Summary Response Unsuccessful, CODE: " + response.code());
                }

                globalCountrySummary.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<GlobalCoronaCountryStatistics>> call, Throwable t) {

            }
        });

        return globalCountrySummary;
    }


    public LiveData<GlobalCoronaStatistics> getGlobalSummary() {

        final MutableLiveData<GlobalCoronaStatistics> globalSummaryStats = new MutableLiveData<>();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        globalDataApi = retrofit.create(GlobalDataApi.class);

        Call<GlobalCoronaStatistics> call = globalDataApi.getGlobalSummary();

        call.enqueue(new Callback<GlobalCoronaStatistics>() {
            @Override
            public void onResponse(Call<GlobalCoronaStatistics> call, Response<GlobalCoronaStatistics> response) {

                if (!response.isSuccessful()) {

                    Log.e("GlobalRepository", "Response Unsuccessful : " + response.code());
                }

                globalSummaryStats.setValue(response.body());

            }

            @Override
            public void onFailure(Call<GlobalCoronaStatistics> call, Throwable t) {

                Log.e("GlobalRepository", "Response Failure : " + t.getMessage());

            }
        });

        return globalSummaryStats;
    }
}
