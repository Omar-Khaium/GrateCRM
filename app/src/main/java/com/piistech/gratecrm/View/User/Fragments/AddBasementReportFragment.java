package com.piistech.gratecrm.View.User.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.divyanshu.draw.widget.DrawView;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jaredrummler.materialspinner.MaterialSpinnerAdapter;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.ColorAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.COLOR_ARRAY;

public class AddBasementReportFragment extends Fragment {

    private ArrayList<String> currentOutsideConditionsArrayList = new ArrayList<>();
    private ArrayList<String> ratingArrayList = new ArrayList<>();
    private ArrayList<String> heatArrayList = new ArrayList<>();
    private ArrayList<String> airArrayList = new ArrayList<>();
    private ArrayList<String> booleanArrayList = new ArrayList<>();
    private ArrayList<String> dehumidifierArrayList = new ArrayList<>();
    private androidx.appcompat.app.AlertDialog alert,signatureAlert;
    Bitmap lastCanvasBitmap = null;
    Bitmap lastPMSignatureBitmap = null;
    Bitmap lastHOSignatureBitmap = null;

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
    @BindView(R.id.fragment_add_basement_report_drawing)
    ImageView mDrawing;
    @BindView(R.id.pm_signature_canvas)
    ImageView mPMDrawing;
    @BindView(R.id.hw_signature_canvas)
    ImageView mHODrawing;

    private android.app.AlertDialog mColorPickerAlert;
    private android.app.AlertDialog.Builder mColorPickerBuilder;
    private View colorView;
    private String lastColor = COLOR_ARRAY.get(COLOR_ARRAY.size()-2).getColor();
    private float lastStroke = 2.0f;
    private int strokeCounter = 1;

