package com.drakeblader.pruebavalid.ui.topartists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeblader.pruebavalid.R;
import com.drakeblader.pruebavalid.model.Artist;

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
        /*holder.rankTV.setText(currentTracks.getInAttr().getRank());
        holder.artistTV.setText(currentTracks.getArtist().getName());
        holder.listenersTV.setText("Escuchando: " + currentTracks.getListeners());
        holder.durationTV.setText(currentTracks.getDuration() + "s");
        Picasso.get().load(currentTracks.getImage().get(3).getText()).into(holder.songImage);*/
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
        /*private TextView rankTV;
        private ImageView songImage;
        private TextView artistTV;
        private TextView listenersTV;
        private TextView durationTV;*/

        public TopArtistsHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_top_artist);
            /*rankTV = itemView.findViewById(R.id.text_rank);
            songImage = itemView.findViewById(R.id.image_song);
            artistTV = itemView.findViewById(R.id.text_artist);
            listenersTV = itemView.findViewById(R.id.text_listeners);
            durationTV = itemView.findViewById(R.id.text_duration);*/
        }
    }
}
