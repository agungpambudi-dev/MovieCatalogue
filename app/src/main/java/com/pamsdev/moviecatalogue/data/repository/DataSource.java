package com.pamsdev.moviecatalogue.data.repository;

import androidx.lifecycle.LiveData;

import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.vo.Resource;

import java.util.List;

public interface DataSource {

    LiveData<Resource<List<MovieEntity>>> getAllMovie();

    LiveData<Resource<MovieEntity>> getMovieById(String movieId);

    LiveData<Resource<List<TvEntity>>> getAllTv();

    LiveData<Resource<TvEntity>> getTvById (String tvId);

    LiveData<List<MovieEntity>> getFavMovie();

    LiveData<List<TvEntity>> getFavTv();

    void setFavMovie(MovieEntity movie, boolean state);

    void setFavTv(TvEntity tv, boolean state);

}
