package com.destructo.corona_tracker.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.destructo.corona_tracker.model.IndiaStateModel;
import com.destructo.corona_tracker.model.IndiaSummaryModel;
import com.destructo.corona_tracker.repository.IndiaRepository;

import java.util.ArrayList;

public class IndiaViewModel extends ViewModel {

    private IndiaRepository indiaRepository;

    public IndiaViewModel() {

        indiaRepository = new IndiaRepository();

    }

    public LiveData<ArrayList<IndiaStateModel>> getIndiaStateList() {

        return indiaRepository.getIndiaStates();
    }

    public LiveData<IndiaSummaryModel> getIndiaSummary() {

        return indiaRepository.getIndiaSummary();
    }

}
