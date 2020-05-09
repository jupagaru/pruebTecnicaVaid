package com.valid.jpgarcia.topartists.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.valid.jpgarcia.topartists.R;
import com.valid.jpgarcia.topartists.model.artist.Artist;
import com.valid.jpgarcia.topartists.model.artist.Attr;

import java.util.List;


public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistAdapterHolder> {

    private List<Artist> artists;
    private Attr attrs;

    public ArtistAdapter (List<Artist> artists){

        this.artists = artists;

    }

    @NonNull
    @Override
    public ArtistAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_artist, parent, false);
        return new ArtistAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapterHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.tvName.setText(artist.getName());
        holder.tvListeners.setText(artist.getListeners());
        holder.tvUrl.setText(artist.getUrl());
        holder.tvStreamable.setText(artist.getStreamable());

        Picasso.get()
                .load(artist.getImage().get(0).getText())
                  .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void setData(List<Artist> artists){
        this.artists = artists;
        notifyDataSetChanged();
    }


    public class ArtistAdapterHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvListeners;
        private TextView tvUrl;
        private TextView tvStreamable;
        private ImageView imgView;

        public ArtistAdapterHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvListeners = itemView.findViewById(R.id.tvListeners);
            tvUrl = itemView.findViewById(R.id.tvUrl);
            tvStreamable = itemView.findViewById(R.id.tvStreamable);
            imgView = itemView.findViewById(R.id.idImg);
        }

    }
}
