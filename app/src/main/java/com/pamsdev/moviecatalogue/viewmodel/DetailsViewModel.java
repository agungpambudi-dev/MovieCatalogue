package com.pamsdev.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.vo.Resource;

public class DetailsViewModel extends ViewModel {

    Repository repository;
    private MutableLiveData<String> movieId = new MutableLiveData<>();

    public DetailsViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<MovieEntity>> getMovieById(String movieId) {
        Log.d("TAG", "DetailsViewModel1: "+ repository);
        return repository.getMovieById(movieId);
    }

    public LiveData<Resource<TvEntity>> getTvById(String tvId) {
        return repository.getTvById(tvId);
    }

    public LiveData<Resource<MovieEntity>> movieEntity = Transformations.switchMap(movieId,
            mMovieId -> repository.getMovieById(mMovieId));

    public LiveData<Resource<TvEntity>> tvEntity = Transformations.switchMap(movieId,
            mMovieId -> repository.getTvById(mMovieId));


    public String getMovieId() {
        return movieId.getValue();
    }

    public void setMovieId(String movieId) {
        this.movieId.setValue(movieId);
    }

    public void setFavMovie() {
        Log.d("TAG", "DetailsViewModel2: "+ repository);
        Resource<MovieEntity> movieEntityResource = movieEntity.getValue();
        if (movieEntityResource != null) {
            MovieEntity movieEntity = movieEntityResource.data;
            if (movieEntity != null) {
                final boolean newState = !movieEntity.isMovieFavorite();
                Log.d("TAG", "setFavMovie: "+newState);
                repository.setFavMovie(movieEntity, newState);
            }
        }
    }

    public void setFavTv() {
        /*Resource<TvEntity> moduleResource = tvEntity.getValue();
        if (moduleResource != null) {
            TvEntity courseWithModule = moduleResource.data;
            if (courseWithModule != null) {
                TvEntity courseEntity = tvEntity.getValue().data;
                repository.setFavTv(courseEntity);
            }
        }*/

        /*if (tvEntity.getValue() != null) {
            TvEntity entity = tvEntity.getValue().data;
            repository.setFavTv(entity);
        }*/
    }


}
