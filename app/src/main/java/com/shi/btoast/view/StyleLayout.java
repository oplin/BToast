package com.shi.btoast.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.shi.btoast.BToastUtils;

/**
 * created by bravin on 2018/7/17.
 */
public class StyleLayout extends RelativeLayout {
    private int radius;
    private int style = STYLE_RECTANGLE;

    public static final int STYLE_FILLET = 1;
    public static final int STYLE_RECTANGLE = 2;

    private static float[] radiusArr = new float[8];
    private int tintColor;

    public StyleLayout(Context context) {
        super(context);
    }

    public StyleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StyleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int height = getMeasuredHeight();
        if (style == STYLE_FILLET) {
            if (height / 2 != radius) {
                radius = height / 2;
                refreshRadius();
                BToastUtils.setGradientDrawable(this, radiusArr, tintColor);
            }
        } else {
            if (tintColor != 0){
                setBackgroundColor(tintColor);
            }
        }

    }

    public void setStyle(int style) {
        this.style = style;
    }

    public void setTintColor(int tintColor) {
        this.tintColor = tintColor;
    }

    private void refreshRadius() {
        radiusArr[0] = radius;
        radiusArr[1] = radius;
        radiusArr[2] = radius;
        radiusArr[3] = radius;
        radiusArr[4] = radius;
        radiusArr[5] = radius;
        radiusArr[6] = radius;
        radiusArr[7] = radius;
    }
}
