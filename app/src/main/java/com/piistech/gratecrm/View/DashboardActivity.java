package com.piistech.gratecrm.View;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.CustomerAdapter;
import com.piistech.gratecrm.Utils.LocalDatabase;
import com.piistech.gratecrm.Utils.Service.DashboardService;
import com.piistech.gratecrm.Utils.Service.LoginService;
import com.piistech.gratecrm.Utils.Service.TokenValidationService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.API_RESULT;
import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_DASHBOARD;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_LOGIN;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_TOKEN_EXPIRE;
import static com.piistech.gratecrm.Utils.Constant.INPUT_PASSWORD;
import static com.piistech.gratecrm.Utils.Constant.INPUT_REMEMBER_ME;
import static com.piistech.gratecrm.Utils.Constant.INPUT_USERNAME;
import static com.piistech.gratecrm.Utils.Constant.IS_AUTHENTICATED_USER;
import static com.piistech.gratecrm.Utils.Constant.validateInput;
import static com.piistech.gratecrm.Utils.Constant.valueOf;

public class DashboardActivity extends AppCompatActivity {

    /// TODO: __________________________________ TOKEN VALIDATION __________________________________

    TextInputLayout mTokenUsername;
    TextInputLayout mTokenPassword;
    MaterialButton mTokenSubmit;
    TextView mTokenBack;

    /// TODO: ______________________________________________________________________________________

    private AlertDialog alert;
    private ArrayList<Customer> arrayList = new ArrayList<>();

    @BindView(R.id.dashboard_root_layout)
    View rootLayout;
    @BindView(R.id.dashboard_list)
    RecyclerView mList;
    @BindView(R.id.dashboard_add_customer)
    MaterialButton mAddCustomer;
    @BindView(R.id.dashboard_shimmer)
    LinearLayout mShimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        arrayList = new ArrayList<>();
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new CustomerAdapter(arrayList, this));

        mAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddCustomerActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mList = null;
        arrayList = null;
        System.gc();
    }

    @Override
    public void onBackPressed() {

    }

    private BroadcastReceiver mTokenValidationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            View view = LayoutInflater.from(DashboardActivity.this).inflate(R.layout.bottom_sheet_login, new LinearLayout(DashboardActivity.this), false);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(DashboardActivity.this);
            mBuilder.setView(view);
            alert = mBuilder.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            alert.show();
            alert.setCancelable(false);

            mTokenUsername = view.findViewById(R.id.bottom_sheet_login_username);
            mTokenPassword = view.findViewById(R.id.bottom_sheet_login_password);
            mTokenSubmit = view.findViewById(R.id.bottom_sheet_login_submit);
            mTokenBack = view.findViewById(R.id.bottom_sheet_back);
            refill(mTokenUsername, mTokenPassword);

            mTokenBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LocalDatabase.setBooleanValue(DashboardActivity.this, IS_AUTHENTICATED_USER, false);
                    startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                }
            });

            mTokenSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validateInput(mTokenUsername) && validateInput(mTokenPassword)) {
                        mTokenSubmit.setText("Loading...");
                        mTokenSubmit.setEnabled(false);
                        startService(new Intent(DashboardActivity.this, LoginService.class)
                                .putExtra("username", valueOf(mTokenUsername))
                                .putExtra("password", valueOf(mTokenPassword))
                        );
                    }
                }
            });
        }
    };

    private BroadcastReceiver mLoginReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra(API_STATUS, false)){
                alert.dismiss();
                startService(new Intent(DashboardActivity.this, TokenValidationService.class));
            }
            else {
                mTokenSubmit.setText(R.string.log_in);
                mTokenSubmit.setEnabled(true);
            }
        }
    };

    private BroadcastReceiver mDashboardReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ((ArrayList<Customer>) intent.getSerializableExtra(API_RESULT)!=null) {
                arrayList = (ArrayList<Customer>) intent.getSerializableExtra(API_RESULT);
                mList.setAdapter(new CustomerAdapter(arrayList, DashboardActivity.this));
                mShimmer.setVisibility(View.GONE);
                rootLayout.setVisibility(View.VISIBLE);
            }
        }
    };

    private void refill(TextInputLayout mUsername, TextInputLayout mPassword) {
        if (LocalDatabase.getBooleanValue(this, INPUT_REMEMBER_ME)) {
            mUsername.getEditText().setText(LocalDatabase.getStringValue(this, INPUT_USERNAME));
            mPassword.getEditText().setText(LocalDatabase.getStringValue(this, INPUT_PASSWORD));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(this, DashboardService.class)
                .putExtra("pageNo", "1")
                .putExtra("pageSize", "10")
        );
        startService(new Intent(this, TokenValidationService.class));
        LocalBroadcastManager.getInstance(this).registerReceiver(mDashboardReceiver, new IntentFilter(BROADCAST_ID_FOR_DASHBOARD));
        LocalBroadcastManager.getInstance(this).registerReceiver(mLoginReceiver, new IntentFilter(BROADCAST_ID_FOR_LOGIN));
        LocalBroadcastManager.getInstance(this).registerReceiver(mTokenValidationReceiver, new IntentFilter(BROADCAST_ID_FOR_TOKEN_EXPIRE));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mDashboardReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mLoginReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mTokenValidationReceiver);
    }
}
