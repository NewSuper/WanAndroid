package com.test.mine;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/**
 * <p>下拉时显示FAB，上拉隐藏，留出更多位置给用户。</p>
 * Created on 2016/12/1.
 *
 * @author xujun
 */
public class ScaleDownShowBehavior extends FloatingActionButton.Behavior {
    /**
     * 退出动画是否正在执行。
     */
    private boolean isAnimatingOut = false;

    private OnStateChangedListener mOnStateChangedListener;

    public ScaleDownShowBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if ((dyConsumed > 0 || dyUnconsumed > 0) && !isAnimatingOut && child.getVisibility() == View.VISIBLE) {//往下滑
            child.setVisibility(View.INVISIBLE);
            AnimatorUtil.scaleHide(child, viewPropertyAnimatorListener);
            if (mOnStateChangedListener != null) {
                mOnStateChangedListener.onChanged(false);
            }
        } else if ((dyConsumed < 0 || dyUnconsumed < 0) && child.getVisibility() != View.VISIBLE) {
            AnimatorUtil.scaleShow(child, null);
            if (mOnStateChangedListener != null) {
                mOnStateChangedListener.onChanged(true);
            }
        }
    }

    public void setOnStateChangedListener(OnStateChangedListener mOnStateChangedListener) {
        this.mOnStateChangedListener = mOnStateChangedListener;
    }

    // 外部监听显示和隐藏。
    public interface OnStateChangedListener {
        void onChanged(boolean isShow);
    }

    public static <V extends View> ScaleDownShowBehavior from(V view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
        if (!(behavior instanceof ScaleDownShowBehavior)) {
            throw new IllegalArgumentException("The view is not associated with ScaleDownShowBehavior");
        }
        return (ScaleDownShowBehavior) behavior;
    }

    private ViewPropertyAnimatorListener viewPropertyAnimatorListener = new ViewPropertyAnimatorListener() {

        @Override
        public void onAnimationStart(View view) {
            isAnimatingOut = true;
        }

        @Override
        public void onAnimationEnd(View view) {
            isAnimatingOut = false;
            // 注意不要设置为 Gone，这样在高版本的会导致 viewBehavior.onNestedScrol 没机会调用
            view.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onAnimationCancel(View arg0) {
            isAnimatingOut = false;
        }
    };
}
