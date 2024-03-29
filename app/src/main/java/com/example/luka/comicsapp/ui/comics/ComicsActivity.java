package com.example.luka.comicsapp.ui.comics;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.base.BaseActivity;
import com.example.luka.comicsapp.base.ViewPresenter;
import com.example.luka.comicsapp.di.activity.ActivityComponent;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsActivity;
import com.example.luka.comicsapp.ui.listener.ComicClickListener;
import com.example.luka.comicsapp.ui.listener.LazyLoadingListener;
import com.jakewharton.rxbinding2.widget.RxSearchView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;

public class ComicsActivity extends BaseActivity implements ComicContract.View, ComicClickListener, LazyLoadingListener {

    @Inject
    ComicContract.Presenter presenter;
    public static final String KEY_DETAILS = "DETAILS";

    @BindView(R.id.comic_list)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeContainer;
    SearchView searchView;
    @BindString(R.string.error_text)
    String errorText;

    private final ComicAdapter adapter = new ComicAdapter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUi();
        getComics(true);
        addDisposable(presenter.viewState().subscribe(this::renderComics, this::alertErrorMessage));
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);

        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager != null ? searchManager.getSearchableInfo(getComponentName()) : null);

        addDisposable(RxSearchView.queryTextChanges(searchView)
                .debounce(200, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .observeOn(mainThreadScheduler)
                .subscribe(query -> presenter.searchComics(query), this::alertErrorMessage));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_comics;
    }

    public void initUi() {
        super.initUI();

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

    private void renderComics(ComicViewState comicViewState) {
        adapter.addData(comicViewState.comicViewModel.comicList, comicViewState.comicViewModel.page);
        swipeContainer.setRefreshing(false);
    }

    private void alertErrorMessage(Throwable t) {
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

    @Override
    public ViewPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}