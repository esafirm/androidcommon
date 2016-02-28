package com.incendiary.androidcommon.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/**
 * Created by esa on 10/02/16, with awesomeness
 */
public class Intents {

  /**
   * Context using {@code Contextor}
   **/
  @SuppressWarnings("WrongConstant")
  public static Uri grantUriForKitkatAbove(Intent data) {
    Uri originalUri = data.getData();
    if (Build.VERSION.SDK_INT >= 19) {
      final int takeFlags = data.getFlags()
        & (Intent.FLAG_GRANT_READ_URI_PERMISSION
        | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

      ContextProvider.get().getContentResolver()
        .takePersistableUriPermission(originalUri, takeFlags);
    }
    return originalUri;
  }
}
