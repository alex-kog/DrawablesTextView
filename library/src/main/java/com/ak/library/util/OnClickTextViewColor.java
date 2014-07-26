package com.ak.library.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 0024, July 24.
 */
public class OnClickTextViewColor {

    private Drawable drawable;
    private Context context;
    private DrawableColorFilter colorFilter;
    private int fromColorId;
    private int toColorId;

    public static OnClickTextViewColor with(Context context) {
        return new OnClickTextViewColor(context);
    }

    private OnClickTextViewColor(Context context) {
        this.context = context;
        colorFilter = DrawableColorFilter.with(context);
    }

    public OnClickTextViewColor drawable(int drawableId) {
        drawable = context.getResources().getDrawable(drawableId);
        return this;
    }

    public OnClickTextViewColor fromColor(int id) {
        fromColorId = id;
        return this;
    }


    public OnClickTextViewColor toColor(int id) {
        toColorId = id;
        return this;
    }

    public void setTextView(TextView textView) {
        colorFilter.mode(PorterDuff.Mode.SRC_ATOP).color(fromColorId).onDrawable(drawable);
        textView.setCompoundDrawablesWithIntrinsicBounds(this.drawable, null, null, null);

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent me) {
                TextView textView = (TextView) view;
                if (me.getAction() == MotionEvent.ACTION_DOWN) {
                    colorFilter.mode(PorterDuff.Mode.SRC_ATOP).color(toColorId).onDrawable(drawable);
                } else if (me.getAction() == MotionEvent.ACTION_UP) {
                    colorFilter.mode(PorterDuff.Mode.SRC_ATOP).color(fromColorId).onDrawable(drawable);
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                return false;
            }
        });
    }
}
