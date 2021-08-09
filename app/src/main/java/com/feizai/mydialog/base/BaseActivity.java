package com.feizai.mydialog.base;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.feizai.mydialog.MainActivity;
import com.feizai.mydialog.application.MyApp;
import com.feizai.mydialog.util.SharePreferenceUtil;

public class BaseActivity extends Activity {
    public CountDownTimer mTimer;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void setTimerTime(long timeInSecond) {
        if (mTimer != null) {
            mTimer.cancel();
        }

        if (timeInSecond <= 0) {
            mTimer = null;
        } else {

            mTimer = new CountDownTimer(timeInSecond * 1000, timeInSecond * 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    if (MyApp.getCurrentActivity().equals("TTXLanguageActivity")) {
                        BaseActivity.this.finish();
                        return;
                    }
                    Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            };
            mTimer.start();
        }
    }

    public void cancelTimer() {
        if (mTimer != null) {
            mTimer.cancel();
        }
    }

    public void startTimer() {
        setTimerTime(SharePreferenceUtil.getValue(this, SharePreferenceUtil.KEY_DISPLAY_TIME, 15));
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer.start();
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer.start();
        }
        return super.dispatchGenericMotionEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer.start();
        }
        return super.dispatchTouchEvent(ev);
    }
}
