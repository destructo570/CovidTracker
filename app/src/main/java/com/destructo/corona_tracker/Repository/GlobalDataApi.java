package com.destructo.corona_tracker.Repository;

import com.destructo.corona_tracker.Model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.Model.GlobalCoronaStatistics;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GlobalDataApi {

    @GET("all")
    Call<GlobalCoronaStatistics> getGlobalSummary();

    @GET("countries")
    Call<ArrayList<GlobalCoronaCountryStatistics>> getGlobalCountrySummary();

}
