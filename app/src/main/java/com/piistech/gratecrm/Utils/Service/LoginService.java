package com.piistech.gratecrm.Utils.Service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

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

import static com.piistech.gratecrm.Utils.Constant.API_NAME_TOKEN;
import static com.piistech.gratecrm.Utils.Constant.API_STATUS;
import static com.piistech.gratecrm.Utils.Constant.API_TOKEN;
import static com.piistech.gratecrm.Utils.Constant.API_URL;
import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_LOGIN;
import static com.piistech.gratecrm.Utils.Constant.EXPIRE_TIME;
import static com.piistech.gratecrm.Utils.Constant.IS_AUTHENTICATED_USER;
import static com.piistech.gratecrm.Utils.Constant.SOCKET_TIMEOUT;
import static com.piistech.gratecrm.Utils.Constant.valueOf;
import static com.piistech.gratecrm.Utils.Constant.valueOfInt;
import static com.piistech.gratecrm.Utils.Constant.valueOfString;

public class LoginService extends IntentService {
    private Context context;

    public LoginService() {
        super("LoginService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            context = this;
           requestNetwork(intent.getStringExtra("username"), intent.getStringExtra("password"));
        }
    }

    private void requestNetwork(String user_name, String password) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.getCache().clear();
        Intent resultIntent = new Intent(BROADCAST_ID_FOR_LOGIN);

        StringRequest postRequest = new StringRequest(Request.Method.POST, API_URL + API_NAME_TOKEN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            if (!json.has("access_token")) resultIntent.putExtra(API_STATUS,false);
                            else {
                                resultIntent.putExtra(API_STATUS,true);
                                LocalDatabase.setLongValue(context, EXPIRE_TIME, (Calendar.getInstance().getTimeInMillis()/1000)+valueOfInt(json, "expires_in"));
                                 LocalDatabase.setStringValue(context, API_TOKEN, valueOfString(json,"token_type") + " " + valueOfString(json,"access_token"));
                            }
                        } catch (Exception e) {
                            resultIntent.putExtra(API_STATUS,false);
                        }
                        LocalBroadcastManager.getInstance(LoginService.this).sendBroadcast(resultIntent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultIntent.putExtra(API_STATUS,false);
                LocalBroadcastManager.getInstance(LoginService.this).sendBroadcast(resultIntent);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("username", user_name);
                params.put("password", password);
                params.put("grant_type", "password");
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
