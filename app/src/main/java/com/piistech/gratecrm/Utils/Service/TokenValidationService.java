package com.piistech.gratecrm.Utils.Service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.piistech.gratecrm.Utils.LocalDatabase;

import java.util.Calendar;

import static com.piistech.gratecrm.Utils.Constant.BROADCAST_ID_FOR_TOKEN_EXPIRE;
import static com.piistech.gratecrm.Utils.Constant.EXPIRE_TIME;

public class TokenValidationService extends IntentService {
    boolean shouldContinue = true;
    public TokenValidationService() {
        super("TokenValidationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int time = 60;
        while (true) {
            try {
                if (!shouldContinue) {
                    stopSelf();
                    return;
                } else {
                    time--;
                    System.out.println(time);
                    if ((Calendar.getInstance().getTimeInMillis() / 1000) < LocalDatabase.getLongValue(this, EXPIRE_TIME)) {
                        Thread.sleep(1000);
                    } else {
                        shouldContinue = false;
                        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(BROADCAST_ID_FOR_TOKEN_EXPIRE));
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
        }
    }
}
