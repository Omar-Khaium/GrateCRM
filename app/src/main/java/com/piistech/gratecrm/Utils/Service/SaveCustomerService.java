package com.piistech.gratecrm.Utils.Service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.piistech.gratecrm.Utils.LocalDatabase;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static com.piistech.gratecrm.Utils.Constant.API_NAME_SAVE_CUSTOMER;
import static com.piistech.gratecrm.Utils.Constant.API_NAME_TOKEN;
import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.API_TOKEN;
import static com.piistech.gratecrm.Utils.Constant.API_URL;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_LOGIN;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_SAVE_CUSTOMER;
import static com.piistech.gratecrm.Utils.Constant.EXPIRE_TIME;
import static com.piistech.gratecrm.Utils.Constant.SOCKET_TIMEOUT;
import static com.piistech.gratecrm.Utils.Constant.valueOfInt;
import static com.piistech.gratecrm.Utils.Constant.valueOfString;

public class SaveCustomerService extends IntentService {
    private Context context;

    public SaveCustomerService() {
        super("SaveCustomerService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            context = this;
            requestNetwork(
                    intent.getStringExtra("first_name"),
                    intent.getStringExtra("last_name"),
                    intent.getStringExtra("business_name"),
                    intent.getStringExtra("type"),
                    intent.getStringExtra("primary_phone"),
                    intent.getStringExtra("secondary_phone"),
                    intent.getStringExtra("cell_phone"),
                    intent.getStringExtra("email"),
                    intent.getStringExtra("street"),
                    intent.getStringExtra("city"),
                    intent.getStringExtra("state"),
                    intent.getStringExtra("zip")
            );
        }
    }

    private void requestNetwork(String firstName, String lastName, String businessName, String type,
                                String primaryPhone, String secondaryPhone, String cellPhone,
                                String email, String street, String city, String state, String zip) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.getCache().clear();
        Intent resultIntent = new Intent(BROADCAST_ID_FOR_SAVE_CUSTOMER);

        StringRequest postRequest = new StringRequest(Request.Method.POST, API_URL + API_NAME_SAVE_CUSTOMER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            if (json.has("result")) {
                                resultIntent.putExtra(API_STATUS,json.getBoolean("result"));
                            }
                            else {
                                resultIntent.putExtra(API_STATUS,false);
                            }
                        } catch (Exception e) {
                            resultIntent.putExtra(API_STATUS,false);
                        }
                        LocalBroadcastManager.getInstance(SaveCustomerService.this).sendBroadcast(resultIntent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultIntent.putExtra(API_STATUS,false);
                LocalBroadcastManager.getInstance(SaveCustomerService.this).sendBroadcast(resultIntent);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization", LocalDatabase.getStringValue(getApplicationContext(), API_TOKEN));
                params.put("FirstName", firstName);
                params.put("LastName", lastName);
                params.put("BusinessName", businessName);
                params.put("Type", type);
                params.put("PrimaryPhone", primaryPhone);
                params.put("SecondaryPhone", secondaryPhone);
                params.put("CellNo", cellPhone);
                params.put("email", email);
                params.put("Street", street);
                params.put("City", city);
                params.put("State", state);
                params.put("ZipCode", zip);
                return params;
            }
        };
        RetryPolicy policy = new DefaultRetryPolicy(SOCKET_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        postRequest.setRetryPolicy(policy);
        mRequestQueue.add(postRequest);
    }
}
