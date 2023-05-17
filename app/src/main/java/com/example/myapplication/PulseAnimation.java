package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class PulseAnimation extends View {

    private float radius;
    private final Paint paint = new Paint();
    private static final int COLOR_ADJUSTER = 5;
    private float x,y;
    private static final int ANIMATION_DURATION = 4000;
    private static final long ANIMATION_DELAY = 1000;
    private AnimatorSet animatorSet = new AnimatorSet();

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ObjectAnimator growAnimator = ObjectAnimator.ofFloat(this, "radius", 0, getWidth());
        growAnimator.setDuration(ANIMATION_DURATION);
        growAnimator.setInterpolator(new LinearInterpolator());

        ObjectAnimator shrinkAnimator = ObjectAnimator.ofFloat(this, "radius", getWidth(), 0);
        shrinkAnimator.setDuration(ANIMATION_DURATION);
        shrinkAnimator.setInterpolator(new LinearInterpolator());
        shrinkAnimator.setStartDelay(ANIMATION_DELAY);

        animatorSet.play(growAnimator).before(shrinkAnimator);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x,y,radius,paint);
        if (animatorSet != null && animatorSet.isRunning()){
            animatorSet.cancel();
        }
        animatorSet.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            x = event.getX();
            y = event.getY();
        }
        return super.onTouchEvent(event);
    }

    public void setRadius(float Radius){
        radius = Radius;
        paint.setColor(Color.GREEN + (int) Radius/COLOR_ADJUSTER);
        invalidate();
    }



    public PulseAnimation(Context context) {
        super(context);
    }

    public PulseAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

}
