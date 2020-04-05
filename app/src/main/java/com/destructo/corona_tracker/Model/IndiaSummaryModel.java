package com.destructo.corona_tracker.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IndiaSummaryModel {

    @SerializedName("total")
    private int mTotalInfected;
    @SerializedName("confirmedCasesIndian")
    private int mTotalCasesIndian;
    @SerializedName("confirmedCasesForeign")
    private int mTotalCasesForeign;
    @SerializedName("discharged")
    private int mTotalRecovered;
    @SerializedName("deaths")
    private int mTotalDeaths;

    public IndiaSummaryModel(int mTotalInfected, int mTotalCasesIndian, int mTotalCasesForeign, int mTotalRecovered, int mTotalDeaths) {
        this.mTotalInfected = mTotalInfected;
        this.mTotalCasesIndian = mTotalCasesIndian;
        this.mTotalCasesForeign = mTotalCasesForeign;
        this.mTotalRecovered = mTotalRecovered;
        this.mTotalDeaths = mTotalDeaths;
    }

    public int getTotalInfected() {
        return mTotalInfected;
    }

    public int getTotalCasesIndian() {
        return mTotalCasesIndian;
    }

    public int getTotalCasesForeign() {
        return mTotalCasesForeign;
    }

    public int getTotalRecovered() {
        return mTotalRecovered;
    }

    public int getTotalDeaths() {
        return mTotalDeaths;
    }

    public int getTotalActive() {
        int active = mTotalInfected - (mTotalRecovered + mTotalDeaths);
        return active;
    }
}
