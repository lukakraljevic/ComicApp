package com.example.luka.comicsapp.ui.comicdetails;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.domain.model.ComicCharacter;
import com.example.luka.comicsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class ComicDetailsAdapter extends RecyclerView.Adapter<ComicDetailsAdapter.ViewHolder> {

    private final List<ComicCharacter> dataSource = new ArrayList<>();

    public void setData(List<ComicCharacter> data) {
        this.dataSource.clear();
        this.dataSource.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComicDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_character,
                parent, false);
        return new ComicDetailsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ComicCharacter comicCharacter = dataSource.get(position);
        holder.nameTextView.setText(comicCharacter.name);

        Linkify.addLinks(holder.detailsTextView, Pattern.compile(""),
                comicCharacter.siteDetailUrl);
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView detailsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.character_list_name);
            detailsTextView = itemView.findViewById(R.id.character_list_details);
        }
    }
}