package com.pamsdev.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.vo.Resource;

import java.util.List;

public class MovieFavViewModel extends ViewModel {

    private Repository repository;
    MutableLiveData<String> movieId = new MutableLiveData<>();

    public MovieFavViewModel(Repository mRepository) {
        this.repository = mRepository;
    }

    public LiveData<List<MovieEntity>> getFavMovie = Transformations.switchMap(movieId,
            mMovieId -> repository.getFavMovie());

    public String getMovieId() {
        return movieId.getValue();
    }

}
