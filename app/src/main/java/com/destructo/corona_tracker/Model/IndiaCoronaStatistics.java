package com.destructo.corona_tracker.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class IndiaCoronaStatistics {

    @SerializedName("data")
    private IndiaDataModel mModel;
    private transient ArrayList<IndiaStateModel> mStateModel;
    private transient IndiaSummaryModel mSummaryModel;

    public IndiaCoronaStatistics(IndiaDataModel mModel) {
        this.mModel = mModel;
        this.mStateModel = mModel.getIndiaStateList();
        this.mSummaryModel = mModel.getIndiaSummary();
    }

    public IndiaDataModel getmModel() {
        return mModel;
    }

    public ArrayList<IndiaStateModel> getStateList() {
        return mModel.getIndiaStateList();
    }

    public IndiaSummaryModel getIndiaSummary() {
        return mModel.getIndiaSummary();
    }
}
