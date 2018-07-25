package com.example.luka.comicsapp.ui.comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.di.component.ComponentFactory;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsActivity;
import com.example.luka.comicsapp.ui.listener.ComicClickListener;
import com.example.luka.comicsapp.ui.listener.LazyLoadingListener;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicsActivity extends AppCompatActivity implements ComicContract.View, ComicClickListener, LazyLoadingListener {

    @Inject
    ComicContract.Presenter presenter;
    public static final String KEY_DETAILS = "DETAILS";

    @BindView(R.id.comic_list)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeContainer;
    @BindString(R.string.error_text)
    String errorText;

    private final ComicAdapter adapter = new ComicAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);
        initPresenter();

        initUi();

        getComics(true);
    }

    private void initUi() {
        ButterKnife.bind(this);

        swipeContainer.setOnRefreshListener(() -> {
            getComics(true);
        });

        LazyLoadingManager manager = new LazyLoadingManager(this);
        recyclerView.addOnScrollListener(manager);
        initAdapter();
    }


    private void initAdapter() {
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onComicClick(Comic comic) {
        startComicDetailsActivity(comic);
    }

    private void startComicDetailsActivity(Comic comic) {
        Intent comicDet = new Intent(ComicsActivity.this, ComicDetailsActivity.class);
        comicDet.putExtra(KEY_DETAILS, comic);
        startActivity(comicDet);
    }

    private void initPresenter() {
        ComponentFactory.createActivityComponent(this).inject(this);
        presenter.setView(this);
    }

    @Override
    public void renderComics(ComicViewModel param, int page) {
        adapter.addData(param.comicList, page);
        swipeContainer.setRefreshing(false);
    }

    @Override
    public void alertErrorMessage() {
        Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_SHORT).show();
    }

    private void getComics(boolean isRefreshing) {
        swipeContainer.setRefreshing(true);
        presenter.getComics(isRefreshing);
    }

    @Override
    public void onBottomReached() {
        getComics(false);
    }
}