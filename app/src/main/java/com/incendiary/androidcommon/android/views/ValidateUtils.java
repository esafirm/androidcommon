package com.incendiary.androidcommon.android.views;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

/**
 * Created by esa on 10/06/15, with awesomeness
 */
public class ValidateUtils {

	public static boolean runningValidationWithViews(View... views) {
		return runningValidationWithViews(null, views);
	}

	public static boolean runningValidationWithViews(String message, View... views) {
		boolean isValid = true;
		for (View view : views) {
			if (view instanceof EditText) {
				if (!isValid)
					isNotEmpty((EditText) view, message);
				else
					isValid = isNotEmpty((EditText) view, message);
			}
		}
		return isValid;
	}

	public static boolean isNotEmpty(EditText editText) {
		return isNotEmpty(editText, null);
	}

	public static boolean isNotEmpty(EditText editText, String errorMessage) {
		String text = editText.getText().toString().trim();
		if (TextUtils.isEmpty(text)) {
			if (errorMessage != null)
				editText.setError(errorMessage);
			editText.requestFocus();
			return false;
		}
		return true;
	}

}
