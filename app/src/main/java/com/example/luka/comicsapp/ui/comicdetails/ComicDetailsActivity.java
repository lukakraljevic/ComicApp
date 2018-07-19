package com.example.luka.comicsapp.ui.comicdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.di.ObjectGraph;
import com.example.luka.comicsapp.ui.comics.ComicsActivity;
import com.example.luka.comicsapp.ui.utils.ImageLoader;

import java.util.Locale;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailsActivity extends AppCompatActivity implements ComicDetailsContract.View {

    private ComicDetailsContract.Presenter presenter;

    @BindView(R.id.comic_details_name)
    TextView nameText;
    @BindView(R.id.comic_details_desc)
    TextView descriptionText;
    @BindView(R.id.comic_details_image)
    ImageView headerImageView;

    @BindString(R.string.error_text)
    String errorText;
    @BindString(R.string.episode_name)
    String episodeName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);
        initPresenter();
        initUi();

        getExtras();
    }

    private void initUi() {
        ButterKnife.bind(this);
    }

    private void getExtras() {
        String apiDetailsUrl = getIntent().getStringExtra(ComicsActivity.KEY_DETAILS);
        presenter.getComicDetails(apiDetailsUrl);
    }

    private void initPresenter() {
        presenter = ObjectGraph.getInstance().getComicDetailsPresenter(this);
    }

    @Override
    public void alertErrorMessage() {
        Toast.makeText(getApplicationContext(), errorText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComicDetails(ComicDetailsViewModel comicDetails) {
        ImageLoader.loadImage(comicDetails.imageUrl, headerImageView, R.mipmap.ic_launcher);

        nameText.setText(String.format(Locale.getDefault(), episodeName, comicDetails.name));

        SpannableString spannableString = new SpannableString(Html.fromHtml(comicDetails.description));
        descriptionText.setText(spannableString);
    }
}
