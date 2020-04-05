package com.destructo.corona_tracker.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class IndiaDataModel {


    @SerializedName("summary")
    private IndiaSummaryModel mIndiaSummary;
    @SerializedName("regional")
    private ArrayList<IndiaStateModel> mIndiaStateStats;

    public IndiaDataModel(IndiaSummaryModel mIndiaSummary, ArrayList<IndiaStateModel> mIndiaStateStats) {
        this.mIndiaSummary = mIndiaSummary;
        this.mIndiaStateStats = mIndiaStateStats;
    }

    public IndiaSummaryModel getIndiaSummary() {
        return mIndiaSummary;
    }

    public ArrayList<IndiaStateModel> getIndiaStateList() {
        return mIndiaStateStats;
    }
}
