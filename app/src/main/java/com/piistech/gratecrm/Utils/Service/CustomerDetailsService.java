package com.piistech.gratecrm.Utils.Service;

import android.app.IntentService;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.Model.CustomerAPI;
import com.piistech.gratecrm.Utils.LocalDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.piistech.gratecrm.Utils.Constant.API_NAME_GET_ALL_CUSTOMER;
import static com.piistech.gratecrm.Utils.Constant.API_NAME_GET_CUSTOMER_BY_ID;
import static com.piistech.gratecrm.Utils.Constant.API_RESULT;
import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.API_TOKEN;
import static com.piistech.gratecrm.Utils.Constant.API_URL;
import static com.piistech.gratecrm.Utils.Constant.AddressFormatter;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_CUSTOMER_DETAILS;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_DASHBOARD;
import static com.piistech.gratecrm.Utils.Constant.NameFormatter;
import static com.piistech.gratecrm.Utils.Constant.PhoneFormatter;
import static com.piistech.gratecrm.Utils.Constant.SOCKET_TIMEOUT;

public class CustomerDetailsService extends IntentService {

    public CustomerDetailsService() {
        super("CustomerDetailsService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            requestNetwork(intent.getStringExtra("id"));
        }
    }

    private void requestNetwork(String id) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.getCache().clear();
        Intent resultIntent = new Intent(BROADCAST_ID_FOR_CUSTOMER_DETAILS);

        StringRequest postRequest = new StringRequest(Request.Method.GET, API_URL + API_NAME_GET_CUSTOMER_BY_ID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            JSONObject jsonDetails = json.getJSONObject("CustomerDetails");

                            Gson gson = new Gson();
                            CustomerAPI customerAPI = gson.fromJson(jsonDetails.toString(), CustomerAPI.class);
                            Customer customer = new Customer(customerAPI.getId(), NameFormatter(customerAPI.getFirstName(), customerAPI.getLastName()), PhoneFormatter(customerAPI.getPrimaryPhone(),customerAPI.getSecondaryPhone(),""), PhoneFormatter("", "",customerAPI.getEmailAddress()), AddressFormatter("",customerAPI.getStreet(),customerAPI.getCity(), customerAPI.getState(), customerAPI.getZipCode()), customerAPI.getPhoneType());

                            resultIntent.putExtra(API_RESULT, (Serializable) customer);
                            resultIntent.putExtra(API_STATUS, true);
                        } catch (Exception e) {
                            resultIntent.putExtra(API_STATUS, false);
                        }
                        LocalBroadcastManager.getInstance(CustomerDetailsService.this).sendBroadcast(resultIntent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultIntent.putExtra(API_STATUS, false);
                LocalBroadcastManager.getInstance(CustomerDetailsService.this).sendBroadcast(resultIntent);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", LocalDatabase.getStringValue(getApplicationContext(), API_TOKEN));
                headers.put("ID", id);
                return headers;
            }
        };
        RetryPolicy policy = new DefaultRetryPolicy(SOCKET_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        postRequest.setRetryPolicy(policy);
        mRequestQueue.add(postRequest);
    }
}
