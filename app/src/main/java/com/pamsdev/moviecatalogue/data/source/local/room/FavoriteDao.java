package com.pamsdev.moviecatalogue.data.source.local.room;

import androidx.constraintlayout.utils.widget.MockView;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;

import java.util.List;

@Dao
public interface FavoriteDao {

    //Movie
    @Query("SELECT * FROM fav_movie")
    LiveData<List<MovieEntity>> getAllMovie();

    @Query("SELECT * FROM fav_movie where movie_favorite = 1")
    LiveData<List<MovieEntity>> getFavMovie();

    @Query("SELECT * FROM fav_movie where id =:id")
    LiveData<MovieEntity> getMovieById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(List<MovieEntity> movieEntities);

    @Delete
    void deleteMovie(List<MovieEntity> movieEntities);

    @Update
    void updateMovie(MovieEntity movieEntity);

    @Query("UPDATE fav_movie SET movie_favorite = :state WHERE id = :id")
    void updateFavMovie(boolean state, String id);

    //Tv
    @Query("SELECT * FROM fav_tv")
    LiveData<List<TvEntity>> getAllTv();

    @Query("SELECT * FROM fav_tv where tv_favorite = 1")
    LiveData<List<TvEntity>> getFavTv();

    @Query("SELECT * FROM fav_tv where id =:id")
    LiveData<TvEntity> getTvById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTv(List<TvEntity> tvEntities);

    @Delete
    void deleteTv(List<TvEntity> tvEntities);

    @Update
    void updateTv(TvEntity tvEntity);


}
