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

    private LinearLayout viewGroup;

    private int iconSize = getContext().getResources().getDimensionPixelSize(R.dimen.icon_size);
    private int iconMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.icon_margin);
    private int iconGroupHeight = getContext().getResources().getDimensionPixelSize(R.dimen.icon_group_height_size);

    private ImageView microphoneIcon = new ImageView(getContext());
    private ImageView cameraIcon = new ImageView(getContext());
    private ImageView locationIcon = new ImageView(getContext());

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

    private ShapeDrawable createBgDrawable(int color) {
        float radii = iconSize / 2F;
        float[] radiis = new float[]{radii, radii, radii, radii, radii, radii, radii, radii};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(radiis, null, null));
        shapeDrawable.setBounds(10, 10, 100, 100);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private void init() {
        LinearLayout.LayoutParams groupParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, iconGroupHeight);
        groupParams.gravity = Gravity.CENTER_VERTICAL;

        viewGroup = new LinearLayout(getContext());
        viewGroup.setOrientation(HORIZONTAL);
        viewGroup.setBackground(createBgDrawable(bgColor));
        viewGroup.setClipChildren(false);
        addView(viewGroup, groupParams);

        microphoneIcon.setImageDrawable(getResources().getDrawable(R.drawable.privacy_microphone, null));
        microphoneIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        microphoneIcon.setVisibility(View.VISIBLE);

        cameraIcon.setImageDrawable(getResources().getDrawable(R.drawable.privacy_camera, null));
        cameraIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        cameraIcon.setVisibility(View.VISIBLE);

        locationIcon.setImageDrawable(getResources().getDrawable(R.drawable.privacy_location, null));
        locationIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        locationIcon.setVisibility(View.VISIBLE);

        LayoutParams layoutParams = new LayoutParams(iconSize, iconSize);
        layoutParams.setMargins(iconMargin, 0, iconMargin, 0);
        layoutParams.gravity = Gravity.CENTER_VERTICAL;

        viewGroup.addView(microphoneIcon, layoutParams);
        viewGroup.addView(cameraIcon, layoutParams);
        viewGroup.addView(locationIcon, layoutParams);

        viewGroup.setOnClickListener(v -> {
            List<Animator> animators = new ArrayList<>();
            animators.add(createWidthObjAnimator(locationIcon, SCALE_X, iconSize, 0, true));
            animators.add(createHeightObjAnimator(locationIcon, SCALE_Y, iconSize, iconSize / 2, true));
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
                    locationIcon.setVisibility(GONE);
                    resetViewStatus(microphoneIcon);
                    Log.e(TAG, "onAnimationEnd: mLikeIcon.width: " + microphoneIcon.getLayoutParams().width + " height: " +
                            microphoneIcon.getLayoutParams().height);
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
            ((ImageView) object).setPivotX(0);
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
            ((ImageView) object).setPivotY(iconSize / 2);
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
