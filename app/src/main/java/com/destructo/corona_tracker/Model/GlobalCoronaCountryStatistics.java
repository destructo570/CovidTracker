package com.destructo.corona_tracker.Model;

import com.google.gson.annotations.SerializedName;

import java.text.NumberFormat;
import java.util.Locale;

public class GlobalCoronaCountryStatistics {

    @SerializedName("country")
    private String mCountry;
    @SerializedName("cases")
    private int mInfected;
    @SerializedName("active")
    private int mActive;
    @SerializedName("recovered")
    private int mRecovered;
    @SerializedName("deaths")
    private int mDeath;
    @SerializedName("critical")
    private int mCriticalCases;
    @SerializedName("todayCases")
    private int mCasesToday;
    @SerializedName("todayDeaths")
    private int mDeathsToday;
    @SerializedName("casesPerOneMillion")
    private double mCasesPerMillione;
    @SerializedName("deathsPerOneMillion")
    private double mDeathsPerMillion;
    @SerializedName("affectedCountries")
    private int mAffectedCountries;
    @SerializedName("updated")
    private long mLastUpdate;

    public GlobalCoronaCountryStatistics(String mCountry, int mInfected, int mActive, int mRecovered,
                                         int mDeath, int mCriticalCases, int mCasesToday,
                                         int mDeathsToday, double mCasesPerMillione,
                                         double mDeathsPerMillion, int mAffectedCountries, long mLastUpdate) {
        this.mCountry = mCountry;
        this.mInfected = mInfected;
        this.mActive = mActive;
        this.mRecovered = mRecovered;
        this.mDeath = mDeath;
        this.mCriticalCases = mCriticalCases;
        this.mCasesToday = mCasesToday;
        this.mDeathsToday = mDeathsToday;
        this.mCasesPerMillione = mCasesPerMillione;
        this.mDeathsPerMillion = mDeathsPerMillion;
        this.mAffectedCountries = mAffectedCountries;
        this.mLastUpdate = mLastUpdate;
    }

    public String getCountry() {
        return mCountry;
    }

    public int getActive() {
        return mActive;
    }

    public int getRecovered() {
        return mRecovered;
    }

    public int getInfected() {
        return mInfected;
    }

    public int getDeath() {
        return mDeath;
    }

    public int getmCriticalCases() {
        return mCriticalCases;
    }

    public int getCasesToday() {
        return mCasesToday;
    }

    public int getDeathsToday() {
        return mDeathsToday;
    }

    public double getCasesPerMillion() {
        return mCasesPerMillione;
    }

    public double getDeathsPerMillion() {
        return mDeathsPerMillion;
    }

    public int getAffectedCountries() {
        return mAffectedCountries;
    }

    public long getLastUpdate() {
        return mLastUpdate;
    }
}
