package com.example.luka.comicsapp.ui.comics;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.ui.listener.ComicClickListener;
import com.example.luka.comicsapp.ui.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public final class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ViewHolder> {

    private final List<Comic> dataSource = new ArrayList<>();
    private ComicClickListener itemClickListener;

    public void setData(List<Comic> data) {
        this.dataSource.clear();
        this.dataSource.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(List<Comic> data, int page) {
        if (page == 1) {
            this.dataSource.clear();
        }

        this.dataSource.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_comic, parent, false);
        return new ViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Comic comic = dataSource.get(position);
        holder.setData(comic);
        holder.titleTextView.setText(comic.name);
        holder.airDateTextView.setText(comic.airDate);
        ImageLoader.loadImage(comic.thumbnailUrl, holder.thumbnailImageView, R.mipmap.ic_launcher);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    void setClickListener(ComicClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTextView;
        TextView airDateTextView;
        ImageView thumbnailImageView;
        ComicClickListener itemClickListener;
        private Comic comic;

        public ViewHolder(View itemView, ComicClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;
            titleTextView = itemView.findViewById(R.id.comic_list_title);
            airDateTextView = itemView.findViewById(R.id.comic_list_air_date);
            thumbnailImageView = itemView.findViewById(R.id.comic_list_thumbnail);
            itemView.setOnClickListener(this);
        }

        private void setData(Comic comic){
            this.comic = comic;
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onComicClick(comic);
        }
    }
}
