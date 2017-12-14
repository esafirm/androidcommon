package com.incendiary.androidcommon.android.views;

import android.support.v4.view.ViewCompat;
import android.view.View;

public class Animates {

    public static void visibility(final View view, final boolean isVisible) {
        if (isVisible) {
            ViewCompat.setAlpha(view, 0);
            view.setVisibility(View.VISIBLE);
        }

        float alpha = isVisible ? 1f : 0f;
        ViewCompat.animate(view)
                .setDuration(200)
                .alpha(alpha)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        if (!isVisible)
                            view.setVisibility(View.GONE);
                    }
                });
    }

    public static void zoomInZoomOut(final View view) {
        ViewCompat.animate(view)
                .scaleX(1.2f).scaleY(1.2f)
                .setDuration(200)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        ViewCompat.animate(view)
                                .scaleY(1f).scaleX(1f)
                                .setDuration(200)
                                .setListener(null);
                    }
                });
    }
}
