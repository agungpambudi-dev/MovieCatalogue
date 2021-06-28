package com.pamsdev.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.pamsdev.moviecatalogue.data.LiveDataTestUtil;
import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.StatusResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {

    private MovieViewModel viewModel;
    private final ArrayList<MovieResponse> movieResponse = DataDummy.setMovieDummy();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Repository repository;

    @Mock
    private Observer<ApiResponse<List<MovieResponse>>> observer;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(repository);
    }

    @Test
    public void getListMovie_Success() {
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.success(movieResponse));
        Mockito.when(repository.getAllMovie()).thenReturn(listMovie);
        ApiResponse<List<MovieResponse>> movieResponses = LiveDataTestUtil.getValue(repository.getAllMovie());
        verify(repository).getAllMovie();
        assertNotNull(movieResponses);
        assertEquals(movieResponse.size(), movieResponses.data.size());

        viewModel.getListMovie().observeForever(observer);
        verify(observer).onChanged(movieResponses);
    }

    @Test
    public void getListMovie_Error() {
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.error("error", null));
        Mockito.when(repository.getAllMovie()).thenReturn(listMovie);
        ApiResponse<List<MovieResponse>> movieResponses = LiveDataTestUtil.getValue(repository.getAllMovie());
        verify(repository).getAllMovie();
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.ERROR, movieResponses.status);

        viewModel.getListMovie().observeForever(observer);
        verify(observer).onChanged(movieResponses);
    }

    @Test
    public void getListMovie_Empty() {
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.empty(null));
        Mockito.when(repository.getAllMovie()).thenReturn(listMovie);
        ApiResponse<List<MovieResponse>> movieResponses = LiveDataTestUtil.getValue(repository.getAllMovie());
        verify(repository).getAllMovie();
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.EMPTY, movieResponses.status);

        viewModel.getListMovie().observeForever(observer);
        verify(observer).onChanged(movieResponses);
    }

}