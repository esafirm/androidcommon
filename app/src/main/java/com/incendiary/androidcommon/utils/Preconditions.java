package com.incendiary.androidcommon.utils;

import android.support.annotation.Nullable;

public class Preconditions {

    public static <T> T checkNotNull(@Nullable T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static <T> T checkNotNull(@Nullable T reference, String message) {
        if (reference == null) {
            throw new NullPointerException(message);
        }
        return reference;
    }
}
