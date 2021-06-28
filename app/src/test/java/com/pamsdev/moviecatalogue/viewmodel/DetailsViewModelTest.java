package com.pamsdev.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.pamsdev.moviecatalogue.data.LiveDataTestUtil;
import com.pamsdev.moviecatalogue.data.repository.Repository;
import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.StatusResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DetailsViewModelTest {

    private DetailsViewModel viewModel;
    private final ArrayList<MovieResponse> movieResponse = DataDummy.setMovieDummy();
    private final int movieId = movieResponse.get(0).getId();
    private final ArrayList<TvResponse> tvResponse = DataDummy.setTvDummy();
    private final int tvId = tvResponse.get(0).getId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Repository repository;

    @Mock
    private Observer<ApiResponse<MovieResponse>> observerMovieById;

    @Mock
    private Observer<ApiResponse<TvResponse>> observerTvById;

    @Before
    public void setUp() {
        viewModel = new DetailsViewModel(repository);
    }

    @Test
    public void getListMovieById_Success() {
        MutableLiveData<ApiResponse<MovieResponse>> listMovie = new MutableLiveData<>();
        final MovieResponse movieResponse = DataDummy.setMovieDummy().get(movieId);
        listMovie.postValue(ApiResponse.success(movieResponse));
        Mockito.when(repository.getMovieById((movieId))).thenReturn(listMovie);
        ApiResponse<MovieResponse> movieResponses = LiveDataTestUtil.getValue(repository.getMovieById(movieId));
        verify(repository).getMovieById(eq(movieId));
        assertNotNull(movieResponses);
        assertEquals(movieResponse.getId(), movieResponses.data.getId());

        viewModel.getMovieById(movieId).observeForever(observerMovieById);
        verify(observerMovieById).onChanged(movieResponses);
    }

    @Test
    public void getListMovieById_Error() {
        MutableLiveData<ApiResponse<MovieResponse>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.error("error", null));
        Mockito.when(repository.getMovieById((movieId))).thenReturn(listMovie);
        ApiResponse<MovieResponse> movieResponses = LiveDataTestUtil.getValue(repository.getMovieById(movieId));
        verify(repository).getMovieById(eq(movieId));
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.ERROR, movieResponses.status);

        viewModel.getMovieById(movieId).observeForever(observerMovieById);
        verify(observerMovieById).onChanged(movieResponses);
    }

    @Test
    public void getListMovieById_Empty() {
        MutableLiveData<ApiResponse<MovieResponse>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.empty(null));
        Mockito.when(repository.getMovieById((movieId))).thenReturn(listMovie);
        ApiResponse<MovieResponse> movieResponses = LiveDataTestUtil.getValue(repository.getMovieById(movieId));
        verify(repository).getMovieById(eq(movieId));
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.EMPTY, movieResponses.status);

        viewModel.getMovieById(movieId).observeForever(observerMovieById);
        verify(observerMovieById).onChanged(movieResponses);
    }

    @Test
    public void getListTvById_Success() {
        MutableLiveData<ApiResponse<TvResponse>> listTv = new MutableLiveData<>();
        final TvResponse tvResponse = DataDummy.setTvDummy().get(tvId);
        listTv.postValue(ApiResponse.success(tvResponse));
        Mockito.when(repository.getTvById((tvId))).thenReturn(listTv);
        ApiResponse<TvResponse> tvResponses = LiveDataTestUtil.getValue(repository.getTvById(tvId));
        verify(repository).getTvById(eq(tvId));
        assertNotNull(tvResponses);
        assertEquals(tvResponse.getId(), tvResponses.data.getId());

        viewModel.getTvById(tvId).observeForever(observerTvById);
        verify(observerTvById).onChanged(tvResponses);
    }

    @Test
    public void getListTvById_Error() {
        MutableLiveData<ApiResponse<TvResponse>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.error("error", null));
        Mockito.when(repository.getTvById((tvId))).thenReturn(listTv);
        ApiResponse<TvResponse> tvResponses = LiveDataTestUtil.getValue(repository.getTvById(tvId));
        verify(repository).getTvById(eq(tvId));
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.ERROR, tvResponses.status);

        viewModel.getTvById(tvId).observeForever(observerTvById);
        verify(observerTvById).onChanged(tvResponses);
    }

    @Test
    public void getListTvById_Empty() {
        MutableLiveData<ApiResponse<TvResponse>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.empty(null));
        Mockito.when(repository.getTvById((tvId))).thenReturn(listTv);
        ApiResponse<TvResponse> tvResponses = LiveDataTestUtil.getValue(repository.getTvById(tvId));
        verify(repository).getTvById(eq(tvId));
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.EMPTY, tvResponses.status);

        viewModel.getTvById(tvId).observeForever(observerTvById);
        verify(observerTvById).onChanged(tvResponses);
    }

}