package com.example.luka.comicsapp.ui.comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.di.ObjectGraph;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ComicsActivity extends AppCompatActivity implements ComicContract.View {

    private ComicContract.Presenter presenter;
    private List<Comic> comicList;
    public static final String KEY_DETAILS = "DETAILS";

    @BindView(R.id.comic_list_view)
    RecyclerView recyclerView;

    @BindString(R.string.error_text)
    String errorText;

    private ComicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        comicList = new ArrayList<>();

        initPresenter();

        initUi();

        presenter.getComics();
    }

    private void initUi() {
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ComicAdapter(this);
        adapter.setClickListener(new ComicAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                final Comic comic = comicList.get(position);
                startComicDetailsActivity(comic);
            }
        });

        recyclerView.setAdapter(adapter);
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
        comicList.addAll(param.comicList);
    }


    @Override
    public void alertErrorMessage() {
        Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_SHORT).show();
    }

}
