package com.destructo.corona_tracker.Model;

import com.google.gson.annotations.SerializedName;

public class GlobalCoronaStatistics {


    @SerializedName("cases")
    private int mTotalInfected;
    @SerializedName("recovered")
    private int mTotalRecovered;
    @SerializedName("active")
    private int mTotalActive;
    @SerializedName("deaths")
    private int mTotalDeaths;
    @SerializedName("critical")
    private int mTotalCriticalCases;
    @SerializedName("todayCases")
    private int mTotalCasesToday;
    @SerializedName("todayDeaths")
    private int mTotalDeathsToday;
    @SerializedName("casesPerOneMillion")
    private double mTotalCasesPerMillione;
    @SerializedName("deathsPerOneMillion")
    private double mTotalDeathsPerMillion;
    @SerializedName("affectedCountries")
    private int mTotalAffectedCountries;
    @SerializedName("updated")
    private long mLastUpdate;


    public GlobalCoronaStatistics(
            int mTotalInfected, int mTotalRecovered, int mTotalActive,
            int mTotalDeaths, int mTotalCriticalCases, int mTotalCasesToday,
            int mTotalDeathsToday, double mTotalCasesPerMillione,
            double mTotalDeathsPerMillion, int mTotalAffectedCountries,
            long mLastUpdate)
    {
        this.mTotalInfected = mTotalInfected;
        this.mTotalRecovered = mTotalRecovered;
        this.mTotalActive = mTotalActive;
        this.mTotalDeaths = mTotalDeaths;
        this.mTotalCriticalCases = mTotalCriticalCases;
        this.mTotalCasesToday = mTotalCasesToday;
        this.mTotalDeathsToday = mTotalDeathsToday;
        this.mTotalCasesPerMillione = mTotalCasesPerMillione;
        this.mTotalDeathsPerMillion = mTotalDeathsPerMillion;
        this.mTotalAffectedCountries = mTotalAffectedCountries;
        this.mLastUpdate = mLastUpdate;
    }

    public int getTotalInfected() {
        return mTotalInfected;
    }

    public int getTotalRecovered() {
        return mTotalRecovered;
    }

    public int getTotalActive() {
        return mTotalActive;
    }

    public int getTotalDeaths() {
        return mTotalDeaths;
    }

    public int getTotalCriticalCases() {
        return mTotalCriticalCases;
    }

    public int getTodayCasesToday() {
        return mTotalCasesToday;
    }

    public int getTotalDeathsToday() {
        return mTotalDeathsToday;
    }

    public double getTotalCasesPerMillion() {
        return mTotalCasesPerMillione;
    }

    public double getTotalDeathsPerMillion() {
        return mTotalDeathsPerMillion;
    }

    public int getTotalAffectedCountries() {
        return mTotalAffectedCountries;
    }

    public long getLastUpdate() {
        return mLastUpdate;
    }
}
