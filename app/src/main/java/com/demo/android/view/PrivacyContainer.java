package com.demo.android.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.demo.android.R;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.HORIZONTAL;

public class PrivacyContainer extends FrameLayout {
    private static final String TAG = "PrivacyContainer";

    private static final String SCALE_X = "scaleX";
    private static final String SCALE_Y = "scaleY";
    private static final String ALPHA = "alpha";
    private static final String COLOR = "color";
    private static final String TRANSLATION_X = "translationX";

    private int bgColor = getResources().getColor(R.color.red);
    private int locationColor = getResources().getColor(R.color.green);
    private int microPhoneColor = getResources().getColor(R.color.blue);

    private PathInterpolator mPathInterpolator = new PathInterpolator(0F, 0f, 0.1f, 1f);


    private Drawable catIcon = getResources().getDrawable(R.drawable.cat);

    private LinearLayout viewGroup;

    private int iconSize = getContext().getResources().getDimensionPixelSize(R.dimen.icon_size);
    private int iconMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.icon_margin);

    private ImageView mLikeIcon = new ImageView(getContext());
    private ImageView mPlayIcon = new ImageView(getContext());

    public PrivacyContainer(@NonNull Context context) {
        super(context);
        init();
    }

    public PrivacyContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PrivacyContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PrivacyContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private ShapeDrawable createBgDrawable(int color) {
        float radii = iconSize / 2F;
        float[] radiis = new float[]{radii, radii, radii, radii, radii, radii, radii, radii};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(radiis, null, null));
        shapeDrawable.setBounds(10, 10, 100, 100);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private void init() {
        LayoutParams groupParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        groupParams.gravity = Gravity.CENTER;

        viewGroup = new LinearLayout(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        viewGroup.setOrientation(HORIZONTAL);
        viewGroup.setBackground(createBgDrawable(bgColor));
        viewGroup.setClipChildren(false);
        viewGroup.setLayoutParams(params);
        addView(viewGroup, groupParams);

        mLikeIcon.setImageDrawable(getResources().getDrawable(R.drawable.icon_like, null));
        mLikeIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mLikeIcon.setVisibility(View.VISIBLE);

        mPlayIcon.setImageDrawable(getResources().getDrawable(R.drawable.icon_play, null));
        mPlayIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mPlayIcon.setVisibility(View.VISIBLE);

        LayoutParams layoutParams = new LayoutParams(iconSize, iconSize);
        layoutParams.setMargins(iconMargin, 0, iconMargin, 0);
        viewGroup.addView(mLikeIcon, layoutParams);
        viewGroup.addView(mPlayIcon, layoutParams);

        viewGroup.setOnClickListener(v -> {
            List<Animator> animators = new ArrayList<>();
            animators.add(createWidthObjAnimator(mLikeIcon, SCALE_X, iconSize / 2, 0, true));
            animators.add(createHeightObjAnimator(mLikeIcon, SCALE_Y, iconSize / 2, 0, true));
            animators.add(createBgColorAnimator(viewGroup, COLOR, bgColor, locationColor));

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animators);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.e(TAG, "onAnimationStart");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mLikeIcon.setVisibility(GONE);
                    resetViewStatus(mLikeIcon);
                    Log.e(TAG, "onAnimationEnd: mLikeIcon.width: " + mLikeIcon.getLayoutParams().width + " height: " +
                            mLikeIcon.getLayoutParams().height);
                }
            });
            animatorSet.start();
        });

    }

    private void resetViewStatus(View view) {
        view.setScaleX(1F);
        view.setScaleY(1F);
        view.setAlpha(1F);
        view.setTranslationX(0F);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = iconSize;
        layoutParams.height = iconSize;
    }

    private ObjectAnimator createBgColorAnimator(Object object, String propertyName, int start, int end) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofArgb(object, propertyName, start, end);
        objectAnimator.setDuration(333L);
        objectAnimator.setInterpolator(mPathInterpolator);
        objectAnimator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            Log.e(TAG, "createBgColorAnimator: animatedValue: " + animatedValue);
            Drawable background = ((View) object).getBackground();
            background.setTint(animatedValue);

        });
        return objectAnimator;
    }

    private ObjectAnimator createWidthObjAnimator(Object object, String propertyName, int start, int end, boolean setPivot) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(object, propertyName, start, end);
        objectAnimator.setDuration(333L);

        objectAnimator.setInterpolator(mPathInterpolator);
        if (setPivot) {
            ((ImageView) object).setPivotX(0F);
        }
        objectAnimator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            Log.e(TAG, "createWidthObjAnimator: animatedValue: " + animatedValue);
            ViewGroup.LayoutParams layoutParams = ((ImageView) object).getLayoutParams();

            layoutParams.width = animatedValue;
            ((ImageView) object).setLayoutParams(layoutParams);
        });
        return objectAnimator;
    }

    private ObjectAnimator createHeightObjAnimator(Object object, String propertyName, int start, int end, boolean setPivot) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(object, propertyName, start, end);
        objectAnimator.setDuration(333L);

        objectAnimator.setInterpolator(mPathInterpolator);
        if (setPivot) {
            ((ImageView) object).setPivotY(iconSize / 2f);
        }
        objectAnimator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            Log.e(TAG, "createHeightObjAnimator: animatedValue: " + animatedValue);
            ViewGroup.LayoutParams layoutParams = ((ImageView) object).getLayoutParams();

            layoutParams.height = animatedValue;
            ((ImageView) object).setLayoutParams(layoutParams);
        });
        return objectAnimator;
    }
}
