package com.piistech.gratecrm.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.Model.Repair;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.CustomerAdapter;
import com.piistech.gratecrm.Utils.Adapter.RepairAdapter;
import com.piistech.gratecrm.Utils.LocalDatabase;
import com.piistech.gratecrm.Utils.Service.CustomerDetailsService;
import com.piistech.gratecrm.Utils.Service.LoginService;
import com.piistech.gratecrm.Utils.Service.TokenValidationService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.API_RESULT;
import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_CUSTOMER_DETAILS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_LOGIN;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_TOKEN_EXPIRE;
import static com.piistech.gratecrm.Utils.Constant.INPUT_PASSWORD;
import static com.piistech.gratecrm.Utils.Constant.INPUT_REMEMBER_ME;
import static com.piistech.gratecrm.Utils.Constant.INPUT_USERNAME;
import static com.piistech.gratecrm.Utils.Constant.IS_AUTHENTICATED_USER;
import static com.piistech.gratecrm.Utils.Constant.validateInput;
import static com.piistech.gratecrm.Utils.Constant.valueOf;

public class CustomerDetailsActivity extends AppCompatActivity {

    /// TODO: __________________________________ TOKEN VALIDATION __________________________________

    TextInputLayout mTokenUsername;
    TextInputLayout mTokenPassword;
    MaterialButton mTokenSubmit;
    TextView mTokenBack;

    /// TODO: ______________________________________________________________________________________

    @BindView(R.id.customer_details_repair_list)
    RecyclerView mList;
    @BindView(R.id.customer_details_back)
    ImageView mBack;
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
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        ButterKnife.bind(this);

        getData();
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new RepairAdapter(arrayList,this));

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerDetailsActivity.this, CustomerDetailsActivity.class);
                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(mPhoto, "customerImage");
                pairs[1] = new Pair<View, String>(mName, "customerName");
                pairs[2] = new Pair<View, String>(mPhone, "customerPhone");
                pairs[3] = new Pair<View, String>(mEmail, "customerEmail");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(CustomerDetailsActivity.this, pairs);;
                startActivity(intent, options.toBundle());
            }
        });

        mAddBasementReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AddBasementReportActivity.class));
            }
        });

        mAddEstimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddEstimateActivity.class));
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

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

    @Override
    protected void onDestroy() {
        mList = null;
        arrayList = null;
        mAddEstimate = null;
        mRecommendedLevel = null;
        mAddBasementReport = null;
        mBack = null;
        System.gc();
        super.onDestroy();
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

    private BroadcastReceiver mTokenValidationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            View view = LayoutInflater.from(CustomerDetailsActivity.this).inflate(R.layout.bottom_sheet_login, new LinearLayout(CustomerDetailsActivity.this), false);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(CustomerDetailsActivity.this);
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
                    LocalDatabase.setBooleanValue(CustomerDetailsActivity.this, IS_AUTHENTICATED_USER, false);
                    startActivity(new Intent(CustomerDetailsActivity.this, LoginActivity.class));
                }
            });

            mTokenSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validateInput(mTokenUsername) && validateInput(mTokenPassword)) {
                        mTokenSubmit.setText("Loading...");
                        mTokenSubmit.setEnabled(false);
                        startService(new Intent(CustomerDetailsActivity.this, LoginService.class)
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
                startService(new Intent(CustomerDetailsActivity.this, TokenValidationService.class));
            }
            else {
                mTokenSubmit.setText(R.string.log_in);
                mTokenSubmit.setEnabled(true);
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
        startService(new Intent(this, CustomerDetailsService.class).putExtra("id", getIntent().getStringExtra("id")));
        startService(new Intent(this, TokenValidationService.class));
        LocalBroadcastManager.getInstance(this).registerReceiver(mCustomerDetailsReceiver, new IntentFilter(BROADCAST_ID_FOR_CUSTOMER_DETAILS));
        LocalBroadcastManager.getInstance(this).registerReceiver(mLoginReceiver, new IntentFilter(BROADCAST_ID_FOR_LOGIN));
        LocalBroadcastManager.getInstance(this).registerReceiver(mTokenValidationReceiver, new IntentFilter(BROADCAST_ID_FOR_TOKEN_EXPIRE));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mCustomerDetailsReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mLoginReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mTokenValidationReceiver);
    }
}
