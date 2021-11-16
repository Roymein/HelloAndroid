package com.demo.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class EmbossMaskFilterView extends View {
    private static final String TAG = "EmbossMaskFilterView";

    private Context mContext;
    private Paint mPaint;
    private EmbossMaskFilter mEmbossMaskFilter;

    private final int mWidth = 64;
    private final int mTextSize = 800;

    private final float mLight = 0.05f;
    private final float mSpecular = 5;
    private final float mBlur = 13;
    private final float[] mDirection = new float[]{1, 1, 1};

    public EmbossMaskFilterView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public EmbossMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public EmbossMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public EmbossMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mWidth);
        mPaint.setTextSize(mTextSize);
        mEmbossMaskFilter = new EmbossMaskFilter(mDirection, mLight, mSpecular, mBlur);
        mPaint.setMaskFilter(mEmbossMaskFilter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        int width = bounds.width();
        int height = bounds.height();
        Log.e(TAG, "onDraw: width:" + width + " ,height:" + height);
        canvas.drawText("炫", width / 10, height / 3, mPaint);
    }
}
