package com.pamsdev.moviecatalogue.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieResponse implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("title")
    private String title;
    @SerializedName("release_date")
    private String release;
    @SerializedName("vote_average")
    private String vote;
    @SerializedName("overview")
    private String overview;

    public MovieResponse(String id, String poster, String title, String release, String vote, String overview) {
        this.id = id;
        this.poster = poster;
        this.title = title;
        this.release = release;
        this.vote = vote;
        this.overview = overview;
    }

    protected MovieResponse(Parcel in) {
        id = in.readString();
        poster = in.readString();
        title = in.readString();
        release = in.readString();
        vote = in.readString();
        overview = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(poster);
        dest.writeString(title);
        dest.writeString(release);
        dest.writeString(vote);
        dest.writeString(overview);
    }
}
