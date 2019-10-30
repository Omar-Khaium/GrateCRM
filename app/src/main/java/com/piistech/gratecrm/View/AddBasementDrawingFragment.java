package com.piistech.gratecrm.View;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.divyanshu.draw.widget.DrawView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.ColorAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.COLOR_ARRAY;

public class AddBasementDrawingFragment extends Fragment{

    @BindView(R.id.draw_view)
    DrawView mCanvas;
    @BindView(R.id.undo)
    FloatingActionButton mUndo;
    @BindView(R.id.redo)
    FloatingActionButton mRedo;
    @BindView(R.id.stroke)
    FloatingActionButton mStroke;
    @BindView(R.id.erase)
    FloatingActionButton mErase;
    @BindView(R.id.brush)
    FloatingActionButton mBrush;
    @BindView(R.id.color)
    FloatingActionButton mColorPicker;
    @BindView(R.id.clear)
    FloatingActionButton mClear;

    private View fragmentView;
    private AlertDialog mAlert;
    private AlertDialog.Builder mBuilder;
    private View colorView;
    private String lastColor = COLOR_ARRAY.get(COLOR_ARRAY.size()-2).getColor();
    private float lastStroke = 2.0f;
    private int strokeCounter = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView =  inflater.inflate(R.layout.step_add_basement_report_drawing, container, false);
        ButterKnife.bind(this,fragmentView);

        mBuilder = new AlertDialog.Builder(getContext());
        colorView = inflater.inflate(R.layout.layout_color_picker, container, false);
        mBuilder.setView(colorView);

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
                mAlert = mBuilder.create();
                mAlert.show();
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

        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentView = null;
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
            mAlert.dismiss();
            lastColor = intent.getStringExtra("color");
            mCanvas.setColor(Color.parseColor(lastColor));
        }
    };
}
