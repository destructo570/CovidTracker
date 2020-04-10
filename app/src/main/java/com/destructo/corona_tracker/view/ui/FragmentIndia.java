package com.destructo.corona_tracker.view.ui;

import android.animation.ObjectAnimator;
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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.destructo.corona_tracker.model.IndiaStateModel;
import com.destructo.corona_tracker.model.IndiaSummaryModel;
import com.destructo.corona_tracker.view.adapter.IndiaDataRecyclerAdapter;
import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.view.adapter.Utils;
import com.destructo.corona_tracker.viewModel.CountryDetails;
import com.destructo.corona_tracker.viewModel.IndiaViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentIndia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentIndia extends Fragment implements IndiaDataRecyclerAdapter.onStateClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView mTotalInfected;
    private TextView mTotalActive;
    private TextView mTotalDeath;
    private TextView mTotalRecovered;

    private RecyclerView mIndiaStateRecycler;
    private IndiaDataRecyclerAdapter mIndiaStateAdapter;
    private ArrayList<IndiaStateModel> mStateData;

    private IndiaViewModel indiaViewModel;
    public static boolean INSTANCE = false;


    public FragmentIndia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentStatistics.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentIndia newInstance(String param1, String param2) {
        FragmentIndia fragment = new FragmentIndia();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_india, container, false);

        getActivity();

        mIndiaStateRecycler = rootView.findViewById(R.id.india_data_recycler);
        mIndiaStateRecycler.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));

        mTotalInfected = rootView.findViewById(R.id.india_infected_id);
        mTotalActive = rootView.findViewById(R.id.india_active_id);
        mTotalRecovered = rootView.findViewById(R.id.india_recovered_id);
        mTotalDeath = rootView.findViewById(R.id.india_death_id);
        NestedScrollView mNestedScrollView = rootView.findViewById(R.id.india_nsv);

        FloatingActionButton refreshFab = rootView.findViewById(R.id.refresh_fab);

        indiaViewModel = new ViewModelProvider(this).get(IndiaViewModel.class);


        if (checkInternetConnection(getActivity())) {

            observeIndiaSummary(indiaViewModel);
            observeIndiaStateList(indiaViewModel);


        } else {
            Toast toast = Toast.makeText(getContext(), "Check Your Internet Connection", Toast.LENGTH_LONG);
            toast.show();
        }

        refreshFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(refreshFab, "rotation", 0f, 360f).setDuration(800).start();
                observeIndiaSummary(indiaViewModel);
                observeIndiaStateList(indiaViewModel);
            }
        });

        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    refreshFab.hide();
                } else {
                    refreshFab.show();
                }
            }
        });

        return rootView;
    }


    private void observeIndiaStateList(IndiaViewModel viewModel) {

        viewModel.getIndiaStateList().observe(this, stateList -> {

            if (stateList != null) {
                mStateData = stateList;
                mIndiaStateAdapter = new IndiaDataRecyclerAdapter(mStateData,this);
                mIndiaStateRecycler.setAdapter(mIndiaStateAdapter);

            }

        });

    }


    private void observeIndiaSummary(IndiaViewModel viewModel) {

        viewModel.getIndiaSummary().observe(this, new Observer<IndiaSummaryModel>() {
            @Override
            public void onChanged(IndiaSummaryModel indiaSummaryModel) {

                if (indiaSummaryModel != null) {

                    mTotalInfected.setText(Utils.formatNumber(indiaSummaryModel.getTotalInfected()));
                    mTotalActive.setText(Utils.formatNumber(indiaSummaryModel.getTotalActive()));
                    mTotalRecovered.setText(Utils.formatNumber(indiaSummaryModel.getTotalRecovered()));
                    mTotalDeath.setText(Utils.formatNumber(indiaSummaryModel.getTotalDeaths()));

                }
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
    public void onStateClick(int position) {


        Gson gson = new Gson();
        String sum = gson.toJson(mStateData.get(position));
        Intent intent = new Intent(getContext(), StateDetails.class);
        intent.putExtra("SUMMARY", sum);
        startActivity(intent);
    }
}
