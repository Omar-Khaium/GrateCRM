package com.piistech.gratecrm.Utils.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piistech.gratecrm.Model.Estimate;
import com.piistech.gratecrm.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EstimateAdapter extends RecyclerView.Adapter<EstimateAdapter.ViewHolder> {
    private ArrayList<Estimate> arrayList;
    private Context context;

    public EstimateAdapter(ArrayList<Estimate> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout_estimate, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Estimate estimate = arrayList.get(position);

        holder.mProduct.setText(estimate.getProduct());
        holder.mDescription.setText(estimate.getDescription());
        holder.mQuantity.setText(estimate.getQuantity());
        holder.mRate.setText(estimate.getRate());
        holder.mAmount.setText(estimate.getAmount());

        /*holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AddEstimateActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.row_layout_estimate_product)
        TextView mProduct;
        @BindView(R.id.row_layout_estimate_description)
        TextView mDescription;
        @BindView(R.id.row_layout_estimate_quantity)
        TextView mQuantity;
        @BindView(R.id.row_layout_estimate_rate)
        TextView mRate;
        @BindView(R.id.row_layout_estimate_amount)
        TextView mAmount;
        @BindView(R.id.row_layout_estimate_parent)
        RelativeLayout mParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
