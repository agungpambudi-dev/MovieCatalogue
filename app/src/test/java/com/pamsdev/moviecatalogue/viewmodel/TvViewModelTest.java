package com.pamsdev.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.pamsdev.moviecatalogue.data.LiveDataTestUtil;
import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.StatusResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TvViewModelTest {

    private TvViewModel viewModel;
    private final ArrayList<TvResponse> tvResponse = DataDummy.setTvDummy();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Repository repository;

    @Mock
    private Observer<ApiResponse<List<TvResponse>>> observer;

    @Before
    public void setUp() {
        viewModel = new TvViewModel(repository);
    }

    @Test
    public void getListTv_Success() {
        MutableLiveData<ApiResponse<List<TvResponse>>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.success(tvResponse));
        Mockito.when(repository.getAllTv()).thenReturn(listTv);
        ApiResponse<List<TvResponse>> tvResponses = LiveDataTestUtil.getValue(repository.getAllTv());
        verify(repository).getAllTv();
        assertNotNull(tvResponses);
        assertEquals(tvResponse.size(), tvResponses.data.size());

        viewModel.getListTv().observeForever(observer);
        verify(observer).onChanged(tvResponses);
    }

    @Test
    public void getListMovie_Error() {
        MutableLiveData<ApiResponse<List<TvResponse>>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.error("error", null));
        Mockito.when(repository.getAllTv()).thenReturn(listTv);
        ApiResponse<List<TvResponse>> tvResponses = LiveDataTestUtil.getValue(repository.getAllTv());
        verify(repository).getAllTv();
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.ERROR, tvResponses.status);

        viewModel.getListTv().observeForever(observer);
        verify(observer).onChanged(tvResponses);
    }

    @Test
    public void getListMovie_Empty() {
        MutableLiveData<ApiResponse<List<TvResponse>>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.empty(null));
        Mockito.when(repository.getAllTv()).thenReturn(listTv);
        ApiResponse<List<TvResponse>> tvResponses = LiveDataTestUtil.getValue(repository.getAllTv());
        verify(repository).getAllTv();
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.EMPTY, tvResponses.status);

        viewModel.getListTv().observeForever(observer);
        verify(observer).onChanged(tvResponses);
    }

}