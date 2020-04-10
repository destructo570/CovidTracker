package com.destructo.corona_tracker.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.destructo.corona_tracker.Model.IndiaStateDeserializer;
import com.destructo.corona_tracker.Model.IndiaStateModel;
import com.destructo.corona_tracker.Model.IndiaSumDeserializer;
import com.destructo.corona_tracker.Model.IndiaSummaryModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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


    public LiveData<IndiaSummaryModel> getIndiaSummary(){

        final MutableLiveData<IndiaSummaryModel> indiaSummaryStats = new MutableLiveData<>();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(IndiaSummaryModel.class, new IndiaSumDeserializer())
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_STAT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        indiaDataApi = retrofit.create(IndiaDataApi.class);

        Call<IndiaSummaryModel> call = indiaDataApi.getLatestSummary();

        call.enqueue(new Callback<IndiaSummaryModel>() {
            @Override
            public void onResponse(Call<IndiaSummaryModel> call, Response<IndiaSummaryModel> response) {

                    indiaSummaryStats.setValue(response.body());

            }

            @Override
            public void onFailure(Call<IndiaSummaryModel> call, Throwable t) {

            }
        });
        return indiaSummaryStats;
    }

    public LiveData<ArrayList<IndiaStateModel>> getIndiaStates(){

        final MutableLiveData<ArrayList<IndiaStateModel>> indiaStateList = new MutableLiveData<>();


        Type listType = new TypeToken<ArrayList<IndiaStateModel>>(){}.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(listType, new IndiaStateDeserializer())
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_STAT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        indiaDataApi = retrofit.create(IndiaDataApi.class);

        Call<Object> call = indiaDataApi.getLatestState();

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                indiaStateList.setValue(gson.fromJson(gson.toJson(response.body()), listType));

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
        return indiaStateList;
    }
}
