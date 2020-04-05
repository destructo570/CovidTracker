package com.destructo.corona_tracker.View.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.destructo.corona_tracker.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHelp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHelp extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static boolean INSTANCE = false;


    public FragmentHelp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHelp.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHelp newInstance(String param1, String param2) {
        FragmentHelp fragment = new FragmentHelp();
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_help, container, false);

        Button buttonLearnMore = rootView.findViewById(R.id.button_learn_more);
        Button buttonHelpLine = rootView.findViewById(R.id.button_helpline);

        buttonLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),CoronaInfoActivity.class);
                startActivity(intent);
            }
        });

        buttonHelpLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),HelplineActivity.class);
                startActivity(intent);
            }
        });


        return rootView;
    }
}
