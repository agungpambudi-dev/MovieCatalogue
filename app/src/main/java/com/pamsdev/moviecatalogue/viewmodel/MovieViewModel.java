package com.pamsdev.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {

    Repository repository;

    public MovieViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<List<MovieEntity>>> getListMovie() {
        return repository.getAllMovie();
    }

}
