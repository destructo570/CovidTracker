package com.destructo.corona_tracker.View.UI;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.destructo.corona_tracker.Model.IndiaSummaryModel;
import com.destructo.corona_tracker.View.Adapter.IndiaDataRecyclerAdapter;
import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.View.Adapter.Utils;
import com.destructo.corona_tracker.ViewModel.IndiaViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentIndia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentIndia extends Fragment {
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
    private FloatingActionButton myFab;

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

        myFab = rootView.findViewById(R.id.refresh_fab);

        indiaViewModel = new ViewModelProvider(this).get(IndiaViewModel.class);


        if(checkInternetConnection(getActivity())) {

            observeIndiaStateList(indiaViewModel);

        }else{
            Toast toast = Toast.makeText(getContext(),"Check Your Internet Connection",Toast.LENGTH_LONG);
            toast.show();
        }

        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observeIndiaStateList(indiaViewModel);

            }
        });


        return rootView;
    }


    private void observeIndiaStateList(IndiaViewModel viewModel) {

        viewModel.getIndiaStateList().observe(this, indiaCoronaStatistics -> {

            if(indiaCoronaStatistics != null) {

                IndiaSummaryModel mSum = indiaCoronaStatistics.getIndiaSummary();

                mTotalInfected.setText(Utils.formatNumber(mSum.getTotalInfected()));
                mTotalActive.setText(Utils.formatNumber(mSum.getTotalActive()));
                mTotalRecovered.setText(Utils.formatNumber(mSum.getTotalRecovered()));
                mTotalDeath.setText(Utils.formatNumber(mSum.getTotalDeaths()));

                mIndiaStateAdapter = new IndiaDataRecyclerAdapter(indiaCoronaStatistics.getStateList());
                mIndiaStateRecycler.setAdapter(mIndiaStateAdapter);

            }

        });

    }


    private boolean checkInternetConnection (Context context){

        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }
}
