package com.piistech.gratecrm.View.User.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.CustomerAdapter;
import com.piistech.gratecrm.Utils.Service.DashboardService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.API_RESULT;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_DASHBOARD;

public class DashboardFragment extends Fragment {

    private View fragmentView;
    private ArrayList<Customer> arrayList = new ArrayList<>();

    @BindView(R.id.fragment_dashboard_list)
    RecyclerView mList;
    @BindView(R.id.fragment_dashboard_shimmer)
    LinearLayout mShimmer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, fragmentView);

        arrayList = new ArrayList<>();
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.setAdapter(new CustomerAdapter(arrayList, getContext()));

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().startService(new Intent(getContext(), DashboardService.class)
                .putExtra("pageNo", "1")
                .putExtra("pageSize", "10")
        );
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mDashboardReceiver, new IntentFilter(BROADCAST_ID_FOR_DASHBOARD));
    }

    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mDashboardReceiver);
    }
    private BroadcastReceiver mDashboardReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ((ArrayList<Customer>) intent.getSerializableExtra(API_RESULT) != null) {
                arrayList = (ArrayList<Customer>) intent.getSerializableExtra(API_RESULT);
                mList.setAdapter(new CustomerAdapter(arrayList, getContext()));
            }

            mShimmer.setVisibility(View.GONE);
            mList.setVisibility(View.VISIBLE);
        }
    };
}
