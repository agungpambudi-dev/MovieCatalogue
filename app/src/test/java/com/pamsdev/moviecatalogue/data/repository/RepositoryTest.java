package com.pamsdev.moviecatalogue.data.repository;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.pamsdev.moviecatalogue.data.source.remote.ApiResponse;
import com.pamsdev.moviecatalogue.data.source.remote.RemoteData;
import com.pamsdev.moviecatalogue.data.source.remote.StatusResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;
import com.pamsdev.moviecatalogue.utils.DataDummy;
import com.pamsdev.moviecatalogue.data.FakeRepository;
import com.pamsdev.moviecatalogue.data.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private final RemoteData remote = Mockito.mock(RemoteData.class);
    private final FakeRepository fakeRepository = new FakeRepository(remote);

    private final ArrayList<MovieResponse> movieResponse = DataDummy.setMovieDummy();
    private final int movieId = movieResponse.get(0).getId();

    private final ArrayList<TvResponse> tvResponse = DataDummy.setTvDummy();
    private final int tvId = tvResponse.get(0).getId();

    @Test
    public void getListMovie_Success() {
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.success(movieResponse));
        Mockito.when(remote.getAllMovie()).thenReturn(listMovie);
        ApiResponse<List<MovieResponse>> movieResponses = LiveDataTestUtil.getValue(fakeRepository.getAllMovie());
        verify(remote).getAllMovie();
        assertNotNull(movieResponses);
        assertEquals(movieResponse.size(), movieResponses.data.size());
    }

    @Test
    public void getListMovie_Error() {
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.error("error", null));
        Mockito.when(remote.getAllMovie()).thenReturn(listMovie);
        ApiResponse<List<MovieResponse>> movieResponses = LiveDataTestUtil.getValue(fakeRepository.getAllMovie());
        verify(remote).getAllMovie();
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.ERROR, movieResponses.status);
    }

    @Test
    public void getListMovie_Empty() {
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.empty(null));
        Mockito.when(remote.getAllMovie()).thenReturn(listMovie);
        ApiResponse<List<MovieResponse>> movieResponses = LiveDataTestUtil.getValue(fakeRepository.getAllMovie());
        verify(remote).getAllMovie();
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.EMPTY, movieResponses.status);
    }

    @Test
    public void getListMovieById_Success() {
        MutableLiveData<ApiResponse<MovieResponse>> listMovie = new MutableLiveData<>();
        final MovieResponse movieResponse = DataDummy.setMovieDummy().get(movieId);
        listMovie.postValue(ApiResponse.success(movieResponse));
        Mockito.when(remote.getMovieById((movieId))).thenReturn(listMovie);
        ApiResponse<MovieResponse> movieResponses = LiveDataTestUtil.getValue(fakeRepository.getMovieById(movieId));
        verify(remote).getMovieById(eq(movieId));
        assertNotNull(movieResponses);
        assertEquals(movieResponse.getId(), movieResponses.data.getId());
    }

    @Test
    public void getListMovieById_Error() {
        MutableLiveData<ApiResponse<MovieResponse>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.error("error", null));
        Mockito.when(remote.getMovieById((movieId))).thenReturn(listMovie);
        ApiResponse<MovieResponse> movieResponses = LiveDataTestUtil.getValue(fakeRepository.getMovieById(movieId));
        verify(remote).getMovieById(eq(movieId));
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.ERROR, movieResponses.status);
    }

    @Test
    public void getListMovieById_Empty() {
        MutableLiveData<ApiResponse<MovieResponse>> listMovie = new MutableLiveData<>();
        listMovie.postValue(ApiResponse.empty(null));
        Mockito.when(remote.getMovieById((movieId))).thenReturn(listMovie);
        ApiResponse<MovieResponse> movieResponses = LiveDataTestUtil.getValue(fakeRepository.getMovieById(movieId));
        verify(remote).getMovieById(eq(movieId));
        assertNotNull(movieResponses);
        assertEquals(StatusResponse.EMPTY, movieResponses.status);
    }

    @Test
    public void getListTv_Success() {
        MutableLiveData<ApiResponse<List<TvResponse>>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.success(tvResponse));
        Mockito.when(remote.getAllTv()).thenReturn(listTv);
        ApiResponse<List<TvResponse>> tvResponses = LiveDataTestUtil.getValue(fakeRepository.getAllTv());
        verify(remote).getAllTv();
        assertNotNull(tvResponses);
        assertEquals(tvResponse.size(), tvResponses.data.size());
    }

    @Test
    public void getListTv_Error() {
        MutableLiveData<ApiResponse<List<TvResponse>>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.error("error", null));
        Mockito.when(remote.getAllTv()).thenReturn(listTv);
        ApiResponse<List<TvResponse>> tvResponses = LiveDataTestUtil.getValue(fakeRepository.getAllTv());
        verify(remote).getAllTv();
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.ERROR, tvResponses.status);
    }

    @Test
    public void getListTv_Empty() {
        MutableLiveData<ApiResponse<List<TvResponse>>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.empty(null));
        Mockito.when(remote.getAllTv()).thenReturn(listTv);
        ApiResponse<List<TvResponse>> tvResponses = LiveDataTestUtil.getValue(fakeRepository.getAllTv());
        verify(remote).getAllTv();
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.EMPTY, tvResponses.status);
    }

    @Test
    public void getListTvById_Success() {
        MutableLiveData<ApiResponse<TvResponse>> listTv = new MutableLiveData<>();
        final TvResponse tvResponse = DataDummy.setTvDummy().get(tvId);
        listTv.postValue(ApiResponse.success(tvResponse));
        Mockito.when(remote.getTvById((tvId))).thenReturn(listTv);
        ApiResponse<TvResponse> tvResponses = LiveDataTestUtil.getValue(fakeRepository.getTvById(tvId));
        verify(remote).getTvById(eq(tvId));
        assertNotNull(tvResponses);
        assertEquals(tvResponse.getId(), tvResponses.data.getId());
    }

    @Test
    public void getListTvById_Error() {
        MutableLiveData<ApiResponse<TvResponse>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.error("error", null));
        Mockito.when(remote.getTvById((tvId))).thenReturn(listTv);
        ApiResponse<TvResponse> tvResponses = LiveDataTestUtil.getValue(fakeRepository.getTvById(tvId));
        verify(remote).getTvById(eq(tvId));
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.ERROR, tvResponses.status);
    }

    @Test
    public void getListTvById_Empty() {
        MutableLiveData<ApiResponse<TvResponse>> listTv = new MutableLiveData<>();
        listTv.postValue(ApiResponse.empty(null));
        Mockito.when(remote.getTvById((tvId))).thenReturn(listTv);
        ApiResponse<TvResponse> tvResponses = LiveDataTestUtil.getValue(fakeRepository.getTvById(tvId));
        verify(remote).getTvById(eq(tvId));
        assertNotNull(tvResponses);
        assertEquals(StatusResponse.EMPTY, tvResponses.status);
    }

}