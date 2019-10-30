package com.piistech.gratecrm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.piistech.gratecrm.Model.Estimate;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.EstimateAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddEstimateActivity extends AppCompatActivity {

    @BindView(R.id.estimate_list)
    RecyclerView mList;
    @BindView(R.id.estimate_close)
    FloatingActionButton mBack;
    @BindView(R.id.add_estimate_all_customer)
    RelativeLayout mAllCustomer;

    private ArrayList<Estimate> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_estimate);
        ButterKnife.bind(this);
        getData();

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mAllCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddEstimateActivity.this, DashboardActivity.class));
            }
        });

        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new EstimateAdapter(arrayList,this));
    }

    private void getData() {
        arrayList = new ArrayList<Estimate>(){
            {
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
                add(new Estimate("0", "Dummy Product", "Placeholder Description", "24", "25%", "$1,200"));
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mList = null;
        arrayList = null;
        mBack = null;
        System.gc();
    }
}
