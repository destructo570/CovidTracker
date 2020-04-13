package com.destructo.corona_tracker.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.destructo.corona_tracker.model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.model.GlobalCoronaStatistics;
import com.destructo.corona_tracker.repository.GlobalRepository;

import java.util.ArrayList;

public class GlobalViewModel extends ViewModel {

    private GlobalRepository globalRepository;
    private MutableLiveData<GlobalCoronaStatistics> globalSummary;
    private MutableLiveData<ArrayList<GlobalCoronaCountryStatistics>> globalCountrySummary;

    public GlobalViewModel() {
        globalRepository = new GlobalRepository();
    }

    public MutableLiveData<GlobalCoronaStatistics> getGlobalSummary() {
        if(globalSummary == null) {
            globalSummary = globalRepository.getGlobalSummary();
        }
        return globalSummary;
    }

    public MutableLiveData<ArrayList<GlobalCoronaCountryStatistics>> getGlobalCountrySummary() {
        if(globalCountrySummary == null) {
            globalCountrySummary = globalRepository.getGlobalCountrySummary();
        }
        return globalCountrySummary;
    }


}
