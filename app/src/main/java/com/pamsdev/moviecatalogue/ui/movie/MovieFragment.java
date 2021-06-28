package com.pamsdev.moviecatalogue.ui.movie;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pamsdev.moviecatalogue.adapter.MovieAdapter;
import com.pamsdev.moviecatalogue.data.source.remote.StatusResponse;
import com.pamsdev.moviecatalogue.databinding.FragmentMovieBinding;
import com.pamsdev.moviecatalogue.ui.DetailActivity;
import com.pamsdev.moviecatalogue.viewmodel.MovieViewModel;
import com.pamsdev.moviecatalogue.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;


public class MovieFragment extends Fragment {

    private FragmentMovieBinding fragmentMovieBinding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater);
        return fragmentMovieBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
        MovieViewModel viewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);
        showLoading(true);

        MovieAdapter movieAdapter = new MovieAdapter();
        viewModel.getListMovie().observe(getViewLifecycleOwner(), movieResponses -> {
            if (movieResponses != null) {
                switch (movieResponses.status) {
                    case LOADING:
                        showLoading(true);
                        break;
                    case SUCCESS:
                        showLoading(false);
                        movieAdapter.setListMovie(movieResponses.data);
                        movieAdapter.notifyDataSetChanged();
                        break;
                    case ERROR:
                        showLoading(false);
                        Toast.makeText(getContext(), movieResponses.message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        fragmentMovieBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentMovieBinding.rvMovie.setHasFixedSize(true);
        fragmentMovieBinding.rvMovie.setAdapter(movieAdapter);
        movieAdapter.setOnItemClickCallback(data -> {
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.MOVIE_KEY, data);
            startActivity(intent);
        });

    }

    private void showLoading(Boolean state) {
        if (state) {
            fragmentMovieBinding.progressbar.setVisibility(View.VISIBLE);
        } else {
            fragmentMovieBinding.progressbar.setVisibility(View.GONE);
        }
    }

}