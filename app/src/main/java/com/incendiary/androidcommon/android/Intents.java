package com.incendiary.androidcommon.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import com.incendiary.androidcommon.android.helper.Startable;

import java.io.File;

/**
 * Created by esa on 10/02/16, with awesomeness
 */
public class Intents {

  public static final String MIME_TYPE_AUDIO = "audio/*";
  public static final String MIME_TYPE_TEXT = "text/*";
  public static final String MIME_TYPE_IMAGE = "image/*";
  public static final String MIME_TYPE_VIDEO = "video/*";

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

  public static Intent createGetContentIntent(String mime) {
    final Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    intent.setType(mime);
    intent.addCategory(Intent.CATEGORY_OPENABLE);
    return intent;
  }

  public static void showImageChooser(Startable startable, int requestCode) {
    Intent target = createGetContentIntent(MIME_TYPE_IMAGE);
    Intent intent = Intent.createChooser(target, "Choose a photo");
    try {
      startable.startForResult(intent, requestCode);
    } catch (ActivityNotFoundException ignored) {
    }
  }

  public static void pickPicture(Startable startable, int requestCode) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      try {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startable.startForResult(intent, requestCode);
      } catch (Exception e) {
        showImageChooser(startable, requestCode);
      }
    } else {
      showImageChooser(startable, requestCode);
    }
  }

  public static void takePicture(Startable startable, int reqCode) {
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (intent.resolveActivity(ContextProvider.get().getPackageManager()) != null) {
      startable.startForResult(intent, reqCode);
    }
  }

  public static void dial(String phoneNo) {
    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNo, null));
    ContextProvider.get().startActivity(intent);
  }

  public static void viewAction(Context context, String data) {
    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(data)));
  }


  public static void shareFile(Context context, File file, String mimeType) {
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType(mimeType);
    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
