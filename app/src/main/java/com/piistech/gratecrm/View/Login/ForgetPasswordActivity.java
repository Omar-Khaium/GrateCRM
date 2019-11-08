package com.piistech.gratecrm.View.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.piistech.gratecrm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.forget_password_username)
    TextInputLayout mUsername;
    @BindView(R.id.forget_password_submit)
    MaterialButton mSubmit;
    @BindView(R.id.forget_password_login)
    TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(mLogin, "transitionLogin");
                pairs[1] = new Pair<View, String>(mSubmit, "transitionForgetPassword");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPasswordActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}
