package com.feizai.mydialog.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;

import com.feizai.mydialog.R;
import com.feizai.mydialog.base.BaseDialog;

import java.lang.reflect.Field;

public class CustomDialog extends BaseDialog {
    private String mTitle;
    private String mContent;
    private String mOkBtnText;
    private String mCancelBtnText;

    private TextView mTitleTv;
    private TextView mContentTv;
    private Button mOkBtn;
    private Button mCancelBtn;

    private View.OnClickListener mOkListener;
    private View.OnClickListener mCancelListener;

    private Object mAttachInfo;
    private Field mHasWindowFocusField;

    private int resId_ok = 0;
    private int resId_cancel = 0;
    public static CustomDialog instance;

    public CustomDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, R.style.MyDialog);
    }

    public static CustomDialog getInstance(Context mContext){
        if (instance == null ){
            instance = new CustomDialog(mContext);
            instance.setOnDismissListener(dialog -> instance = null);
        }
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);
        findView();
        initView();
    }

    private void findView() {
        mTitleTv = (TextView) findViewById(R.id.dialog_title);
        mContentTv = (TextView) findViewById(R.id.dialog_content);
        mOkBtn = (Button) findViewById(R.id.btn_ok);
        mCancelBtn = (Button) findViewById(R.id.btn_cancel);
    }

    private void initView() {
        if (mTitle != null) {
            mTitleTv.setText(mTitle);
        }

        if (mContent != null) {
            mContentTv.setText(mContent);
        }

        if (resId_ok != 0) {
            mOkBtn.setText(resId_ok);
        }

        if (resId_cancel != 0) {
            mCancelBtn.setText(resId_cancel);
        }

        if (mOkBtnText != null) {
            mOkBtn.setText(mOkBtnText);
        }

        if (mCancelBtnText != null) {
            mCancelBtn.setText(mCancelBtnText);
        }

        if (mOkListener != null) {
            mOkBtn.setOnClickListener(mOkListener);
        }

        if (mCancelListener != null) {
            mCancelBtn.setOnClickListener(mCancelListener);
        } else {
            mCancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }

        mOkBtn.requestFocus();
        mOkBtn.requestFocusFromTouch();
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public void setOkListener(View.OnClickListener listener) {
        mOkListener = listener;
    }

    public void setCancelListener(View.OnClickListener listener) {
        mCancelListener = listener;
    }

    public void setBtnOkName(int resId) {
        this.resId_ok = resId;
    }

    public void setBtnCancelName(int resId) {
        this.resId_cancel = resId;
    }

    public void setBtnOkText(String okText) {
        this.mOkBtnText = okText;
    }

    public void setBtnCancelText(String cancelText) {
        this.mCancelBtnText = cancelText;
    }

    public Button getBtnOk() {
        return mOkBtn;
    }

    public Button getBtnCancel() {
        return mCancelBtn;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        try {
            Log.w("hjy", "mHasWindowFocusField: " + mHasWindowFocusField + ", mAttachInfo: " + mAttachInfo);
            if (mHasWindowFocusField != null && mAttachInfo != null) {
                mHasWindowFocusField.set(mAttachInfo, true);
            } else {
                ViewParent viewRootImpl = getWindow().getDecorView().getParent();
                Class viewRootImplClass = viewRootImpl.getClass();

                Field mAttachInfoField = viewRootImplClass.getDeclaredField("mAttachInfo");
                mAttachInfoField.setAccessible(true);
                mAttachInfo = mAttachInfoField.get(viewRootImpl);
                Class mAttachInfoClass = mAttachInfo.getClass();

                mHasWindowFocusField = mAttachInfoClass.getDeclaredField("mHasWindowFocus");
                mHasWindowFocusField.setAccessible(true);
                mHasWindowFocusField.set(mAttachInfo, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.dispatchKeyEvent(event);
    }
}
