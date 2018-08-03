package com.example.luka.comicsapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.luka.comicsapp.di.activity.DaggerActivity;
import com.example.luka.comicsapp.di.activity.ThreadingModule;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity extends DaggerActivity implements BaseView {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    @Named(ThreadingModule.MAIN_SCHEDULER)
    protected Scheduler mainThreadScheduler;

    @Inject
    @Named(ThreadingModule.BACKGROUND_SCHEDULER)
    protected Scheduler backgroundScheduler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        startPresenter();
    }

    protected abstract int getContentView();

    private void startPresenter() {
        getPresenter().setView(this);
        getPresenter().start();
    }

    protected void addDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        if (isFinishing()) {
            compositeDisposable.clear();
            getPresenter().destroy();
        }

        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().activate();
    }

    @Override
    protected void onPause() {
        getPresenter().deactivate();
        super.onPause();
    }

    public abstract ViewPresenter getPresenter();

    public void initUI() {
        ButterKnife.bind(this);
    }
}