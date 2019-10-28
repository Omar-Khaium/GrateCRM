package com.piistech.gratecrm.Utils.Adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import java.util.ArrayList;

public class AddBasementStepperAdapter extends AbstractFragmentStepAdapter {

    private ArrayList<Fragment> arrayList;
    private Context context;
    private FragmentManager manager;

    public AddBasementStepperAdapter(Context context, ArrayList<Fragment> arrayList, FragmentManager manager) {
        super(manager, context);
        this.arrayList = arrayList;
        this.context = context;
        this.manager = manager;
    }

    @Override
    public Step createStep(int position) {
        Bundle b = new Bundle();
        b.putInt("key", position);
        arrayList.get(position).setArguments(b);
        return (Step) arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {

        StepViewModel.Builder builder = new StepViewModel.Builder(context)
                .setTitle(arrayList.get(position).toString());

        switch (position) {
            case 0:
                builder
                        .setEndButtonLabel("Next")
                        .setBackButtonVisible(false);
                break;
            case 1:
                builder
                        .setEndButtonLabel("Proceed")
                        .setBackButtonLabel("Back");
                break;
            case 2:
                builder
                        .setBackButtonLabel("Back")
                        .setEndButtonLabel("Proceed");
                break;
            case 3:
                builder
                        .setBackButtonVisible(false)
                        .setEndButtonLabel("Finish");
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return builder.create();
    }
}