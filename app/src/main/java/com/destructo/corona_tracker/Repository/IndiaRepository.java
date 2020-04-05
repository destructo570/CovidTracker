package com.destructo.corona_tracker.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.destructo.corona_tracker.Model.IndiaDataModel;
import com.destructo.corona_tracker.Model.IndiaCoronaStatistics;
import com.destructo.corona_tracker.Model.IndiaStateModel;
import com.destructo.corona_tracker.Model.IndiaSummaryModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndiaRepository {


    private final String BASE_STAT_URL = "https://api.rootnet.in/covid19-in/stats/";
    private Retrofit retrofit;
    private IndiaDataApi indiaDataApi;


    public LiveData<IndiaCoronaStatistics> getIndiaStats() {

        final MutableLiveData<IndiaCoronaStatistics> indiaStateStats = new MutableLiveData<>();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_STAT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        indiaDataApi = retrofit.create(IndiaDataApi.class);

        Call<IndiaCoronaStatistics> call = indiaDataApi.getIndiaData();

        call.enqueue(new Callback<IndiaCoronaStatistics>() {
            @Override
            public void onResponse(Call<IndiaCoronaStatistics> call, Response<IndiaCoronaStatistics> response) {
                if (!response.isSuccessful()) {
                    Log.e("IndiaRepository", "Response Unsuccessful, CODE : " + response.code());

                }

                indiaStateStats.setValue(response.body());
            }

            @Override
            public void onFailure(Call<IndiaCoronaStatistics> call, Throwable t) {

                Log.e("IndiaRepository", "Response Failure, CODE : " + t.getMessage());

            }
        });


        return indiaStateStats;
    }
}
