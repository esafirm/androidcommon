package com.incendiary.androidcommon.android;

import android.text.TextUtils;

import java.util.Locale;

/**
 * Created by esa on 14/11/14.
 */
public class FormatUtils {

	public static String uppercaseFirstLetter(String data) {
		if (!TextUtils.isEmpty(data))
			data = data.substring(0, 1).toUpperCase(Locale.getDefault()) +
					data.substring(1);
		return data;
	}
}
