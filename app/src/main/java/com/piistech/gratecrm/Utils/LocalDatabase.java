package com.piistech.gratecrm.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import static com.piistech.gratecrm.Utils.Constant.LOCAL_DATABASE_NAME;

public class LocalDatabase {
    public static void setIntValue(final Context context, String key, int value) {
        final SharedPreferences prefs = context.getSharedPreferences( LOCAL_DATABASE_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public static int getIntValue(final Context context, String key) {
        return context.getSharedPreferences(LOCAL_DATABASE_NAME, Context.MODE_PRIVATE).getInt(key,0);
    }

    public static void setFloatValue(final Context context, String key, Float value) {
        final SharedPreferences prefs = context.getSharedPreferences( LOCAL_DATABASE_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(key, value);
        editor.commit();
    }
    public static Float getFloatValue(final Context context, String key) {
        return context.getSharedPreferences(LOCAL_DATABASE_NAME, Context.MODE_PRIVATE).getFloat(key,0.0f);
    }

    public static void setStringValue(final Context context, String key, String value) {
        final SharedPreferences prefs = context.getSharedPreferences( LOCAL_DATABASE_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public static String getStringValue(final Context context, String key) {
        return context.getSharedPreferences(LOCAL_DATABASE_NAME, Context.MODE_PRIVATE).getString(key,"");
    }

    public static void setBooleanValue(final Context context, String key, Boolean status) {
        final SharedPreferences prefs = context.getSharedPreferences( LOCAL_DATABASE_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, status);
        editor.commit();
    }
    public static boolean getBooleanValue(final Context context, String key) {
        return context.getSharedPreferences(LOCAL_DATABASE_NAME, Context.MODE_PRIVATE).getBoolean(key,false);
    }
}
