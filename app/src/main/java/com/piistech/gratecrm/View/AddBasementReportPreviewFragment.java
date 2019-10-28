package com.piistech.gratecrm.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.piistech.gratecrm.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

public class AddBasementReportPreviewFragment extends Fragment{

    View fragmentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView =  inflater.inflate(R.layout.step_add_basement_report_preview, container, false);
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentView = null;
        System.gc();
    }
}
