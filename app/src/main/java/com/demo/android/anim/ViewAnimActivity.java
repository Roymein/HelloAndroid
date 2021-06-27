package com.demo.android.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.demo.android.R;

/**
 * this is exercising view anim.
 *
 * @author Roymein
 * @see android.view.animation.TranslateAnimation
 * @see android.view.animation.RotateAnimation
 * @see android.view.animation.ScaleAnimation
 * @see android.view.animation.AlphaAnimation
 */
public class ViewAnimActivity extends AppCompatActivity {
    public static final String TAG = "ViewAnimActivity";
    private boolean mIsXmlMode = true;
    private TextView mTvShowMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        mTvShowMode = findViewById(R.id.tv_set_mode);
    }

    public void oncClickSet(View view) {
        String mode = mTvShowMode.getText().toString();
        if (mode.equals("xml")) {
            mIsXmlMode = false;
            mTvShowMode.setText("java");
        } else if (mode.equals("java")) {
            mIsXmlMode = true;
            mTvShowMode.setText("xml");
        }
    }

    public void onClickTranslateAnim(View view) {
        if (mIsXmlMode == true) {
            Animation tsAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
            view.startAnimation(tsAnim);
        } else {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 500, 0, 500);
            translateAnimation.setDuration(5000);
            translateAnimation.setRepeatMode(2);
            view.startAnimation(translateAnimation);
        }

    }

    public void onClickScaleAnim(View view) {
        if (mIsXmlMode) {
            Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
            view.startAnimation(scaleAnim);
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2, 1, 1);
            scaleAnimation.setDuration(3000);
            view.startAnimation(scaleAnimation);
        }
    }

    public void onClickRotateAnim(View view) {
        if (mIsXmlMode) {
            Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.rotation_anim);
            view.startAnimation(scaleAnim);
        } else {
            RotateAnimation rotateAnimation = new RotateAnimation(0, 270,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(4000);
            view.startAnimation(rotateAnimation);
        }
    }

    public void onClickAlphaAnim(View view) {
        if (mIsXmlMode) {
            Animation alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
            view.startAnimation(alphaAnim);
        } else {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(4000);
            view.startAnimation(alphaAnimation);
        }
    }


    public void onClickCombineAnim(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e(TAG, "onAnimationStart: " + animation.getDuration());
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e(TAG, "onAnimationEnd: " + animation.getDuration());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e(TAG, "onAnimationRepeat: " + animation.getDuration());
            }
        });
        view.startAnimation(animation);

    }
}