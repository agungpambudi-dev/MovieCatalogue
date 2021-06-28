package com.pamsdev.moviecatalogue.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "fav_movie")
public class MovieEntity implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "poster")
    private String poster;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "release")
    private String release;
    @ColumnInfo(name = "vote")
    private String vote;
    @ColumnInfo(name = "overview")
    private String overview;
    @ColumnInfo(name = "movie_favorite")
    private boolean movieFavorite;

    public MovieEntity(@NonNull String id, String poster, String title, String release, String vote, String overview, boolean movieFavorite) {
        this.id = id;
        this.poster = poster;
        this.title = title;
        this.release = release;
        this.vote = vote;
        this.overview = overview;
        this.movieFavorite = movieFavorite;
    }

    protected MovieEntity(Parcel in) {
        id = in.readString();
        poster = in.readString();
        title = in.readString();
        release = in.readString();
        vote = in.readString();
        overview = in.readString();
        movieFavorite = in.readByte() != 0;
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel in) {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

    public boolean isMovieFavorite() {
        return movieFavorite;
    }

    public void setMovieFavorite(boolean movieFavorite) {
        this.movieFavorite = movieFavorite;
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
        dest.writeByte((byte) (movieFavorite ? 1 : 0));
    }
}
