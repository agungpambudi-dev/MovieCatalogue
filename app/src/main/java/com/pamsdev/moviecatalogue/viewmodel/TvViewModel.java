package com.pamsdev.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.vo.Resource;

import java.util.List;

public class TvViewModel extends ViewModel {

    Repository repository;

    public TvViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<List<TvEntity>>> getListTv() {
        return repository.getAllTv();
    }
}
