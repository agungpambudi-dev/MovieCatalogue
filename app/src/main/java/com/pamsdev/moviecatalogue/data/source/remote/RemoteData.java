package com.pamsdev.moviecatalogue.data.source.remote;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pamsdev.moviecatalogue.BuildConfig;
import com.pamsdev.moviecatalogue.data.api.ApiConfig;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.ResultMovie;
import com.pamsdev.moviecatalogue.data.source.remote.response.ResultTv;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.utils.EspressoIdlingResource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  RemoteData {

    public static RemoteData INSTANCE;

    public RemoteData() {
    }

    public static RemoteData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteData();
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getAllMovie() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovie = new MutableLiveData<>();
        Call<ResultMovie> call = ApiConfig.getApiService().getMovie(BuildConfig.TMDB_API_KEY, "en-US");
        call.enqueue(new Callback<ResultMovie>() {
            @Override
            public void onResponse(@NotNull Call<ResultMovie> call, @NotNull Response<ResultMovie> response) {
                if (response.isSuccessful()) {
                    if (response.body().getMovieResponse() != null) {
                        listMovie.postValue(ApiResponse.success(response.body().getMovieResponse()));
                    } else {
                        listMovie.postValue(ApiResponse.empty(null));
                    }
                    EspressoIdlingResource.decrement();
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResultMovie> call, @NotNull Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
                listMovie.postValue(ApiResponse.error(t.getMessage(), null));
                EspressoIdlingResource.decrement();
            }
        });

        return listMovie;
    }

    public LiveData<ApiResponse<MovieResponse>> getMovieById(String id) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<MovieResponse>> movieResponses = new MutableLiveData<>();
        Call<MovieResponse> call = ApiConfig.getApiService().getMovieById(id, BuildConfig.TMDB_API_KEY, "en-US");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        movieResponses.postValue(ApiResponse.success(response.body()));
                    } else {
                        movieResponses.postValue(ApiResponse.empty(null));
                    }
                    EspressoIdlingResource.decrement();
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
                movieResponses.postValue(ApiResponse.error(t.getMessage(), null));
                EspressoIdlingResource.decrement();
            }
        });

        return movieResponses;
    }

    public LiveData<ApiResponse<List<TvResponse>>> getAllTv() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TvResponse>>> listTv = new MutableLiveData<>();
        Call<ResultTv> call = ApiConfig.getApiService().getTv(BuildConfig.TMDB_API_KEY, "en-US");
        call.enqueue(new Callback<ResultTv>() {
            @Override
            public void onResponse(@NotNull Call<ResultTv> call, @NotNull Response<ResultTv> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listTv.postValue(ApiResponse.success(response.body().getTvResponse()));
                    } else {
                        listTv.postValue(ApiResponse.empty(null));
                    }
                    EspressoIdlingResource.decrement();
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResultTv> call, @NotNull Throwable t) {
                listTv.postValue(ApiResponse.error(t.getMessage(), null));
                EspressoIdlingResource.decrement();
            }
        });

        return listTv;
    }

    public LiveData<ApiResponse<TvResponse>> getTvById(String id) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<TvResponse>> tvResponses = new MutableLiveData<>();
        Call<TvResponse> call = ApiConfig.getApiService().getTvById(id, BuildConfig.TMDB_API_KEY, "en-US");
        call.enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvResponse> call, @NotNull Response<TvResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        tvResponses.postValue(ApiResponse.success(response.body()));
                    } else {
                        tvResponses.postValue(ApiResponse.empty(null));
                    }
                    EspressoIdlingResource.decrement();
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvResponse> call, @NotNull Throwable t) {
                tvResponses.postValue(ApiResponse.error(t.getMessage(), null));
                EspressoIdlingResource.decrement();
            }
        });

        return tvResponses;
    }

}