    DrawView mCanvas;
    DrawView mPMDrawingCanvas;
    DrawView mHODrawingCanvas;
    FloatingActionButton mUndo;
    FloatingActionButton mRedo;
    FloatingActionButton mStroke;
    FloatingActionButton mErase;
    FloatingActionButton mBrush;
    FloatingActionButton mColorPicker;
    FloatingActionButton mClear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_basement_report, container, false);
        ButterKnife.bind(this, view);

        init();

        mColorPickerBuilder = new android.app.AlertDialog.Builder(getContext());
        colorView = inflater.inflate(R.layout.layout_color_picker, container, false);
        mColorPickerBuilder.setView(colorView);

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

        mDrawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_drawing, new LinearLayout(getContext()), false);
                Chip close = view.findViewById(R.id.close);

                mCanvas = view.findViewById(R.id.draw_view);
                mUndo = view.findViewById(R.id.undo);
                mRedo = view.findViewById(R.id.redo);
                mStroke = view.findViewById(R.id.stroke);
                mErase = view.findViewById(R.id.erase);
                mBrush = view.findViewById(R.id.brush);
                mColorPicker = view.findViewById(R.id.color);
                mClear = view.findViewById(R.id.clear);
                getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                mUndo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCanvas.undo();
                    }
                });

                mRedo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCanvas.redo();
                    }
                });

                mClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCanvas.clearCanvas();
                    }
                });

                mErase.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCanvas.setColor(Color.WHITE);
                        mCanvas.setStrokeWidth(16f);
                    }
                });

                mBrush.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCanvas.setColor(Color.parseColor(lastColor));
                        mCanvas.setStrokeWidth(lastStroke);
                    }
                });

                mColorPicker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (colorView.getParent() != null) {
                            ((ViewGroup) colorView.getParent()).removeAllViews();
                        }
                        mColorPickerAlert = mColorPickerBuilder.create();
                        mColorPickerAlert.show();
                        RecyclerView mColorList = colorView.findViewById(R.id.color_list);
                        mColorList.setLayoutManager(new GridLayoutManager(getContext(), 5));
                        mColorList.setAdapter(new ColorAdapter(getContext()));
                    }
                });

                mStroke.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        strokeCounter++;
                        if (strokeCounter>4) strokeCounter=1;
                        switch (strokeCounter) {
                            case 1:
                                mStroke.setImageResource(R.drawable.ic_stroke);
                                lastStroke = 2.0f;
                                mCanvas.setStrokeWidth(lastStroke);
                                break;
                            case 2:
                                mStroke.setImageResource(R.drawable.ic_stroke_4);
                                lastStroke = 4.0f;
                                mCanvas.setStrokeWidth(lastStroke);
                                break;
                            case 3:
                                mStroke.setImageResource(R.drawable.ic_stroke_8);
                                lastStroke = 8.0f;
                                mCanvas.setStrokeWidth(lastStroke);
                                break;
                            case 4:
                                mStroke.setImageResource(R.drawable.ic_stroke_16);
                                lastStroke = 16.0f;
                                mCanvas.setStrokeWidth(lastStroke);
                                break;
                        }
                    }
                });

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                mBuilder.setView(view);
                alert = mBuilder.create();
                alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert.show();
                alert.setCancelable(false);

                if (lastCanvasBitmap !=null) mCanvas.setBackgroundDrawable(new BitmapDrawable(getResources(), lastCanvasBitmap));

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();


                        Bitmap bitmap = Bitmap.createBitmap(
                                mCanvas.getWidth(),
                                mCanvas.getHeight(),
                                Bitmap.Config.ARGB_8888);
                        Canvas c = new Canvas(bitmap);
                        mCanvas.draw(c);
                        lastCanvasBitmap = bitmap;

                        Glide.with(getContext()).load(bitmap).into(mDrawing);
                    }
                });
            }
        });

        mPMDrawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_signature, new LinearLayout(getContext()), false);
                Chip close = view.findViewById(R.id.close);
                Chip reset = view.findViewById(R.id.reset);
                mPMDrawingCanvas = view.findViewById(R.id.draw_view);
                getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mPMDrawingCanvas.setColor(getActivity().getResources().getColor(R.color.colorAccent));
                mPMDrawingCanvas.setStrokeWidth(8.0f);

                if (lastPMSignatureBitmap !=null) mPMDrawingCanvas.setBackgroundDrawable(new BitmapDrawable(getResources(), lastPMSignatureBitmap));

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                mBuilder.setView(view);
                signatureAlert = mBuilder.create();
                signatureAlert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                signatureAlert.show();
                signatureAlert.setCancelable(false);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        signatureAlert.dismiss();

                        Bitmap bitmap = Bitmap.createBitmap(
                                mPMDrawingCanvas.getWidth(),
                                mPMDrawingCanvas.getHeight(),
                                Bitmap.Config.ARGB_8888);
                        Canvas c = new Canvas(bitmap);
                        mPMDrawingCanvas.draw(c);
                        lastPMSignatureBitmap = bitmap;

                        Glide.with(getContext()).load(bitmap).into(mPMDrawing);
                    }
                });

                reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPMDrawingCanvas.clearCanvas();
                    }
                });
            }
        });

        mHODrawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_signature, new LinearLayout(getContext()), false);
                Chip close = view.findViewById(R.id.close);
                Chip reset = view.findViewById(R.id.reset);
                mHODrawingCanvas = view.findViewById(R.id.draw_view);
                getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mHODrawingCanvas.setColor(getActivity().getResources().getColor(R.color.colorAccent));
                mHODrawingCanvas.setStrokeWidth(8.0f);

                if (lastHOSignatureBitmap !=null) mHODrawingCanvas.setBackgroundDrawable(new BitmapDrawable(getResources(), lastHOSignatureBitmap));

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                mBuilder.setView(view);
                signatureAlert = mBuilder.create();
                signatureAlert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                signatureAlert.show();
                signatureAlert.setCancelable(false);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        signatureAlert.dismiss();

                        Bitmap bitmap = Bitmap.createBitmap(
                                mHODrawingCanvas.getWidth(),
                                mHODrawingCanvas.getHeight(),
                                Bitmap.Config.ARGB_8888);
                        Canvas c = new Canvas(bitmap);
                        mHODrawingCanvas.draw(c);
                        lastHOSignatureBitmap = bitmap;

                        Glide.with(getContext()).load(bitmap).into(mHODrawing);
                    }
                });

                reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mHODrawingCanvas.clearCanvas();
                    }
                });
            }
        });

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mReceiver);
        System.gc();
    }

    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mReceiver, new IntentFilter("receiveColor"));
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mColorPickerAlert.dismiss();
            lastColor = intent.getStringExtra("color");
            mCanvas.setColor(Color.parseColor(lastColor));
        }
    };
}
