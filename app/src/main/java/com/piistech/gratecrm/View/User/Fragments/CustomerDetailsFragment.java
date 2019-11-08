package com.piistech.gratecrm.View.User.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.Model.Repair;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.CustomerAdapter;
import com.piistech.gratecrm.Utils.Adapter.RepairAdapter;
import com.piistech.gratecrm.Utils.Service.CustomerDetailsService;
import com.piistech.gratecrm.Utils.Service.DashboardService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Intent.getIntent;
import static com.piistech.gratecrm.Utils.Constant.API_RESULT;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_CUSTOMER_DETAILS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_DASHBOARD;
import static com.piistech.gratecrm.Utils.Constant.sendToFragment;

public class CustomerDetailsFragment extends Fragment {

    private String id;

    @BindView(R.id.customer_details_repair_list)
    RecyclerView mList;
    @BindView(R.id.customer_details_add_basement)
    MaterialCardView mAddBasementReport;
    @BindView(R.id.customer_details_add_recommended_level)
    MaterialCardView mRecommendedLevel;
    @BindView(R.id.customer_details_add_estimate)
    MaterialCardView mAddEstimate;
    @BindView(R.id.customer_details_image)
    ImageView mPhoto;
    @BindView(R.id.customer_details_name)
    TextView mName;
    @BindView(R.id.row_layout_customer_phone)
    TextView mPhone;
    @BindView(R.id.row_layout_customer_email)
    TextView mEmail;
    @BindView(R.id.row_layout_customer_address)
    TextView mAddress;

    private ArrayList<Repair> arrayList = new ArrayList<>();

    public CustomerDetailsFragment(String id) {
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_customer_details, container, false);
        ButterKnife.bind(this, fragmentView);

        getData();
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.setAdapter(new RepairAdapter(arrayList,getContext()));

        mAddBasementReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToFragment(getContext(), v, new AddBasementReportFragment());
            }
        });

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().startService(new Intent(getContext(), CustomerDetailsService.class).putExtra("id",id));
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mCustomerDetailsReceiver, new IntentFilter(BROADCAST_ID_FOR_CUSTOMER_DETAILS));
    }

    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mCustomerDetailsReceiver);
    }

    BroadcastReceiver mCustomerDetailsReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ((Customer) intent.getSerializableExtra(API_RESULT)!= null) {
                Customer customer = (Customer) intent.getSerializableExtra(API_RESULT);
                mName.setText(customer.getName());
                mPhone.setText(customer.getPhone());
                mEmail.setText(customer.getEmail());
                mAddress.setText(customer.getAddress());
            }
        }
    };

    private void getData() {
        arrayList = new ArrayList<Repair>(){
            {
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
            }
        };
    }
}
