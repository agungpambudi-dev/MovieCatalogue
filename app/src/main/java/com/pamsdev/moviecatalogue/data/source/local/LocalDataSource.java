package com.pamsdev.moviecatalogue.data.source.local;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.local.room.FavoriteDao;

import java.util.List;

public class LocalDataSource {

    private static LocalDataSource INSTANCE;
    private final FavoriteDao favoriteDao;

    public LocalDataSource(FavoriteDao mFavoriteDao) {
        this.favoriteDao = mFavoriteDao;
    }

    public static LocalDataSource getInstance(FavoriteDao favoriteDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(favoriteDao);
        }
        return INSTANCE;
    }

    //Movie
    public LiveData<List<MovieEntity>> getAllMovie() {
        return favoriteDao.getAllMovie();
    }

    public LiveData<List<MovieEntity>> getFavMovie() {
        return favoriteDao.getFavMovie();
    }

    public LiveData<MovieEntity> getMovieById(String movieId) {
        return favoriteDao.getMovieById(movieId);
    }


    public void insertMovie(List<MovieEntity> movieEntities) {
        favoriteDao.insertMovie(movieEntities);
    }

    public void setFavMovie(MovieEntity movieEntity, boolean state) {
        movieEntity.setMovieFavorite(state);
        Log.d("TAG", "setFavMovie: " + state);
        favoriteDao.updateMovie(movieEntity);
    }


    //Tv
    public LiveData<List<TvEntity>> getAllTv() {
        return favoriteDao.getAllTv();
    }

    public LiveData<List<TvEntity>> getFavTv() {
        return favoriteDao.getFavTv();
    }

    public LiveData<TvEntity> getTvById(String tvId) {
        return favoriteDao.getTvById(tvId);
    }

    public void insertTv(List<TvEntity> TvEntity) {
        favoriteDao.insertTv(TvEntity);
    }

    public void setFavTv(TvEntity tvEntity, boolean state) {
        tvEntity.setTvFavorite(state);
        Log.d("TAG", "setFavTv: " + state);
        favoriteDao.updateTv(tvEntity);
    }

}
