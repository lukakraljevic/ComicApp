package com.example.luka.comicsapp.ui.comicdetails;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.base.BaseActivity;
import com.example.luka.comicsapp.base.IBasePresenter;
import com.example.luka.comicsapp.di.activity.ActivityComponent;
import com.example.luka.comicsapp.ui.comics.ComicsActivity;
import com.example.luka.comicsapp.ui.utils.ImageLoader;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;

public class ComicDetailsActivity extends BaseActivity implements ComicDetailsContract.View {

    @Inject
    ComicDetailsContract.Presenter presenter;

    @BindView(R.id.comic_details_name)
    TextView nameText;
    @BindView(R.id.comic_details_description)
    TextView descriptionText;
    @BindView(R.id.comic_details_image)
    ImageView headerImageView;
    @BindView(R.id.episode_number)
    TextView episodeNumber;
    @BindView(R.id.comic_details_date_last_updated)
    TextView dateLastUpdated;
    @BindView(R.id.comic_characters_list)
    RecyclerView recyclerView;
    @BindView(R.id.comic_details_characters_label)
    TextView charactersLabel;

    @BindString(R.string.error_text)
    String errorText;
    @BindString(R.string.episode_name)
    String episodeName;
    @BindString(R.string.episode_number)
    String episodeNumberText;
    @BindString(R.string.characters)
    String characters;

    private ComicDetailsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUi();
        displayData();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_comic_details;
    }

    public void initUi() {
        super.initUI();

        initAdapter();

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
    }

    private void displayData() {
        Comic comic = (Comic) getIntent().getSerializableExtra(ComicsActivity.KEY_DETAILS);

        nameText.setText(String.format(Locale.getDefault(), episodeName, comic.episodeName));
        SpannableString spannableDescription = new SpannableString(Html.fromHtml(comic.description));
        descriptionText.setText(spannableDescription);

        episodeNumber.setText(String.format(Locale.getDefault(), episodeNumberText, comic.episodeNumber));
        dateLastUpdated.setText(comic.dateLastUpdated);

        ImageLoader.loadImage(comic.thumbnailUrl, headerImageView, R.mipmap.ic_launcher);
        presenter.getComicDetails(comic.apiDetailUrl);
    }

    private void initAdapter() {
        adapter = new ComicDetailsAdapter();
        recyclerView.setAdapter(adapter);

        final LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }


    @Override
    public void alertErrorMessage() {
        Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComicDetails(ComicDetailsViewModel comicDetails) {
        if (comicDetails.characters.isEmpty()) {
            charactersLabel.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
        }

        adapter.setData(comicDetails.characters);
        ImageLoader.loadImage(comicDetails.imageUrl, headerImageView, R.mipmap.ic_launcher);
    }

    @Override
    public IBasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}