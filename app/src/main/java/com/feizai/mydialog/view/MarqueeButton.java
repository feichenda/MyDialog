package com.feizai.mydialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MarqueeButton extends Button {
    public MarqueeButton(Context context) {
        super(context);
    }

    public MarqueeButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
