package com.pamsdev.moviecatalogue.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultTv {

    @SerializedName("page")
    private String page;
    @SerializedName("results")
    private final List<TvResponse> tvResponse;

    public ResultTv(String page, List<TvResponse> tvResponse) {
        this.page = page;
        this.tvResponse = tvResponse;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<TvResponse> getTvResponse() {
        return tvResponse;
    }
}
