package com.destructo.corona_tracker.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.destructo.corona_tracker.Model.HelplineNumberModel;
import com.destructo.corona_tracker.R;
import com.destructo.corona_tracker.View.Adapter.HelplineNumberAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelplineActivity extends AppCompatActivity implements HelplineNumberAdapter.onHelpClickListener {


    RecyclerView recyclerView;
    HelplineNumberAdapter adapter;
    ArrayList<HelplineNumberModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        addData();

        recyclerView = findViewById(R.id.recycler_helpline);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new HelplineNumberAdapter(data,this);

        recyclerView.setAdapter(adapter);
    }


    private void addData(){
        data = new ArrayList<>();
        data.add(new HelplineNumberModel("Andaman and Nicobar Islands","+91-3192-232102"));
        data.add(new HelplineNumberModel("Andhra Pradesh","+91-866-2410978"));
        data.add(new HelplineNumberModel("Arunachal Pradesh","+91-9436055743"));
        data.add(new HelplineNumberModel("Assam","+91-6913347770"));
        data.add(new HelplineNumberModel("Bihar","104"));
        data.add(new HelplineNumberModel("Chandigarh","+91-9779558282"));
        data.add(new HelplineNumberModel("Chhattisgarh","104"));
        data.add(new HelplineNumberModel("Dadra and Nagar Haveli","104"));
        data.add(new HelplineNumberModel("Daman & Diu","104"));
        data.add(new HelplineNumberModel("Delhi","+91-11-22307145"));
        data.add(new HelplineNumberModel("Goa","104"));
        data.add(new HelplineNumberModel("Gujarat","104"));
        data.add(new HelplineNumberModel("Haryana","+91-8558893911"));
        data.add(new HelplineNumberModel("Himachal Pradesh","104"));
        data.add(new HelplineNumberModel("Jammu and Kashmir","+91-191-2520982"));
        data.add(new HelplineNumberModel("Jammu and Kashmir","+91-194-2440283"));
        data.add(new HelplineNumberModel("Jharkhand","104"));
        data.add(new HelplineNumberModel("Karnataka","104"));
        data.add(new HelplineNumberModel("Kerala","+91-471-2552056"));
        data.add(new HelplineNumberModel("Ladakh","+91-1982-256462"));
        data.add(new HelplineNumberModel("Lakshadweep","104"));
        data.add(new HelplineNumberModel("Madhya Pradesh","+91-755-2527177"));
        data.add(new HelplineNumberModel("Maharashtra","+91-20-26127394"));
        data.add(new HelplineNumberModel("Manipur","+91-3852411668"));
        data.add(new HelplineNumberModel("Meghalaya","108"));
        data.add(new HelplineNumberModel("Mizoram","102"));
        data.add(new HelplineNumberModel("Nagaland","+91-7005539653"));
        data.add(new HelplineNumberModel("Odisha","+91-9439994859"));
        data.add(new HelplineNumberModel("Puducherry","104"));
        data.add(new HelplineNumberModel("Punjab","104"));
        data.add(new HelplineNumberModel("Rajasthan","+91-141-2225624"));
        data.add(new HelplineNumberModel("Sikkim","104"));
        data.add(new HelplineNumberModel("Tamil Nadu","+91-44-29510500"));
        data.add(new HelplineNumberModel("Telengana","104"));
        data.add(new HelplineNumberModel("Tripura","+91-381-2315879"));
        data.add(new HelplineNumberModel("Uttarakhand","104"));
        data.add(new HelplineNumberModel("Uttar Pradesh","18001805145"));
        data.add(new HelplineNumberModel("West Bengal","1800313444222"));
        data.add(new HelplineNumberModel("West Bengal","+91-3323412600"));

    }

    @Override
    public void onHelpClick(int position) {
        HelplineNumberModel mModel = data.get(position);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mModel.getHelpLineNumber()));
        startActivity(intent);
    }
}
