package com.example.luka.comicsapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.luka.comicsapp.di.activity.DaggerActivity;
import com.example.luka.comicsapp.ui.utils.ViewIdGenerator;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity extends DaggerActivity implements BaseView {

    private static final String KEY_VIEW_ID = "view_id";

    @Inject
    ViewIdGenerator viewIdGenerator;
    private String viewId;
    private boolean isViewRecreated;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
        setContentView(getContentView());
        startPresenter();
    }

    protected abstract int getContentView();

    private void initView(@Nullable final Bundle savedInstanceState) {
        isViewRecreated = (savedInstanceState != null);
        viewId = (savedInstanceState == null) ? viewIdGenerator.newId()
                : savedInstanceState.getString(KEY_VIEW_ID);
    }

    @Override
    public String getViewId() {
        return viewId;
    }

    @Override
    public boolean isRecreated() {
        return isViewRecreated;
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_VIEW_ID, viewId);
    }

    private void startPresenter() {
        getPresenter().start();
        getPresenter().setView(this);
    }

    @Override
    protected void onDestroy() {
        if (isFinishing()) {
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

    public abstract IBasePresenter getPresenter();

    public void initUI() {
        ButterKnife.bind(this);
    }
}