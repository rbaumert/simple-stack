package com.zhuinden.simplestackdemoexamplefragments.presentation.paths.second;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.Bundleable;
import com.zhuinden.simplestackdemoexamplefragments.presentation.paths.tasks.TasksKey;
import com.zhuinden.simplestackdemoexamplefragments.util.BasePresenter;
import com.zhuinden.statebundle.StateBundle;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by Owner on 2017. 01. 27..
 */

public class SecondPresenter
        extends BasePresenter<SecondFragment, SecondPresenter>
        implements Bundleable {
    @Inject
    public SecondPresenter() {
    }

    @Inject
    Backstack backstack;

    BehaviorRelay<String> state = BehaviorRelay.create("");

    Subscription subscription;

    @Override
    protected void onAttach(SecondFragment coordinator) {
        subscription = state.asObservable() //
                .distinctUntilChanged() //
                .doOnNext(_state -> coordinator.setStateText(_state)) //
                .subscribe();
    }

    @Override
    protected void onDetach(SecondFragment coordinator) {
        subscription.unsubscribe();
    }

    public void updateState(String state) {
        this.state.call(state);
    }

    public void goToTodos() {
        backstack.goTo(TasksKey.create());
    }

    @Override
    @NonNull
    public StateBundle toBundle() {
        StateBundle bundle = new StateBundle();
        bundle.putString("state", state.getValue());
        return bundle;
    }

    @Override
    public void fromBundle(@Nullable StateBundle bundle) {
        if(bundle != null) {
            state.call(bundle.getString("state"));
        }
    }
}
