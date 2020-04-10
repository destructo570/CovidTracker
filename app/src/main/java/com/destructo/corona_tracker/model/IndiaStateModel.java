package com.destructo.corona_tracker.model;

public class IndiaStateModel {

    private String mState;
    private int mInfectedIndian;
    private int mInfectedForeign;
    private int mRecovered;
    private int mDeaths;
    private int mTotalInfected;


    public IndiaStateModel(String State, int InfectedIndian, int InfectedForeign, int Recovered, int Deaths, int TotalInfected) {
        this.mState = State;
        this.mInfectedIndian = InfectedIndian;
        this.mInfectedForeign = InfectedForeign;
        this.mRecovered = Recovered;
        this.mDeaths = Deaths;
        this.mTotalInfected = TotalInfected;

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
        return mTotalInfected;
    }

    public int getActiveCases() {
        return ((mTotalInfected) - (mDeaths + mRecovered));
    }

}
