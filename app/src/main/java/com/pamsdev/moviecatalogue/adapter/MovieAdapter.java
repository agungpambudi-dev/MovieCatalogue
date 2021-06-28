package com.pamsdev.moviecatalogue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pamsdev.moviecatalogue.R;
import com.pamsdev.moviecatalogue.data.source.local.entity.MovieEntity;
import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {

    private final List<MovieEntity> listMovie = new ArrayList<>();

    private OnItemClickCallback onItemClickCallback;

    public void setListMovie(List<MovieEntity> listMovies) {
        this.listMovie.clear();
        this.listMovie.addAll(listMovies);
        notifyDataSetChanged();
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_data, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        MovieEntity movie = listMovie.get(position);
        String url = "https://image.tmdb.org/t/p/w185";

        Glide.with(holder.itemView.getContext())
                .load(url+movie.getPoster())
                .apply(new RequestOptions())
                .into(holder.ivPoster);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvRelease.setText(movie.getRelease());
        holder.tvRating.setText(movie.getVote());
        holder.tvDescription.setText(movie.getOverview());

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listMovie.get(holder.getAbsoluteAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(MovieEntity data);
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPoster;
        TextView tvTitle, tvRelease, tvRating, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvRelease = itemView.findViewById(R.id.tv_release);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
