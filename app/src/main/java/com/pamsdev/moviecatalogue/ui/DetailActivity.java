package com.pamsdev.moviecatalogue.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pamsdev.moviecatalogue.R;
import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.remote.StatusResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.databinding.ActivityDetailBinding;
import com.pamsdev.moviecatalogue.viewmodel.DetailsViewModel;
import com.pamsdev.moviecatalogue.viewmodel.ViewModelFactory;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding activityDetailBinding;
    private DetailsViewModel viewModel;

    public static final String MOVIE_KEY = "movie";
    public static final String TV_KEY = "tv";

    private final String url = "https://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);

        ViewModelFactory factory = ViewModelFactory.getInstance(getApplication());
        viewModel = new ViewModelProvider(this, factory).get(DetailsViewModel.class);

        MovieEntity movie = getIntent().getParcelableExtra(MOVIE_KEY);
        TvEntity tv = getIntent().getParcelableExtra(TV_KEY);
        showLoading(true);

        if (movie!=null){
            viewModel.setMovieId(movie.getId());
            viewModel.getMovieById(movie.getId()).observe(this, movieResponse -> {
                if (movieResponse != null) {
                    activityDetailBinding.btAddFavorite.setOnClickListener(v -> {
                        Toast.makeText(this, "Oke "+movie.getId(), Toast.LENGTH_SHORT).show();
                        viewModel.setFavMovie();
                    });
                    switch (movieResponse.status) {
                        case LOADING:
                            showLoading(true);
                            break;
                        case SUCCESS:
                            showLoading(false);
                            getDataMovie(movieResponse.data);
                            break;
                        case ERROR:
                            showLoading(false);
                            Toast.makeText(this, movieResponse.message, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else if (tv!=null){
            viewModel.getTvById(tv.getId()).observe(this, tvResponses -> {
                if (tvResponses != null) {
                    switch (tvResponses.status) {
                        case LOADING:
                            showLoading(true);
                            break;
                        case SUCCESS:
                            showLoading(false);
                            getDataTv(tvResponses.data);
                            break;
                        case ERROR:
                            showLoading(false);
                            Toast.makeText(this, tvResponses.message, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void getDataMovie(MovieEntity movies){
        activityDetailBinding.tvTitle.setText(movies.getTitle());
        activityDetailBinding.tvRelease.setText(movies.getRelease());
        activityDetailBinding.tvRating.setText(movies.getVote());
        activityDetailBinding.tvDescription.setText(movies.getOverview());
        Glide.with(this)
                .load(url+movies.getPoster())
                .apply(new RequestOptions())
                .into(activityDetailBinding.ivPoster);

    }

    private void getDataTv(TvEntity tvs){
        activityDetailBinding.tvTitle.setText(tvs.getTitle());
        activityDetailBinding.tvRelease.setText(tvs.getRelease());
        activityDetailBinding.tvRating.setText(tvs.getVote());
        activityDetailBinding.tvDescription.setText(tvs.getOverview());
        Glide.with(this)
                .load(url+tvs.getPoster())
                .apply(new RequestOptions())
                .into(activityDetailBinding.ivPoster);
        activityDetailBinding.btAddFavorite.setOnClickListener(v -> {
            Toast.makeText(this, "Oke", Toast.LENGTH_SHORT).show();
            viewModel.setFavTv();
        });
    }

    private void showLoading(Boolean state) {
        if (state) {
            activityDetailBinding.progressbar.setVisibility(View.VISIBLE);
            activityDetailBinding.cvHeader.setVisibility(View.GONE);
            activityDetailBinding.cvDescription.setVisibility(View.GONE);
        } else {
            activityDetailBinding.progressbar.setVisibility(View.GONE);
            activityDetailBinding.cvHeader.setVisibility(View.VISIBLE);
            activityDetailBinding.cvDescription.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
