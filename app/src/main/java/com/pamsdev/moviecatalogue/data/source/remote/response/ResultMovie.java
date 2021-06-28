package com.pamsdev.moviecatalogue.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultMovie {

    @SerializedName("page")
    private String page;
    @SerializedName("results")
    private final List<MovieResponse> movieResponse;

    public ResultMovie(String page, List<MovieResponse> movieResponse) {
        this.page = page;
        this.movieResponse = movieResponse;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<MovieResponse> getMovieResponse() {
        return movieResponse;
    }
}
