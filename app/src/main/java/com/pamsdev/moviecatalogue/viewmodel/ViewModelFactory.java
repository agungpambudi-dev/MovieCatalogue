package com.pamsdev.moviecatalogue.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.di.Injection;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;
    private final Repository repository;

    private ViewModelFactory(Repository mRepository){
        repository = mRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
            }
        }
        return INSTANCE;
    }
    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass){

        if (modelClass.isAssignableFrom(MovieViewModel.class)){
            return (T) new MovieViewModel(repository);
        } else if (modelClass.isAssignableFrom(TvViewModel.class)){
            return (T) new TvViewModel(repository);
        } else if (modelClass.isAssignableFrom(DetailsViewModel.class)){
            return (T) new DetailsViewModel(repository);
        } else if (modelClass.isAssignableFrom(MovieFavViewModel.class)){
            return (T) new MovieFavViewModel(repository);
        } else if (modelClass.isAssignableFrom(TvFavViewModel.class)){
            return (T) new TvFavViewModel(repository);
        }

        throw new IllegalArgumentException("Unknown " + modelClass.getName());
    }

}
