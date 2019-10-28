package com.piistech.gratecrm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;
import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.Model.Repair;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.CustomerAdapter;
import com.piistech.gratecrm.Utils.Adapter.RepairAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerDetailsActivity extends AppCompatActivity {

    @BindView(R.id.customer_details_repair_list)
    RecyclerView mList;
    @BindView(R.id.customer_details_back)
    ImageView mBack;
    @BindView(R.id.customer_details_add_basement)
    MaterialCardView mAddBasementReport;
    @BindView(R.id.customer_details_add_recommended_level)
    MaterialCardView mRecommendedLevel;
    @BindView(R.id.customer_details_add_estimate)
    MaterialCardView mAddEstimate;

    private ArrayList<Repair> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        ButterKnife.bind(this);

        getData();
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new RepairAdapter(arrayList,this));

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mAddBasementReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AddBasementReportActivity.class));
            }
        });

        mAddEstimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddEstimateActivity.class));
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getData() {
        arrayList = new ArrayList<Repair>(){
            {
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
            }
        };
    }

    @Override
    protected void onDestroy() {
        mList = null;
        arrayList = null;
        mAddEstimate = null;
        mRecommendedLevel = null;
        mAddBasementReport = null;
        mBack = null;
        System.gc();
        super.onDestroy();
    }
}
