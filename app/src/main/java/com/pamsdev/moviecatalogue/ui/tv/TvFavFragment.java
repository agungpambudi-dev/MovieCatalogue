package com.pamsdev.moviecatalogue.ui.tv;

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
import com.pamsdev.moviecatalogue.adapter.TvAdapter;
import com.pamsdev.moviecatalogue.databinding.FragmentTvBinding;
import com.pamsdev.moviecatalogue.databinding.FragmentTvFavBinding;
import com.pamsdev.moviecatalogue.ui.DetailActivity;
import com.pamsdev.moviecatalogue.viewmodel.TvFavViewModel;
import com.pamsdev.moviecatalogue.viewmodel.TvViewModel;
import com.pamsdev.moviecatalogue.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

public class TvFavFragment extends Fragment {

    private FragmentTvFavBinding fragmentTvFavBinding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentTvFavBinding = FragmentTvFavBinding.inflate(inflater);
        return fragmentTvFavBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
        TvFavViewModel viewModel = new ViewModelProvider(this, factory).get(TvFavViewModel.class);
        //showLoading(true);

        TvAdapter tvAdapter = new TvAdapter();
        viewModel.getFavTv.observe(getViewLifecycleOwner(), tvResponses -> {
            if (tvResponses != null) {
                //showLoading(false);
                tvAdapter.setListTv(tvResponses);
                tvAdapter.notifyDataSetChanged();
            }
        });

        fragmentTvFavBinding.rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentTvFavBinding.rvTv.setHasFixedSize(true);
        fragmentTvFavBinding.rvTv.setAdapter(tvAdapter);
        tvAdapter.setOnItemClickCallback(data -> {
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.TV_KEY, data);
            startActivity(intent);
        });

    }

    private void showLoading(Boolean state) {
        if (state) {
            fragmentTvFavBinding.progressbar.setVisibility(View.VISIBLE);
        } else {
            fragmentTvFavBinding.progressbar.setVisibility(View.GONE);
        }
    }
}