package com.destructo.corona_tracker.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.destructo.corona_tracker.model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.model.GlobalCoronaStatistics;
import com.destructo.corona_tracker.repository.GlobalRepository;

import java.util.ArrayList;

public class GlobalViewModel extends ViewModel {

    private GlobalRepository globalRepository;


    public GlobalViewModel() {
        globalRepository = new GlobalRepository();

    }


    public LiveData<GlobalCoronaStatistics> getGlobalSummary() {

        return globalRepository.getGlobalSummary();
    }


    public LiveData<ArrayList<GlobalCoronaCountryStatistics>> getGlobalCountrySummary() {

        return globalRepository.getGlobalCountrySummary();
    }

}
