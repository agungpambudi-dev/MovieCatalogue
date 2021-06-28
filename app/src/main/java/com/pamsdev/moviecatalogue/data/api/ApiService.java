package com.pamsdev.moviecatalogue.data.api;

import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.ResultMovie;
import com.pamsdev.moviecatalogue.data.source.remote.response.ResultTv;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/3/movie/popular")
    Call<ResultMovie> getMovie(
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("/3/movie/{movie_id}")
    Call<MovieResponse> getMovieById(
            @Path("movie_id") String id,
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("/3/tv/popular")
    Call<ResultTv> getTv(
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("/3/tv/{tv_id}")
    Call<TvResponse> getTvById(
            @Path("tv_id") String id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );


}
