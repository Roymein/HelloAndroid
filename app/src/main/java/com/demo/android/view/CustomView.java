package com.demo.android.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private static final String TAG = "CustomView";

    private Paint mPaint;

    private Path mPath;

    private int mTop;

    public CustomView(Context context) {
        super(context);
        initView();
        initAnim();

    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        initAnim();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        initAnim();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
        initAnim();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(0.5f);
        initPath();
    }

    private void initPath() {
        mPath = new Path();
        mPath.moveTo(100, 100);
        mPath.lineTo(200, 100);
        mPath.lineTo(200, 200);
        mPath.close();
    }

    private void initAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 50, 0);
        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(animation -> {
            Integer value = (Integer) animation.getAnimatedValue();
            setTop(mTop - value);
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mTop = top;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
