package com.destructo.corona_tracker.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.destructo.corona_tracker.Model.IndiaCoronaStatistics;
import com.destructo.corona_tracker.Model.IndiaStateModel;
import com.destructo.corona_tracker.Model.IndiaSummaryModel;
import com.destructo.corona_tracker.Repository.IndiaRepository;

public class IndiaViewModel extends ViewModel {

    private IndiaRepository indiaRepository;
    private IndiaCoronaStatistics indiaCoronaStatistics;
    private IndiaStateModel indiaStateData;
    private IndiaSummaryModel indiaSummary;

    public IndiaViewModel() {

        indiaRepository = new IndiaRepository();


    }


    public LiveData<IndiaCoronaStatistics> getIndiaStateList() {

        return indiaRepository.getIndiaStats();
    }
}
