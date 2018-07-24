package com.example.luka.comicsapp.ui.comics;

import android.support.v7.widget.RecyclerView;

import com.example.luka.comicsapp.ui.listener.LazyLoadingListener;

public final class LazyLoadingManager extends RecyclerView.OnScrollListener {

    private final LazyLoadingListener listener;

    private static final int DIRECTION_DOWN = 1;

    public LazyLoadingManager(LazyLoadingListener listener) {
        this.listener = listener;
    }


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (!recyclerView.canScrollVertically(DIRECTION_DOWN)) {
            listener.onBottomReached();
        }
    }
}
