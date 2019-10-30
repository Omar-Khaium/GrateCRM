package com.piistech.gratecrm.Utils.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.piistech.gratecrm.Model.ColorItem;
import com.piistech.gratecrm.Model.Estimate;
import com.piistech.gratecrm.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.COLOR_ARRAY;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ColorItem> arrayList;

    public ColorAdapter(Context context) {
        this.context = context;
        this.arrayList = COLOR_ARRAY;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_color_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mColor.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(arrayList.get(position).getColor())));
        holder.mColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll();
                arrayList.get(position).setFlag(true);
                notifyDataSetChanged();
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("receiveColor").putExtra("color", arrayList.get(position).getColor()));
            }
        });

        if (arrayList.get(position).isFlag()) holder.mColor.setImageResource(R.drawable.ic_checked);
    }

    private void resetAll() {
        for (ColorItem colorItem : arrayList) {
            colorItem.setFlag(false);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item)
        FloatingActionButton mColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
