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
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.View.CustomerDetailsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    private ArrayList<Customer> arrayList;
    private Context context;

    public CustomerAdapter(ArrayList<Customer> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout_cutomer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Customer customer = arrayList.get(position);
        holder.mPhoto.setImageResource(customer.getPhoto());
        holder.mName.setText(customer.getName());
        holder.mPhone.setText(customer.getPhone());
        holder.mEmail.setText(customer.getEmail());
        holder.mAddress.setText(customer.getAddress());

        holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, CustomerDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.row_layout_customer_photo)
        CircleImageView mPhoto;
        @BindView(R.id.row_layout_customer_name)
        TextView mName;
        @BindView(R.id.row_layout_customer_phone)
        TextView mPhone;
        @BindView(R.id.row_layout_customer_email)
        TextView mEmail;
        @BindView(R.id.row_layout_customer_address)
        TextView mAddress;
        @BindView(R.id.row_layout_customer_parent)
        RelativeLayout mParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
