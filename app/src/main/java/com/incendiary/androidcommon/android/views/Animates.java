package com.incendiary.androidcommon.android.views;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by esa on 14/03/16, with awesomeness
 */
public class Animates {

  public static void visibility(final View view, final boolean isVisible) {
    if (isVisible) {
      view.setAlpha(0);
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
}
