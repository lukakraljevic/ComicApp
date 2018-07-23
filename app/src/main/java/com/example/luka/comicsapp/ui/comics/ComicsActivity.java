package com.example.luka.comicsapp.ui.comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.di.ObjectGraph;
import com.example.luka.comicsapp.ui.ItemClickListener;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ComicsActivity extends AppCompatActivity implements ComicContract.View, ItemClickListener {

    private ComicContract.Presenter presenter;
    public static final String KEY_DETAILS = "DETAILS";
    @BindView(R.id.comic_list)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeContainer;
    @BindString(R.string.error_text)
    String errorText;
    private ComicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        initPresenter();
        initUi();

        swipeContainer.setRefreshing(true);
        presenter.getComics();
    }

    private void initUi() {
        ButterKnife.bind(this);

        swipeContainer.setOnRefreshListener(() -> {
            presenter.performRefresh();
            presenter.getComics();
        });

        recyclerView.addOnScrollListener(new LazyLoadingManager(presenter, swipeContainer));

        initAdapter();
    }


    private void initAdapter() {
        adapter = new ComicAdapter(this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(View view, int position) {
        final Comic comic = adapter.get(position);
        startComicDetailsActivity(comic);
    }

    private void startComicDetailsActivity(Comic comic) {
        Intent comicDet = new Intent(ComicsActivity.this, ComicDetailsActivity.class);
        comicDet.putExtra(KEY_DETAILS, comic);
        startActivity(comicDet);
    }

    private void initPresenter() {
        presenter = ObjectGraph.getInstance().getComicPresenter(this);
    }

    @Override
    public void renderComics(ComicViewModel param) {
        adapter.addData(param.comicList);
        swipeContainer.setRefreshing(false);
        presenter.setLoading(false);
    }

    @Override
    public void renderComicsRefresh(ComicViewModel param) {
        adapter.setData(param.comicList);
        swipeContainer.setRefreshing(false);
    }

    @Override
    public void alertErrorMessage() {
        Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_SHORT).show();
    }
}
