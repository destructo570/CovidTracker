package com.destructo.corona_tracker.repository;

import com.destructo.corona_tracker.model.IndiaSummaryModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IndiaDataApi {


    @GET("latest")
    Call<Object> getLatestState();

    @GET("latest")
    Call<IndiaSummaryModel> getLatestSummary();



}
