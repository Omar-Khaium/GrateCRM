package com.piistech.gratecrm.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.piistech.gratecrm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCustomerActivity extends AppCompatActivity {

    @BindView(R.id.add_customer_back)
    FloatingActionButton mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        ButterKnife.bind(this);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
