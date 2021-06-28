package com.pamsdev.moviecatalogue.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "fav_tv")
public class TvEntity implements Parcelable {

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
    @ColumnInfo(name = "tv_favorite")
    private boolean tvFavorite;

    public TvEntity(@NonNull String id, String poster, String title, String release, String vote, String overview, boolean tvFavorite) {
        this.id = id;
        this.poster = poster;
        this.title = title;
        this.release = release;
        this.vote = vote;
        this.overview = overview;
        this.tvFavorite = tvFavorite;
    }

    protected TvEntity(Parcel in) {
        id = in.readString();
        poster = in.readString();
        title = in.readString();
        release = in.readString();
        vote = in.readString();
        overview = in.readString();
        tvFavorite = in.readByte() != 0;
    }

    public static final Creator<TvEntity> CREATOR = new Creator<TvEntity>() {
        @Override
        public TvEntity createFromParcel(Parcel in) {
            return new TvEntity(in);
        }

        @Override
        public TvEntity[] newArray(int size) {
            return new TvEntity[size];
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

    public boolean isTvFavorite() {
        return tvFavorite;
    }

    public void setTvFavorite(boolean tvFavorite) {
        this.tvFavorite = tvFavorite;
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
        dest.writeByte((byte) (tvFavorite ? 1 : 0));
    }
}
