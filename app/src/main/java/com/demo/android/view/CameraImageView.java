package com.demo.android.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.demo.android.R;

public class CameraImageView extends androidx.appcompat.widget.AppCompatImageView {
    private Bitmap mBitmap;
    private Paint mPaint;
    private Camera mCamera = new Camera();
    private Matrix mMatrix = new Matrix();
    private int mProcess;


    public CameraImageView(Context context) {
        super(context);

        init();
    }

    public CameraImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public CameraImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setProgress(int progress) {
        mProcess = progress;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mCamera.save();
        canvas.save();

        mPaint.setAlpha(100);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        mCamera.rotateY(mProcess);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();

        super.onDraw(canvas);
        canvas.restore();
    }
}
