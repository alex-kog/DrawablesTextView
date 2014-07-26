package com.ak.library.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ak.library.util.OnClickTextViewColor;


/**
 * Created by Administrator on 0026, July 26.
 */
public abstract class AbstractDrawableTextView extends TextView {
    private final OnClickTextViewColor onClickTextViewColor;

    public AbstractDrawableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onClickTextViewColor = OnClickTextViewColor.with(context);
    }

    public void setColorId(int colorId) {
        onClickTextViewColor.fromColor(colorId);
    }

    public void setOnClickColorId(int colorId) {
        onClickTextViewColor.toColor(colorId);
    }

    public void setDrawableId(int drawableId) {
        onClickTextViewColor.drawable(drawableId).setTextView(this);
        Drawable drawable = getResources().getDrawable(drawableId);
        setPositionDrawable(drawable);
    }

    abstract protected void setPositionDrawable(Drawable drawable);
}
