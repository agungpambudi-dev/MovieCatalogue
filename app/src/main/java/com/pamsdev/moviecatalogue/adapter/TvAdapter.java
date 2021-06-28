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
import com.pamsdev.moviecatalogue.data.source.local.entity.TvEntity;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;

import java.util.ArrayList;
import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ListViewHolder> {

    private final ArrayList<TvEntity> listTv = new ArrayList<>();

    private TvAdapter.OnItemClickCallback onItemClickCallback;

    public void setListTv(List<TvEntity> listTvs) {
        this.listTv.clear();
        this.listTv.addAll(listTvs);
        notifyDataSetChanged();
    }

    public void setOnItemClickCallback(TvAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public TvAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_data, viewGroup, false);
        return new TvAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvAdapter.ListViewHolder holder, int position) {
        TvEntity tv = listTv.get(position);
        String url = "https://image.tmdb.org/t/p/w185";

        Glide.with(holder.itemView.getContext())
                .load(url+tv.getPoster())
                .apply(new RequestOptions())
                .into(holder.ivPoster);
        holder.tvTitle.setText(tv.getTitle());
        holder.tvRelease.setText(tv.getRelease());
        holder.tvRating.setText(tv.getVote());
        holder.tvDescription.setText(tv.getOverview());

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listTv.get(holder.getAbsoluteAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvEntity data);
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
