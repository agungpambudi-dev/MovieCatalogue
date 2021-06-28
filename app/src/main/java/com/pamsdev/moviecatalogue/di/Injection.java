package com.pamsdev.moviecatalogue.di;

import android.content.Context;

import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.local.LocalDataSource;
import com.pamsdev.moviecatalogue.data.source.local.room.FavoriteDatabase;
import com.pamsdev.moviecatalogue.data.source.remote.RemoteData;
import com.pamsdev.moviecatalogue.utils.AppExecutors;

public class Injection {
    public static Repository provideRepository(Context context){

        //RemoteData remoteData = RemoteData.getInstance();
        //return Repository.getInstance(remoteData);

        FavoriteDatabase database = FavoriteDatabase.getInstance(context);

        RemoteData remoteDataSource = RemoteData.getInstance();
        LocalDataSource localDataSource = LocalDataSource.getInstance(database.favoriteDao());
        AppExecutors appExecutors = new AppExecutors();

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors);

    }
}
