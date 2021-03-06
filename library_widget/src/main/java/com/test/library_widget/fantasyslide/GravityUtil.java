package com.test.library_widget.fantasyslide;

import android.view.Gravity;
import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;

class GravityUtil {

    static boolean isLeft(int gravity) {
        return gravity == Gravity.START || gravity == Gravity.LEFT;
    }

    static boolean isLeft(View view) {
        return isLeft(getGravity(view));
    }

    static boolean isRight(int gravity) {
        return gravity == Gravity.END || gravity == Gravity.RIGHT;
    }

    static boolean isRight(View view) {
        return isRight(getGravity(view));
    }

    static int getGravity(View view) {
        if (view.getLayoutParams() instanceof DrawerLayout.LayoutParams) {
            return ((DrawerLayout.LayoutParams) view.getLayoutParams()).gravity;
        }
        throw new IllegalArgumentException("Not child of DrawerLayout");
    }
}
