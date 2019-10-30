package com.piistech.gratecrm.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.PagerAdapter;
import com.piistech.gratecrm.Utils.NonSwipeableViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBasementReportActivity extends AppCompatActivity {

    @BindView(R.id.add_basement_report_close)
    FloatingActionButton mBack;
    @BindView(R.id.add_basement_report_container)
    NonSwipeableViewPager mPager;
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
        adapter.addFragment(new AddBasementReportHumidityFragment());
        adapter.addFragment(new AddBasementReportVisualInspectionFragment());
        adapter.addFragment(new AddBasementReportCustomerEvaluationFragment());
        adapter.addFragment(new AddBasementDrawingFragment());
        adapter.addFragment(new AddBasementReportFinishFragment());
        mPager.setAdapter(adapter);
        
        mPagerBack.setVisibility(View.GONE);

        mPagerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        });

        mPagerNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
            }
        });

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPagerBack.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
                mPagerNext.setText(position == 4 ? "Finish" : "Next");
                mPagerNext.setBackgroundColor(position == 4 ? getResources().getColor(android.R.color.holo_green_light) : getResources().getColor(android.R.color.transparent));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
