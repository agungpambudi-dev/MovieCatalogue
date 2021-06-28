package com.pamsdev.moviecatalogue.data.source.local.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;

@Database(entities = {MovieEntity.class, TvEntity.class}, version = 1, exportSchema = false)
public abstract class FavoriteDatabase extends RoomDatabase {

    public abstract FavoriteDao favoriteDao();

    private static volatile FavoriteDatabase INSTANCE;

    public static FavoriteDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (FavoriteDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        FavoriteDatabase.class, "Favorite.db")
                        .build();
            }
        }
        return INSTANCE;
    }

}
