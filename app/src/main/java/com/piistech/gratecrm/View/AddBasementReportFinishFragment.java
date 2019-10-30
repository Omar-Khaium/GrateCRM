package com.piistech.gratecrm.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.divyanshu.draw.widget.DrawView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.piistech.gratecrm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBasementReportFinishFragment extends Fragment{

    @BindView(R.id.pm_signature_canvas)
    DrawView mPMSignCanvas;
    @BindView(R.id.pm_signature_canvas_clear)
    FloatingActionButton mPMSignClear;
    @BindView(R.id.homeowner_signature_canvas)
    DrawView mHOSignCanvas;
    @BindView(R.id.homeowner_signature_canvas_clear)
    FloatingActionButton mHOSignClear;

    private View fragmentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView =  inflater.inflate(R.layout.step_add_basement_report_finish, container, false);
        ButterKnife.bind(this, fragmentView);

        mPMSignCanvas.setStrokeWidth(3.0f);
        mHOSignCanvas.setStrokeWidth(3.0f);

        mPMSignClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPMSignCanvas.clearCanvas();
            }
        });

        mHOSignClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHOSignCanvas.clearCanvas();
            }
        });
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentView = null;
        System.gc();
    }
}
