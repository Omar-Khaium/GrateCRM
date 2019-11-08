package com.piistech.gratecrm.View;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jaredrummler.materialspinner.MaterialSpinnerAdapter;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Service.SaveCustomerService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_SAVE_CUSTOMER;
import static com.piistech.gratecrm.Utils.Constant.valueOf;

public class AddCustomerActivity extends AppCompatActivity {

    @BindView(R.id.add_customer_back)
    FloatingActionButton mBack;
    @BindView(R.id.add_customer_first_name)
    TextInputLayout mFirstName;
    @BindView(R.id.add_customer_last_name)
    TextInputLayout mLastName;
    @BindView(R.id.add_customer_business_name)
    TextInputLayout mBusinessName;
    @BindView(R.id.add_customer_type)
    MaterialSpinner mType;
    @BindView(R.id.add_customer_primary_phone)
    TextInputLayout mPrimaryPhone;
    @BindView(R.id.add_customer_secondary_phone)
    TextInputLayout mSecondaryPhone;
    @BindView(R.id.add_customer_cell_no)
    TextInputLayout mCellNo;
    @BindView(R.id.add_customer_email)
    TextInputLayout mEmail;
    @BindView(R.id.add_customer_street)
    TextInputLayout mStreet;
    @BindView(R.id.add_customer_city)
    TextInputLayout mCity;
    @BindView(R.id.add_customer_state)
    TextInputLayout mState;
    @BindView(R.id.add_customer_zip_code)
    TextInputLayout mZipCode;
    @BindView(R.id.add_customer_submit)
    MaterialButton mSubmit;
    @BindView(R.id.add_customer_first_name_status)
    TextView mFirstNameStatus;
    @BindView(R.id.add_customer_last_name_status)
    TextView mLastNameStatus;
    @BindView(R.id.add_customer_type_status)
    TextView mTypeStatus;
    @BindView(R.id.add_customer_primary_phone_status)
    TextView mPrimaryPhoneStatus;
    @BindView(R.id.add_customer_email_status)
    TextView mEmailStatus;
    @BindView(R.id.add_customer_street_status)
    TextView mStreetStatus;
    @BindView(R.id.add_customer_city_status)
    TextView mCityStatus;
    @BindView(R.id.add_customer_state_status)
    TextView mStateStatus;
    @BindView(R.id.add_customer_zip_code_status)
    TextView mZipCodeStatus;
    @BindView(R.id.add_customer_status_layout)
    ScrollView mScroll;

    private Animation mAnimation;
    private final int NAME = 1;
    private final int PHONE = 2;
    private final int EMAIL = 3;
    private final int ADDRESS = 4;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        ButterKnife.bind(this);

        arrayList = new ArrayList<String>() {
            {
                add("*Please select one");
                add("Commercial");
                add("Residencial");
            }
        };

        mType.setAdapter(new MaterialSpinnerAdapter<>(this, arrayList));


        mAnimation = AnimationUtils.loadAnimation(AddCustomerActivity.this, R.anim.shake);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        inspectInput(mFirstName, mFirstNameStatus, NAME);
        inspectInput(mLastName, mLastNameStatus, NAME);
        inspectInput(mType, mTypeStatus);
        inspectInput(mPrimaryPhone, mPrimaryPhoneStatus, PHONE);
        inspectInput(mEmail, mEmailStatus, EMAIL);
        inspectInput(mStreet, mStreetStatus, ADDRESS);
        inspectInput(mCity, mCityStatus, ADDRESS);
        inspectInput(mState, mStateStatus, NAME);
        inspectInput(mZipCode, mZipCodeStatus, PHONE);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSubmit.setEnabled(false);
                mSubmit.setText(R.string.loading);
                Intent intent = new Intent(AddCustomerActivity.this, SaveCustomerService.class);
                intent.putExtra("first_name", valueOf(mFirstName));
                intent.putExtra("last_name", valueOf(mLastName));
                intent.putExtra("business_name", valueOf(mBusinessName));
                intent.putExtra("type", valueOf(mType));
                intent.putExtra("primary_phone", valueOf(mPrimaryPhone));
                intent.putExtra("secondary_phone", valueOf(mSecondaryPhone));
                intent.putExtra("cell_phone", valueOf(mCellNo));;
                intent.putExtra("email", valueOf(mEmail));
                intent.putExtra("street", valueOf(mStreet));
                intent.putExtra("city", valueOf(mCity));
                intent.putExtra("state", valueOf(mState));
                intent.putExtra("zip", valueOf(mZipCode));
                startService(intent);
            }
        });
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra(API_STATUS)) {
                if (intent.getBooleanExtra(API_STATUS, false)) {
                    finish();
                } else {
                    mSubmit.setEnabled(true);
                    mSubmit.setText(R.string.submit);
                }
            }
        }
    };

    private void setTextViewDrawableColor(TextView textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(textView.getContext(), color), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    private void checkInput(TextInputLayout input, TextView textView) {
        if (input.getEditText().getText().toString().isEmpty()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_red_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            textView.startAnimation(mAnimation);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_green_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
    }

    private void validateType(MaterialSpinner spinner, TextView textView) {
        if (spinner.getSelectedIndex() != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_green_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_red_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            textView.startAnimation(mAnimation);
        }
    }

    private void validateEmail(Editable editable, TextView textView) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(editable.toString()).matches()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_green_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_red_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            textView.startAnimation(mAnimation);
        }
    }

    private void validatePhone(Editable editable, TextView textView) {
        if (Patterns.PHONE.matcher(editable.toString()).matches()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_green_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_red_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            textView.startAnimation(mAnimation);
        }
    }

    private void validateName(Editable editable, TextView textView) {
        if (editable.toString().matches("^[A-Za-z A-Za-z]+$")) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_green_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0);
            setTextViewDrawableColor(textView, android.R.color.holo_red_light);
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            textView.startAnimation(mAnimation);
        }
    }

    private void inspectInput(TextInputLayout inputLayout, TextView status, int type) {
        inputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mScroll.scrollTo(0, status.getTop()-16);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput(inputLayout, status);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                switch (type) {
                    case NAME:
                        validateName(editable, status);
                        break;
                    case PHONE:
                        validatePhone(editable, status);
                        break;
                    case EMAIL:
                        validateEmail(editable, status);
                        break;
                    case ADDRESS:
                        break;
                }
                formSubmissionStatus();
            }
        });
    }

    private void inspectInput(MaterialSpinner inputLayout, TextView status) {
        mType.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                mScroll.scrollTo(0, status.getTop()-16);
                validateType(inputLayout, status);
                formSubmissionStatus();
            }
        });
    }

    private void formSubmissionStatus() {
        if (isChecked(mFirstNameStatus) && isChecked(mLastNameStatus) && isChecked(mTypeStatus) &&
                isChecked(mPrimaryPhoneStatus) && isChecked(mEmailStatus) && isChecked(mStreetStatus) &&
                isChecked(mCityStatus) && isChecked(mStateStatus) && isChecked(mZipCodeStatus)) {
            mSubmit.setVisibility(View.VISIBLE);
        } else {
            mSubmit.setVisibility(View.GONE);
        }
    }

    private boolean isChecked(TextView textView) {
        return (textView != null && textView.getCurrentTextColor() == getResources().getColor(android.R.color.holo_green_light));
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(BROADCAST_ID_FOR_SAVE_CUSTOMER));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    }
}