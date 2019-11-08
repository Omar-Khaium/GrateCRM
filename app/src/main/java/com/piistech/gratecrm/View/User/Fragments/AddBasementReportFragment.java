package com.piistech.gratecrm.View.User.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jaredrummler.materialspinner.MaterialSpinnerAdapter;
import com.piistech.gratecrm.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBasementReportFragment extends Fragment {

    private ArrayList<String> currentOutsideConditionsArrayList = new ArrayList<>();
    private ArrayList<String> ratingArrayList = new ArrayList<>();
    private ArrayList<String> heatArrayList = new ArrayList<>();
    private ArrayList<String> airArrayList = new ArrayList<>();
    private ArrayList<String> booleanArrayList = new ArrayList<>();
    private ArrayList<String> dehumidifierArrayList = new ArrayList<>();

    @BindView(R.id.fragment_add_basement_report_current_outside_conditions)
    MaterialSpinner mCurrentOutsideConditionsSpinner;
    @BindView(R.id.fragment_add_basement_report_heat)
    MaterialSpinner mHeatSpinner;
    @BindView(R.id.fragment_add_basement_report_air)
    MaterialSpinner mAirSpinner;
    @BindView(R.id.fragment_add_basement_report_basement_dehumidifier)
    MaterialSpinner mBasementDehumidifierSpinner;
    @BindView(R.id.fragment_add_basement_report_ground_water)
    MaterialSpinner mGroundWaterSpinner;
    @BindView(R.id.fragment_add_basement_report_ground_water_rating)
    MaterialSpinner mGroundWaterRatingSpinner;
    @BindView(R.id.fragment_add_basement_report_iron_bacteria)
    MaterialSpinner mIronBacteriaSpinner;
    @BindView(R.id.fragment_add_basement_report_iron_bacteria_rating)
    MaterialSpinner mIronBacteriaRatingSpinner;
    @BindView(R.id.fragment_add_basement_report_condensation)
    MaterialSpinner mCondensationSpinner;
    @BindView(R.id.fragment_add_basement_report_condensation_rating)
    MaterialSpinner mCondensationRatingSpinner;
    @BindView(R.id.fragment_add_basement_report_wall_cracks)
    MaterialSpinner mWallCracksSpinner;
    @BindView(R.id.fragment_add_basement_report_wall_cracks_rating)
    MaterialSpinner mWallCracksRatingSpinner;
    @BindView(R.id.fragment_add_basement_report_floor_cracks)
    MaterialSpinner mFloorCracksSpinner;
    @BindView(R.id.fragment_add_basement_report_floor_cracks_rating)
    MaterialSpinner mFloorCracksRatingSpinner;
    @BindView(R.id.fragment_add_basement_report_existing_sump_pump)
    MaterialSpinner mExistingSumpPumpSpinner;
    @BindView(R.id.fragment_add_basement_report_existing_drainage_system)
    MaterialSpinner mExistingDrainageSystemSpinner;
    @BindView(R.id.fragment_add_basement_report_radon_system)
    MaterialSpinner mRadonSystemSpinner;
    @BindView(R.id.fragment_add_basement_report_dryer_vent_to_code)
    MaterialSpinner mDryerVentToCodeSpinner;
    @BindView(R.id.fragment_add_basement_report_bulkhead)
    MaterialSpinner mBulkheadSpinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_basement_report, container, false);
        ButterKnife.bind(this, view);

        init();

        mCurrentOutsideConditionsSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), currentOutsideConditionsArrayList));
        mHeatSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), heatArrayList));
        mAirSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), airArrayList));
        mBasementDehumidifierSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), dehumidifierArrayList));
        mGroundWaterSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mGroundWaterRatingSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), ratingArrayList));
        mIronBacteriaSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mIronBacteriaRatingSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), ratingArrayList));
        mCondensationSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mCondensationRatingSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), ratingArrayList));
        mWallCracksSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mWallCracksRatingSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), ratingArrayList));
        mFloorCracksSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mFloorCracksRatingSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), ratingArrayList));
        mExistingSumpPumpSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mExistingDrainageSystemSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mRadonSystemSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mDryerVentToCodeSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));
        mBulkheadSpinner.setAdapter(new MaterialSpinnerAdapter<>(getContext(), booleanArrayList));

        return view;
    }

    private void init() {
        currentOutsideConditionsArrayList = new ArrayList<String>() {
            {
                add("Please select one");
                add("Sunny");
                add("Dark");
            }
        };

        ratingArrayList = new ArrayList<String>() {
            {
                add("Please select one");
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
                add("7");
                add("8");
                add("9");
                add("10");
            }
        };

        heatArrayList = new ArrayList<String>() {
            {
                add("Please select one");
                add("Central");
                add("Outside");
                add("One side");
            }
        };

        airArrayList = new ArrayList<String>() {
            {
                add("Please select one");
                add("Heat water");
                add("Cold water");
            }
        };

        booleanArrayList = new ArrayList<String>() {
            {
                add("Please select one");
                add("Yes");
                add("No");
            }
        };

        dehumidifierArrayList = new ArrayList<String>() {
            {
                add("Please select one");
                add("Yes 40 pint");
                add("Yes 50 pint");
                add("Yes 60 pint");
            }
        };
    }
}
