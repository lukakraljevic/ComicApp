package com.example.luka.comicsapp.base;

import com.example.luka.comicsapp.di.activity.ThreadingModule;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.BehaviorProcessor;
import io.reactivex.processors.FlowableProcessor;

public abstract class BasePresenter<View extends BaseView, ViewState> implements ViewPresenter<View, ViewState> {

    protected View view;

    @Inject
    @Named(ThreadingModule.MAIN_SCHEDULER)
    protected Scheduler mainThreadScheduler;

    @Inject
    @Named(ThreadingModule.BACKGROUND_SCHEDULER)
    protected Scheduler backgroundScheduler;

    protected ViewState viewState;

    private final FlowableProcessor<ViewState> viewStateFlowable = BehaviorProcessor.<ViewState>create().toSerialized();

    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void start() {
        viewState = initialViewState();
    }

    @Override
    public void activate() {
    }

    @Override
    public void deactivate() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
        compositeDisposable.clear();
    }

    @Override
    public void back() {
    }

    protected void query(Single<Consumer<ViewState>> single) {
        compositeDisposable.add(single
                .subscribeOn(backgroundScheduler)
                .observeOn(mainThreadScheduler)
                .subscribe(this::acceptViewState));
    }

    private void acceptViewState(Consumer<ViewState> consumer) {
        try {
            consumer.accept(viewState);
            viewStateFlowable.onNext(viewState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flowable<ViewState> viewState() {
        return viewStateFlowable;
    }

    public abstract ViewState initialViewState();
}