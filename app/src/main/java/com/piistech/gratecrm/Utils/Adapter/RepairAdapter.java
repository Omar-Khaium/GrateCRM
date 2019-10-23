package com.piistech.gratecrm.Utils.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.Model.Repair;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.View.CustomerDetailsActivity;
import com.piistech.gratecrm.View.EstimateActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RepairAdapter extends RecyclerView.Adapter<RepairAdapter.ViewHolder> {
    private ArrayList<Repair> arrayList;
    private Context context;

    public RepairAdapter(ArrayList<Repair> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout_repair, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repair repair = arrayList.get(position);
        holder.mID.setText(repair.getId());
        holder.mDate.setText(repair.getDate());
        holder.mLevel.setText(repair.getLevel());
        holder.mTotalAmount.setText(repair.getAmount());
        holder.mCash.setText(repair.getCash());

        holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, EstimateActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.row_layout_repair_id)
        TextView mID;
        @BindView(R.id.row_layout_repair_date)
        TextView mDate;
        @BindView(R.id.row_layout_repair_level)
        TextView mLevel;
        @BindView(R.id.row_layout_repair_total)
        TextView mTotalAmount;
        @BindView(R.id.row_layout_repair_cash)
        TextView mCash;
        @BindView(R.id.row_layout_repair_parent)
        RelativeLayout mParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
