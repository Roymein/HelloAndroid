package com.demo.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CarsonView extends View {
    int red = Color.argb(127, 255, 0, 0);

    /**
     * view 声明在java代码里面 new 的
     */
    public CarsonView(Context context) {
        super(context);
    }

    /**
     * view 是在xml中声明的
     *
     * @param attrs xml属性，当从xml inflate的时候
     */
    public CarsonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 有style属性时
     * 一般是在第二个构造函数中主动调用的，不会主动调用
     *
     * @param attrs        xml属性，当从xml inflate的时候
     * @param defStyleAttr 应用到view的默认风格，定义在主题中
     */
    public CarsonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    /**
     * view 中有style属性时 api 21 之后才使用
     * 一般是在第二个构造函数中主动调用的，不会主动调用
     *
     * @param attrs        xml属性，当从xml inflate的时候
     * @param defStyleAttr 应用到view的默认风格，定义在主题中
     * @param defStyleRes  如果没有使用defStyleAttr 应用到view的默认风格
     */
    public CarsonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
