package com.example.luka.comicsapp.ui.comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.di.ObjectGraph;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ComicsActivity extends AppCompatActivity implements ComicContract.View, ComicAdapter.ItemClickListener {

    private ComicContract.Presenter presenter;
    public static final String KEY_DETAILS = "DETAILS";
    @BindView(R.id.comic_list_view)
    RecyclerView recyclerView;
    @BindView(R.id.my_toolbar)
    Toolbar toolbar;
    @BindString(R.string.error_text)
    String errorText;
    private ComicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        initPresenter();
        initUi();

        presenter.getComics();
    }

    private void initUi() {
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initAdapter();
        setSupportActionBar(toolbar);
    }

    private void initAdapter() {
        adapter = new ComicAdapter(this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        final Comic comic = adapter.get(position);
        startComicDetailsActivity(comic);
    }

    private void startComicDetailsActivity(Comic comic) {
        Intent comicDet = new Intent(ComicsActivity.this, ComicDetailsActivity.class);
        comicDet.putExtra(KEY_DETAILS, comic.apiDetailUrl);
        startActivity(comicDet);
    }

    private void initPresenter() {
        presenter = ObjectGraph.getInstance().getComicPresenter(this);
    }

    @Override
    public void renderComics(ComicViewModel param) {
        adapter.setData(param.comicList);
    }


    @Override
    public void alertErrorMessage() {
        Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_SHORT).show();
    }
}
