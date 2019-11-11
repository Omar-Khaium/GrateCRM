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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.LocalDatabase;
import com.piistech.gratecrm.Utils.Service.LoginService;
import com.piistech.gratecrm.Utils.Service.TokenValidationService;
import com.piistech.gratecrm.View.Login.LoginActivity;
import com.piistech.gratecrm.View.User.Fragments.AddCustomerFragment;
import com.piistech.gratecrm.View.User.Fragments.DashboardFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
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

    @BindView(R.id.user_nav_account_holder_name_text)
    TextView mUserName;

    @BindView(R.id.user_nav_home)
    MaterialCardView mNavHome;
    @BindView(R.id.user_nav_home_logo)
    ImageView mNavHomeLogo;
    @BindView(R.id.user_nav_home_text)
    TextView mNavHomeText;

    @BindView(R.id.user_nav_add_customer)
    MaterialCardView mNavAddCustomer;
    @BindView(R.id.user_nav_add_customer_logo)
    ImageView mNavAddCustomerLogo;
    @BindView(R.id.user_nav_add_customer_text)
    TextView mNavAddCustomerText;

    @BindView(R.id.user_nav_change_password)
    MaterialCardView mNavChangePassword;
    @BindView(R.id.user_nav_change_password_logo)
    ImageView mNavChangePasswordLogo;
    @BindView(R.id.user_nav_change_password_text)
    TextView mNavChangePasswordText;

    @BindView(R.id.user_nav_sign_out)
    MaterialCardView mNavLogout;
    @BindView(R.id.user_nav_sign_out_logo)
    ImageView mNavLogoutLogo;
    @BindView(R.id.user_nav_sign_out_text)
    TextView mNavLogoutText;


    @BindView(R.id.user_module_name)
    TextView mModuleName;
    @BindView(R.id.user_module_search)
    SearchView mModuleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        mNavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNav();
                mModuleName.setText(getResources().getString(R.string.dashboard));
                mNavHome.setCardElevation(4.0f);
                mNavHome.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                mNavHomeLogo.setColorFilter(getResources().getColor(android.R.color.white));
                mNavHomeText.setTextColor(getResources().getColor(android.R.color.white));
                getSupportFragmentManager().beginTransaction().replace(R.id.user_module_container, new DashboardFragment()).commitAllowingStateLoss();
            }
        });

        mNavAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNav();
                mModuleName.setText(getResources().getString(R.string.add_customer));
                mNavAddCustomer.setCardElevation(4.0f);
                mNavAddCustomer.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                mNavAddCustomerLogo.setColorFilter(getResources().getColor(android.R.color.white));
                mNavAddCustomerText.setTextColor(getResources().getColor(android.R.color.white));
                getSupportFragmentManager().beginTransaction().replace(R.id.user_module_container, new AddCustomerFragment()).commitAllowingStateLoss();
            }
        });

        mNavChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNav();
                mNavChangePassword.setCardElevation(4.0f);
                mNavChangePassword.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                mNavChangePasswordLogo.setColorFilter(getResources().getColor(android.R.color.white));
                mNavChangePasswordText.setTextColor(getResources().getColor(android.R.color.white));
            }
        });

        mNavLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNav();
                mNavLogout.setCardElevation(4.0f);
                mNavLogout.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                mNavLogoutLogo.setColorFilter(getResources().getColor(android.R.color.white));
                mNavLogoutText.setTextColor(getResources().getColor(android.R.color.white));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
            if (intent.getBooleanExtra(API_STATUS, false)) {
                alert.dismiss();
                startService(new Intent(DashboardActivity.this, TokenValidationService.class));
            } else {
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
        getSupportFragmentManager().beginTransaction().replace(R.id.user_module_container, new DashboardFragment()).commitAllowingStateLoss();
        startService(new Intent(this, TokenValidationService.class));
        LocalBroadcastManager.getInstance(this).registerReceiver(mLoginReceiver, new IntentFilter(BROADCAST_ID_FOR_LOGIN));
        LocalBroadcastManager.getInstance(this).registerReceiver(mTokenValidationReceiver, new IntentFilter(BROADCAST_ID_FOR_TOKEN_EXPIRE));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mLoginReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mTokenValidationReceiver);
    }

    private void resetNav() {
        resetCardBackgroundColor(mNavHome);
        resetCardContent(mNavHomeLogo, mNavHomeText);
        resetCardBackgroundColor(mNavAddCustomer);
        resetCardContent(mNavAddCustomerLogo, mNavAddCustomerText);
        resetCardBackgroundColor(mNavChangePassword);
        resetCardContent(mNavChangePasswordLogo, mNavChangePasswordText);
        resetCardBackgroundColor(mNavLogout);
        resetCardContent(mNavLogoutLogo, mNavLogoutText);
    }

    private void resetCardBackgroundColor(MaterialCardView cardView) {
        cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white));
        cardView.setCardElevation(0.0f);
    }

    private void resetCardContent(ImageView imageView, TextView textView) {
        imageView.setColorFilter(getResources().getColor(R.color.colorAccent));
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
    }
}
