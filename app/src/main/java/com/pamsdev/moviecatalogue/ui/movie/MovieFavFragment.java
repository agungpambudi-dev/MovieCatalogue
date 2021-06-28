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

import com.pamsdev.moviecatalogue.R;
import com.pamsdev.moviecatalogue.adapter.MovieAdapter;
import com.pamsdev.moviecatalogue.databinding.FragmentMovieBinding;
import com.pamsdev.moviecatalogue.databinding.FragmentMovieFavBinding;
import com.pamsdev.moviecatalogue.ui.DetailActivity;
import com.pamsdev.moviecatalogue.viewmodel.MovieFavViewModel;
import com.pamsdev.moviecatalogue.viewmodel.MovieViewModel;
import com.pamsdev.moviecatalogue.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

import static com.pamsdev.moviecatalogue.vo.Status.LOADING;

public class MovieFavFragment extends Fragment {

    private FragmentMovieFavBinding fragmentMovieFavBinding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentMovieFavBinding = FragmentMovieFavBinding.inflate(inflater);
        return fragmentMovieFavBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
        MovieFavViewModel viewModel = new ViewModelProvider(this, factory).get(MovieFavViewModel.class);
        //showLoading(true);

        MovieAdapter movieAdapter = new MovieAdapter();
        viewModel.getFavMovie.observe(getViewLifecycleOwner(), movieResponses -> {
            if (movieResponses != null) {
                //showLoading(false);
                movieAdapter.setListMovie(movieResponses);
                movieAdapter.notifyDataSetChanged();
            }
        });

        fragmentMovieFavBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentMovieFavBinding.rvMovie.setHasFixedSize(true);
        fragmentMovieFavBinding.rvMovie.setAdapter(movieAdapter);
        movieAdapter.setOnItemClickCallback(data -> {
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.MOVIE_KEY, data);
            startActivity(intent);
        });

    }

    private void showLoading(Boolean state) {
        if (state) {
            fragmentMovieFavBinding.progressbar.setVisibility(View.VISIBLE);
        } else {
            fragmentMovieFavBinding.progressbar.setVisibility(View.GONE);
        }
    }
}