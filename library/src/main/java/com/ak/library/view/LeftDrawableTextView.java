package com.ak.library.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created by Administrator on 0026, July 26.
 */
public class LeftDrawableTextView extends AbstractDrawableTextView {

    public LeftDrawableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void setPositionDrawable(Drawable drawable) {
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }
}
