package com.example.luka.comicsapp.ui.comicdetails;

import android.content.Context;
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

public class ComicDetailsAdapter extends RecyclerView.Adapter<ComicDetailsAdapter.ViewHolder> {

    private Context context;
    private List<ComicCharacter> dataSource;

    public ComicDetailsAdapter(Context context) {
        this.context = context;
        this.dataSource = new ArrayList<>();
    }

    public void setData(List<ComicCharacter> data) {
        this.dataSource.clear();
        this.dataSource.addAll(data);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ComicDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_character, parent, false);
        return new ComicDetailsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ComicCharacter comicCharacter = dataSource.get(position);
        holder.nameTextView.setText(comicCharacter.name);

        Linkify.addLinks(holder.detailsTextView, Pattern.compile(""),
                comicCharacter.siteDetailUrl);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public ComicCharacter get(int position) {
        return dataSource.get(position);
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