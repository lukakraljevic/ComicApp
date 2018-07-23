package com.example.luka.comicsapp.ui.comics;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

public final class LazyLoadingManager extends RecyclerView.OnScrollListener {

    private final ComicContract.Presenter presenter;
    private final SwipeRefreshLayout swipeContainer;

    public LazyLoadingManager(ComicContract.Presenter presenter, SwipeRefreshLayout swipeContainer) {
        this.presenter = presenter;
        this.swipeContainer = swipeContainer;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (!recyclerView.canScrollVertically(1) && !presenter.getLoading()) {
            presenter.setLoading(true);
            swipeContainer.setRefreshing(true);
            presenter.getComics();
        }
    }
}
