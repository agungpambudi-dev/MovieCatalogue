package com.pamsdev.moviecatalogue.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.pamsdev.moviecatalogue.data.source.NetworkBoundResource;
import com.pamsdev.moviecatalogue.data.source.local.LocalDataSource;
import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.RemoteData;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.utils.AppExecutors;
import com.pamsdev.moviecatalogue.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class Repository implements DataSource {

    private volatile static Repository INSTANCE = null;
    private final RemoteData remoteData;

    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    public Repository(RemoteData remoteData, LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteData = remoteData;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static Repository getInstance(RemoteData remoteData1, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                INSTANCE = new Repository(remoteData1, localDataSource, appExecutors);
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> getAllMovie() {
        return new NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            @Override
            public LiveData<List<MovieEntity>> loadFromDB() {
                return localDataSource.getAllMovie();
            }

            @Override
            public Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            public LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteData.getAllMovie();
            }

            @Override
            public void saveCallResult(List<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> movieList = new ArrayList<>();
                for (MovieResponse response : movieResponses) {
                    MovieEntity movieEntity = new MovieEntity(response.getId(),
                            response.getPoster(),
                            response.getTitle(),
                            response.getRelease(),
                            response.getVote(),
                            response.getOverview(),
                            false);

                    movieList.add(movieEntity);
                }

                localDataSource.insertMovie(movieList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MovieEntity>> getMovieById(String movieId) {
        return new NetworkBoundResource<MovieEntity, MovieResponse>(appExecutors) {

            @Override
            protected LiveData<MovieEntity> loadFromDB() {
                return localDataSource.getMovieById(movieId);
            }

            @Override
            protected Boolean shouldFetch(MovieEntity data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<MovieResponse>> createCall() {
                return remoteData.getMovieById(movieId);
            }

            @Override
            protected void saveCallResult(MovieResponse data) {
                //localDataSource.(data.getId(), movieId);
            }

        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvEntity>>> getAllTv() {
        return new NetworkBoundResource<List<TvEntity>, List<TvResponse>>(appExecutors) {
            @Override
            public LiveData<List<TvEntity>> loadFromDB() {
                return localDataSource.getAllTv();
            }

            @Override
            public Boolean shouldFetch(List<TvEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            public LiveData<ApiResponse<List<TvResponse>>> createCall() {
                return remoteData.getAllTv();
            }

            @Override
            public void saveCallResult(List<TvResponse> tvResponses) {
                ArrayList<TvEntity> tvList = new ArrayList<>();
                for (TvResponse response : tvResponses) {
                    TvEntity tvEntity = new TvEntity(response.getId(),
                            response.getPoster(),
                            response.getTitle(),
                            response.getRelease(),
                            response.getVote(),
                            response.getOverview(),
                            false);

                    tvList.add(tvEntity);
                }

                localDataSource.insertTv(tvList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvEntity>> getTvById(String tvId) {
        return new NetworkBoundResource<TvEntity, TvResponse>(appExecutors) {

            @Override
            protected LiveData<TvEntity> loadFromDB() {
                return localDataSource.getTvById(tvId);
            }

            @Override
            protected Boolean shouldFetch(TvEntity data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<TvResponse>> createCall() {
                return remoteData.getTvById(tvId);
            }

            @Override
            protected void saveCallResult(TvResponse data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<List<MovieEntity>> getFavMovie() {
        return localDataSource.getAllMovie();
    }

    @Override
    public LiveData<List<TvEntity>> getFavTv() {
        return localDataSource.getAllTv();
    }

    @Override
    public void setFavMovie(MovieEntity movie, boolean state) {
        Log.d("TAG", "setFavMovie: "+state);
        appExecutors.diskIO().execute(() -> localDataSource.setFavMovie(movie, state));
    }

    @Override
    public void setFavTv(TvEntity tv, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFavTv(tv, state));
    }

}
