package com.piistech.gratecrm.View.Login;

import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.LocalDatabase;
import com.piistech.gratecrm.Utils.Service.LoginService;
import com.piistech.gratecrm.View.DashboardActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_LOGIN;
import static com.piistech.gratecrm.Utils.Constant.INPUT_PASSWORD;
import static com.piistech.gratecrm.Utils.Constant.INPUT_REMEMBER_ME;
import static com.piistech.gratecrm.Utils.Constant.INPUT_USERNAME;
import static com.piistech.gratecrm.Utils.Constant.validateInput;
import static com.piistech.gratecrm.Utils.Constant.valueOf;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_root_layout)
    View mRootLayout;
    @BindView(R.id.login_submit)
    MaterialButton mSubmit;
    @BindView(R.id.login_forget_password)
    TextView mForgetPassword;
    @BindView(R.id.login_remember_me)
    CheckBox mRememberMe;
    @BindView(R.id.login_username)
    TextInputLayout mUsername;
    @BindView(R.id.login_password)
    TextInputLayout mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if (LocalDatabase.getBooleanValue(this, INPUT_REMEMBER_ME)) refill();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRememberMe.isChecked()) {
                    LocalDatabase.setStringValue(LoginActivity.this, INPUT_USERNAME, valueOf(mUsername));
                    LocalDatabase.setStringValue(LoginActivity.this, INPUT_PASSWORD, valueOf(mPassword));
                    LocalDatabase.setBooleanValue(LoginActivity.this, INPUT_REMEMBER_ME, valueOf(mRememberMe));
                }
                if (validateInput(mUsername) && validateInput(mPassword)) {
                    mSubmit.setText("Loading...");
                    mSubmit.setEnabled(false);
                    startService(new Intent(LoginActivity.this, LoginService.class)
                            .putExtra("username", valueOf(mUsername))
                            .putExtra("password", valueOf(mPassword))
                    );
                }

            }
        });

        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(mSubmit, "transitionLogin");
                pairs[1] = new Pair<View, String>(mForgetPassword, "transitionForgetPassword");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }

    private void refill() {
        mUsername.getEditText().setText(LocalDatabase.getStringValue(this, INPUT_USERNAME));
        mPassword.getEditText().setText(LocalDatabase.getStringValue(this, INPUT_PASSWORD));
        mRememberMe.setChecked(LocalDatabase.getBooleanValue(this, INPUT_REMEMBER_ME));
    }

    @Override
    protected void onDestroy() {
        mSubmit = null;
        mRootLayout = null;
        mForgetPassword = null;
        mRememberMe = null;
        mUsername = null;
        mPassword = null;
        System.gc();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(BROADCAST_ID_FOR_LOGIN));
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra(API_STATUS, false))
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            else {
                mSubmit.setText(R.string.log_in);
                mSubmit.setEnabled(true);
            }
        }
    };
}
