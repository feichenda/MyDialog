package com.feizai.mydialog.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyApp extends Application {

    private static final String TAG = "MyAPP";
    private static Activity topActivity;
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                Log.d(TAG, activity + "onActivityCreated");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                Log.d(TAG, activity + "onActivityStarted");
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Log.d(TAG, activity + "onActivityResumed");
                topActivity = activity;
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                if (topActivity == activity) {
                    topActivity = null;
                }
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }

    public static String getCurrentActivity() {
        if (topActivity == null) {
            return "";
        } else {
            return topActivity.getClass().getSimpleName();
        }
    }
}
