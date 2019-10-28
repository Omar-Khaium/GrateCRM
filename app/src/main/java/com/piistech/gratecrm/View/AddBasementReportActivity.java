package com.piistech.gratecrm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.PagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBasementReportActivity extends AppCompatActivity{

    @BindView(R.id.add_basement_report_close)
    FloatingActionButton mBack;
    @BindView(R.id.add_basement_report_container)
    ViewPager mPager;
    @BindView(R.id.add_basement_report_container_previous)
    Button mPagerBack;
    @BindView(R.id.add_basement_report_container_next)
    Button mPagerNext;

    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_basement_report);
        ButterKnife.bind(this);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AddBasementReportPreviewFragment());
        adapter.addFragment(new AddBasementReportHumidityFragment());
        adapter.addFragment(new AddBasementReportVisualInspectionFragment());
        adapter.addFragment(new AddBasementReportPreviewFragment());
        mPager.setAdapter(adapter);

        mPagerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPager.getCurrentItem()>0)
                    mPager.setCurrentItem(mPager.getCurrentItem()-1);
            }
        });

        mPagerNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(mPager.getCurrentItem()+1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter = null;
        mPager = null;
        mBack = null;
        System.gc();
    }
}
