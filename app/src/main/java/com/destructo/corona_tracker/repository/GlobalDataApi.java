package com.destructo.corona_tracker.repository;

import com.destructo.corona_tracker.model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.model.GlobalCoronaStatistics;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GlobalDataApi {

    @GET("all")
    Call<GlobalCoronaStatistics> getGlobalSummary();

    @GET("countries")
    Call<ArrayList<GlobalCoronaCountryStatistics>> getGlobalCountrySummary();

}
