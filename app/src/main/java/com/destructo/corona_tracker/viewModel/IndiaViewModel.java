package com.destructo.corona_tracker.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.destructo.corona_tracker.model.IndiaStateModel;
import com.destructo.corona_tracker.model.IndiaSummaryModel;
import com.destructo.corona_tracker.repository.IndiaRepository;

import java.util.ArrayList;

public class IndiaViewModel extends ViewModel {

    private IndiaRepository indiaRepository;
    private MutableLiveData<ArrayList<IndiaStateModel>> indiaStateList;
    private MutableLiveData<IndiaSummaryModel> indiaSummary;

    public IndiaViewModel() {
        indiaRepository = new IndiaRepository();
    }

    public MutableLiveData<ArrayList<IndiaStateModel>> getIndiaStateList() {
        if (indiaStateList == null) {
            indiaStateList = indiaRepository.getIndiaStates();
        }
        return indiaStateList;
    }

    public MutableLiveData<IndiaSummaryModel> getIndiaSummary() {
        if (indiaStateList == null) {
            indiaSummary = indiaRepository.getIndiaSummary();
        }
        return indiaSummary;
    }
}
