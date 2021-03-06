package com.zhuinden.simplestackdemoexamplemvp.presentation.paths.second;

import android.support.annotation.NonNull;
import android.view.View;

import com.google.auto.value.AutoValue;
import com.zhuinden.simplestack.navigator.ViewChangeHandler;
import com.zhuinden.simplestack.navigator.changehandlers.SegueViewChangeHandler;
import com.zhuinden.simplestackdemoexamplemvp.R;
import com.zhuinden.simplestackdemoexamplemvp.application.Key;

/**
 * Created by Owner on 2017. 01. 12..
 */

@AutoValue
public abstract class SecondKey implements Key {
    public static SecondKey create() {
        return new AutoValue_SecondKey(R.layout.path_second);
    }

    @NonNull
    @Override
    public ViewChangeHandler viewChangeHandler() {
        return new SegueViewChangeHandler();
    }

    @Override
    public int menu() {
        return R.menu.empty_menu;
    }

    @Override
    public boolean isFabVisible() {
        return false;
    }

    @Override
    public int navigationViewId() {
        return 0;
    }

    @Override
    public boolean shouldShowUp() {
        return false;
    }

    @Override
    public View.OnClickListener fabClickListener(View view) {
        return v -> {
        };
    }

    @Override
    public int fabDrawableIcon() {
        return 0;
    }
}
