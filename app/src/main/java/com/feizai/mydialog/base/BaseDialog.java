package com.feizai.mydialog.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class BaseDialog extends Dialog {
    private CountDownTimer mTimer;

    public BaseDialog(Context context) {
        super(context);
        if (context instanceof BaseActivity) {
            mTimer = ((BaseActivity) context).mTimer;
        }
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        if (context instanceof BaseActivity) {
            mTimer = ((BaseActivity) context).mTimer;
        }
    }

    protected BaseDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        if (context instanceof BaseActivity) {
            mTimer = ((BaseActivity) context).mTimer;
        }
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
