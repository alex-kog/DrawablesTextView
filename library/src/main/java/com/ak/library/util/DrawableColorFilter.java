package com.ak.library.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 0024, July 24.
 */
public class DrawableColorFilter {

    Context context;

    private static final PorterDuff.Mode[] mModes = new PorterDuff.Mode[] {
                PorterDuff.Mode.DARKEN,
                PorterDuff.Mode.DST,
                PorterDuff.Mode.DST_ATOP,
                PorterDuff.Mode.DST_IN,
                PorterDuff.Mode.DST_OUT,
                PorterDuff.Mode.DST_OVER,
                PorterDuff.Mode.LIGHTEN,
                PorterDuff.Mode.MULTIPLY,
                PorterDuff.Mode.SCREEN,
                PorterDuff.Mode.SRC,
                PorterDuff.Mode.SRC_ATOP,
                PorterDuff.Mode.SRC_IN,
                PorterDuff.Mode.SRC_OUT,
                PorterDuff.Mode.SRC_OVER,
                PorterDuff.Mode.XOR
    };
    private PorterDuff.Mode mode;
    private int colorId;

    public static DrawableColorFilter with(Context context) {
        return new DrawableColorFilter(context);
    }

    private DrawableColorFilter(Context context) {
        this.context = context;
    }

    public DrawableColorFilter mode(PorterDuff.Mode mode) {
        this.mode = mode;
        return this;
    }

    public DrawableColorFilter color(int colorId) {
        this.colorId = colorId;
        return this;
    }

    public void onDrawable(Drawable drawable) {
        int colorInt = context.getResources().getColor(colorId);
        drawable.setColorFilter(colorInt, mode);
    }

}
