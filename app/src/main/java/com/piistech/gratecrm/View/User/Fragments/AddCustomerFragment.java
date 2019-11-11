package com.piistech.gratecrm.View.User.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jaredrummler.materialspinner.MaterialSpinnerAdapter;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Service.SaveCustomerService;
import com.piistech.gratecrm.View.AddCustomerActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_SAVE_CUSTOMER;
import static com.piistech.gratecrm.Utils.Constant.sendToFragment;
import static com.piistech.gratecrm.Utils.Constant.valueOf;

public class AddCustomerFragment extends Fragment {

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

    private ArrayList<String> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_customer, container, false);
        ButterKnife.bind(this, view);

        arrayList = new ArrayList<String>() {
            {
                add("*Please select one");
                add("Commercial");
                add("Residencial");
            }
        };

        mType.setAdapter(new MaterialSpinnerAdapter<>(getActivity(), arrayList));

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
                if (!mFirstName.isErrorEnabled() && !mLastName.isErrorEnabled() && mType.getSelectedIndex()!=0 && !mEmail.isErrorEnabled() && !mPrimaryPhone.isErrorEnabled() && !mStreet.isErrorEnabled() && !mCity.isErrorEnabled() && !mState.isErrorEnabled() && !mZipCode.isErrorEnabled()) {
                    mSubmit.setEnabled(false);
                    mSubmit.setText(R.string.loading);
                    Intent intent = new Intent(getContext(), SaveCustomerService.class);
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
                    getActivity().startService(intent);
                }
            }
        });

        return view;
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra(API_STATUS)) {
                if (intent.getBooleanExtra(API_STATUS, false)) {
                    sendToFragment(getContext(), getView(), new DashboardFragment());
                } else {
                    mSubmit.setEnabled(true);
                    mSubmit.setText(R.string.submit);
                }
            }
        }
    };


    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mReceiver, new IntentFilter(BROADCAST_ID_FOR_SAVE_CUSTOMER));
    }

    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mReceiver);
    }

    private void validate() {
        isEmpty(mFirstName);
        isEmpty(mLastName);
        isEmpty(mType);
        isEmpty(mPrimaryPhone);
        isEmpty(mEmail);
        isEmpty(mStreet);
        isEmpty(mCity);
        isEmpty(mState);
        isEmpty(mZipCode);
        matchNamePattern(mFirstName);
        matchNamePattern(mLastName);
        matchEmailPattern(mEmail);
        matchPhonePattern(mPrimaryPhone);
    }

    private void isEmpty(TextInputLayout inputLayout) {
        if (inputLayout.getEditText().getText().toString().isEmpty()) {
            inputLayout.setError(getResources().getString(R.string.required));
        } else {
            inputLayout.setErrorEnabled(false);
        }
    }

    private void isEmpty(MaterialSpinner spinner) {
        if (spinner.getSelectedIndex() == 0) {
            spinner.setError(getResources().getString(R.string.required));
        } else {
            spinner.setError(null);
        }
    }

    private void matchNamePattern(TextInputLayout inputLayout) {
        if (!inputLayout.getEditText().getText().toString().matches("^[A-Za-z A-Za-z]+$")) {
            inputLayout.setError(getResources().getString(R.string.invalid));
        } else {
            inputLayout.setErrorEnabled(false);
        }
    }

    private void matchEmailPattern(TextInputLayout inputLayout) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(inputLayout.getEditText().getText().toString()).matches()) {
            inputLayout.setError(getResources().getString(R.string.invalid));
        } else {
            inputLayout.setErrorEnabled(false);
        }
    }

    private void matchPhonePattern(TextInputLayout inputLayout) {
        if (!Patterns.PHONE.matcher(inputLayout.getEditText().getText().toString()).matches()) {
            inputLayout.setError(getResources().getString(R.string.invalid));
        } else {
            inputLayout.setErrorEnabled(false);
        }
    }
}
