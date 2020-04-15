package com.destructo.corona_tracker.view.ui;


import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.destructo.corona_tracker.model.GlobalCoronaStatistics;
import com.destructo.corona_tracker.viewModel.CountryDetails;
import com.destructo.corona_tracker.model.GlobalCoronaCountryStatistics;
import com.destructo.corona_tracker.view.adapter.GlobalDataRecyclerAdapter;
import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.view.adapter.Utils;
import com.destructo.corona_tracker.viewModel.GlobalViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGlobal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGlobal extends Fragment implements GlobalDataRecyclerAdapter.onCountryClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private GlobalDataRecyclerAdapter mAdapter;
    private RecyclerView mRecylcer;

    private TextView totalInfection;
    private TextView totalDeath;
    private TextView totalRecovered;
    private TextView totalActive;
    private ArrayList<GlobalCoronaCountryStatistics> countryData;
    private GlobalCoronaStatistics globalData;
    private int numInstance;

    private GlobalViewModel globalViewModel;
    public static boolean INSTANCE = false;
    public static int FLAG = 1;

    public FragmentGlobal() {
        // Required empty public constructor
    }


    public static FragmentGlobal newInstance(String param1, String param2) {
        FragmentGlobal fragment = new FragmentGlobal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        globalViewModel = new ViewModelProvider(this).get(GlobalViewModel.class);

    }

    @SuppressLint("ShowToast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(getActivity()).setTitle(R.string.title_global);
        View rootView = inflater.inflate(R.layout.fragment_global, container, false);
        mRecylcer = rootView.findViewById(R.id.global_data_recycler);
        mRecylcer.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));
        totalInfection = rootView.findViewById(R.id.global_infection_id);
        totalDeath = rootView.findViewById(R.id.global_death_id);
        totalRecovered = rootView.findViewById(R.id.global_recovered_id);
        totalActive = rootView.findViewById(R.id.global_active_id);
        Button globalStat = rootView.findViewById(R.id.global_more_button);

        if (checkInternetConnection(Objects.requireNonNull(getActivity()))) {

            observeGlobalSummary(globalViewModel);
            observeGlobalCountry(globalViewModel);

        } else {
            Toast toast = Toast.makeText(getContext(), "Check Your Internet Connection", Toast.LENGTH_LONG);
            toast.show();
        }

        globalStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (globalData != null) {

                    Gson gson = new Gson();
                    String sum = gson.toJson(globalData);
                    Intent intent = new Intent(getContext(), GlobalDetails.class);
                    intent.putExtra("SUMMARY", sum);
                    startActivity(intent);



                }
            }
        });

        return rootView;
    }


    private void observeGlobalSummary(GlobalViewModel viewModel) {
        viewModel.getGlobalSummary().observe(getViewLifecycleOwner(), new Observer<GlobalCoronaStatistics>() {
            @Override
            public void onChanged(GlobalCoronaStatistics globalCoronaStatistics) {



                if (globalCoronaStatistics != null) {

                    globalData = globalCoronaStatistics;
                    totalInfection.setText(Utils.formatNumber(globalCoronaStatistics.getTotalInfected()));
                    totalDeath.setText(Utils.formatNumber(globalCoronaStatistics.getTotalDeaths()));
                    totalRecovered.setText(Utils.formatNumber(globalCoronaStatistics.getTotalRecovered()));
                    totalActive.setText(Utils.formatNumber(globalCoronaStatistics.getTotalActive()));
                }

            }
        });
    }

    private void observeGlobalCountry(GlobalViewModel viewModel) {

        viewModel.getGlobalCountrySummary().observe(getViewLifecycleOwner(), globalCoronaCountryStats -> {

            if (globalCoronaCountryStats != null ) {

                countryData = globalCoronaCountryStats;
                mAdapter = new GlobalDataRecyclerAdapter(globalCoronaCountryStats, this);
                mRecylcer.setAdapter(mAdapter);


            }


        });
    }


    private boolean checkInternetConnection(Context context) {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    @Override
    public void onCountryClick(int position) {

        Gson gson = new Gson();
        String sum = gson.toJson(countryData.get(position));
        Intent intent = new Intent(getContext(), CountryDetails.class);
        intent.putExtra("SUMMARY", sum);
        startActivity(intent);
    }


}
