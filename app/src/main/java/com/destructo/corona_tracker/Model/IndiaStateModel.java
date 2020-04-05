package com.destructo.corona_tracker.Model;

import com.google.gson.annotations.SerializedName;

public class IndiaStateModel {

    @SerializedName("loc")
    private String mState;
    @SerializedName("confirmedCasesIndian")
    private int mInfectedIndian;
    @SerializedName("confirmedCasesForeign")
    private int mInfectedForeign;
    @SerializedName("discharged")
    private int mRecovered;
    @SerializedName("deaths")
    private int mDeaths;


//    private transient int mConfirmedCasesTotal;
//    private transient int mActive;


    public IndiaStateModel(String mState, int mInfectedIndian, int mInfectedForeign, int mRecovered, int mDeaths) {
        this.mState = mState;
        this.mInfectedIndian = mInfectedIndian;
        this.mInfectedForeign = mInfectedForeign;
        this.mRecovered = mRecovered;
        this.mDeaths = mDeaths;

    }

    public String getState() {
        return mState;
    }

    public int getInfectedIndian() {
        return mInfectedIndian;
    }

    public int getInfectedForeign() {
        return mInfectedForeign;
    }

    public int getRecovered() {
        return mRecovered;
    }

    public int getDeaths() {
        return mDeaths;
    }

    public int getTotalConfirmed() {
        return (mInfectedIndian + mInfectedForeign);
    }

    public int getActiveCases() {
        return ((mInfectedIndian + mInfectedForeign) - (mDeaths + mRecovered));
    }

}
