package com.pamsdev.moviecatalogue.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.pamsdev.moviecatalogue.data.repository.DataSource;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.RemoteData;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;

import java.util.List;

public class FakeRepository implements DataSource {

    private final RemoteData remoteData;

    public FakeRepository(@NonNull RemoteData remoteData) {
        this.remoteData = remoteData;
    }

    @Override
    public LiveData<ApiResponse<List<MovieResponse>>> getAllMovie() {
        return remoteData.getAllMovie();
    }

    @Override
    public LiveData<ApiResponse<MovieResponse>> getMovieById(int movieId) {
        return remoteData.getMovieById(movieId);
    }

    @Override
    public LiveData<ApiResponse<List<TvResponse>>> getAllTv() {
        return remoteData.getAllTv();
    }

    @Override
    public LiveData<ApiResponse<TvResponse>> getTvById(int tvId) {
        return remoteData.getTvById(tvId);
    }
}
