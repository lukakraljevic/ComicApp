package com.example.luka.comicsapp.ui.comics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.R;
import com.example.luka.comicsapp.ui.utils.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ViewHolder> {

    private Context context;
    private List<Comic> dataSource;
    private ItemClickListener itemClickListener;

    public ComicAdapter(Context context) {
        this.context = context;
        this.dataSource = new ArrayList<>();
    }

    public void setData(List<Comic> data) {
        this.dataSource.clear();
        this.dataSource.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(Comic c) {
        this.dataSource.add(c);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_comic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comic comic = dataSource.get(position);
        holder.titleTextView.setText(comic.name);
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

    void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTextView;
        ImageView thumbnailImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.comic_list_title);
            thumbnailImageView = itemView.findViewById(R.id.comic_list_thumbnail);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
