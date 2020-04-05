package com.destructo.corona_tracker.Repository;

import com.destructo.corona_tracker.Model.IndiaCoronaStatistics;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IndiaDataApi {


    @GET("latest")
    Call<IndiaCoronaStatistics> getIndiaData();
}
