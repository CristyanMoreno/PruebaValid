package com.drakeblader.pruebavalid.ui.topartists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeblader.pruebavalid.R;
import com.drakeblader.pruebavalid.model.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TopArtistsAdapter extends RecyclerView.Adapter<TopArtistsAdapter.TopArtistsHolder> {
    private ArrayList<Artist> artists = new ArrayList<>();

    @NonNull
    @Override
    public TopArtistsAdapter.TopArtistsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_artists_cardview, parent, false);
        return new TopArtistsAdapter.TopArtistsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopArtistsAdapter.TopArtistsHolder holder, int position) {
        Artist currentArtist = artists.get(position);
        holder.textView.setText(currentArtist.getName());
        holder.urlTV.setText(currentArtist.getUrl());
        holder.listenersTV.setText("Escuchando: " + currentArtist.getListeners());
        Picasso.get().load(currentArtist.getImage().get(2).getText()).into(holder.artistImage);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void setArtists(ArrayList<Artist> artists){
        this.artists = artists;
        notifyDataSetChanged();
    }

    class TopArtistsHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView urlTV;
        private ImageView artistImage;
        private TextView listenersTV;

        public TopArtistsHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_top_artist);
            urlTV = itemView.findViewById(R.id.text_url);
            artistImage = itemView.findViewById(R.id.image_artist);
            listenersTV = itemView.findViewById(R.id.text_listeners_artist);
        }
    }
}
