package com.destructo.corona_tracker.View.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.destructo.corona_tracker.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLiveMap#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLiveMap extends Fragment implements HandleBackPress{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private WebView covidWebView;

    public FragmentLiveMap() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLiveMap.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLiveMap newInstance(String param1, String param2) {
        FragmentLiveMap fragment = new FragmentLiveMap();
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

        View rootView =  inflater.inflate(R.layout.fragment_live_map, container, false);

        covidWebView = rootView.findViewById(R.id.webview);


        WebSettings settings = covidWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        covidWebView.setWebViewClient(new WebViewClient());
        covidWebView.loadUrl("https://www.bing.com/covid");

        return rootView;
    }

    @Override
    public boolean onBackPressed() {
        if (covidWebView.canGoBack()) {
            covidWebView.goBack();
            return true;
        } else {
            return false;
        }
    }

}
