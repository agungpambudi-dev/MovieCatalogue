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

import com.pamsdev.moviecatalogue.adapter.TvAdapter;
import com.pamsdev.moviecatalogue.data.source.remote.StatusResponse;
import com.pamsdev.moviecatalogue.databinding.FragmentTvBinding;
import com.pamsdev.moviecatalogue.ui.DetailActivity;
import com.pamsdev.moviecatalogue.viewmodel.TvViewModel;
import com.pamsdev.moviecatalogue.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

public class TvFragment extends Fragment {

    private FragmentTvBinding fragmentTvBinding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentTvBinding = FragmentTvBinding.inflate(inflater);
        return fragmentTvBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
        TvViewModel viewModel = new ViewModelProvider(this, factory).get(TvViewModel.class);
        showLoading(true);

        TvAdapter tvAdapter = new TvAdapter();
        viewModel.getListTv().observe(getViewLifecycleOwner(), tvResponses -> {
            if (tvResponses != null) {
                switch (tvResponses.status) {
                    case LOADING:
                        showLoading(true);
                        break;
                    case SUCCESS:
                        showLoading(false);
                        tvAdapter.setListTv(tvResponses.data);
                        tvAdapter.notifyDataSetChanged();
                        break;
                    case ERROR:
                        showLoading(false);
                        Toast.makeText(getContext(), tvResponses.message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        fragmentTvBinding.rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentTvBinding.rvTv.setHasFixedSize(true);
        fragmentTvBinding.rvTv.setAdapter(tvAdapter);
        tvAdapter.setOnItemClickCallback(data -> {
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.TV_KEY, data);
            startActivity(intent);
        });

    }

    private void showLoading(Boolean state) {
        if (state) {
            fragmentTvBinding.progressbar.setVisibility(View.VISIBLE);
        } else {
            fragmentTvBinding.progressbar.setVisibility(View.GONE);
        }
    }
    
}