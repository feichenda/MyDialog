package com.feizai.mydialog.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtil {
    private final static String SHARE_PRES_NAME = "SHARE_PRES_NAME";
    public final static String KEY_DISPLAY_TIME = "DISPLAY_TIME";
    public final static String KEY_SYSTEM_LOCK_OPEN = "SYSTEM_LOCK_OPEN";
    public final static String KEY_SYSTEM_LOCK_PWD = "SYSTEM_LOCK_PWD";
    public final static String KEY_USER_120HZ = "USER_120HZ";
    public final static String KEY_USER_500HZ = "USER_500HZ";
    public final static String KEY_USER_1_5KHZ = "USER_1_5KHZ";
    public final static String KEY_USER_5KHZ = "USER_5KHZ";
    public final static String KEY_USER_10KHZ = "USER_10KHZ";
    public final static String KEY_USER_BRIGHTNESS = "USER_BRIGHTNESS";
    public final static String KEY_USER_CONTRAST = "USER_CONTRAST";
    public final static String KEY_USER_HUE = "USER_HUE";
    public final static String KEY_USER_SATURATION = "USER_SATURATION";
    public final static String KEY_USER_SHARPNESS = "USER_SHARPNESS";
    public final static String KEY_AUTO_SLEEP_TIME = "AUTO_SLEEP_TIME";
    public final static String KEY_TIME_SHIFT_START = "TIME_SHIFT_START";
    public static final String KEY_PVR_START = "PVR_START";
    public static final String KEY_PVR_PLAYBACK_START = "PVR_PLAYBACK_START";
    public static final String KEY_PVR_DISK = "PVR_DISK";

    public static String getValue(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }

    public static int getValue(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultValue);
    }

    public static float getValue(Context context, String key, float defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public static boolean getValue(Context context, String key, boolean defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void setValue(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static void setValue(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void setValue(Context context, String key, float value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putFloat(key, value);
        edit.commit();
    }

    public static void setValue(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PRES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }
}
