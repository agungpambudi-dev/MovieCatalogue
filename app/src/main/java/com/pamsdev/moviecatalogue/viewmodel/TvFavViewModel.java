package com.pamsdev.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.vo.Resource;

import java.util.List;

public class TvFavViewModel extends ViewModel {

    private Repository repository;
    MutableLiveData<String> tvId = new MutableLiveData<>();

    public TvFavViewModel(Repository mRepository) {
        this.repository = mRepository;
    }

    public LiveData<List<TvEntity>> getFavTv = Transformations.switchMap(tvId,
            mMovieId -> repository.getFavTv());

    public String getTvId() {
        return tvId.getValue();
    }

}
