package com.example.luka.comicsapp.ui.comics;

import android.support.v7.widget.RecyclerView;

import com.example.luka.comicsapp.ui.listener.LazyLoadingListener;

import java.util.ArrayList;
import java.util.List;

public final class LazyLoadingManager extends RecyclerView.OnScrollListener {

    private final List<LazyLoadingListener> listeners = new ArrayList<>();

    private static final int DIRECTION_DOWN = 1;

    public void addListener(LazyLoadingListener listener) {
        listeners.add(listener);
    }


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (!recyclerView.canScrollVertically(DIRECTION_DOWN)) {
            for (LazyLoadingListener listener : listeners) {
                listener.onBottomReached();
            }
        }
    }
}
