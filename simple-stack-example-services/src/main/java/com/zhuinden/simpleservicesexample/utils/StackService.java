package com.zhuinden.simpleservicesexample.utils;

import android.content.Context;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.BackstackDelegate;

/**
 * Created by Zhuinden on 2017.02.14..
 */

public class StackService {
    private StackService() {
    }

    public static final String TAG = "StackService";

    public static Backstack get(Context context) {
        // noinspection ResourceType
        return (Backstack) context.getSystemService(TAG);
    }
}
