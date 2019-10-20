package com.drakeblader.pruebavalid.ui.toptracks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeblader.pruebavalid.R;
import com.drakeblader.pruebavalid.model.Track;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TopTracksAdapter extends RecyclerView.Adapter<TopTracksAdapter.TopTracksHolder> {
    private ArrayList<Track> tracks = new ArrayList<>();

    @NonNull
    @Override
    public TopTracksHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_tracks_cardview, parent, false);
        return new TopTracksHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopTracksHolder holder, int position) {
        Track currentTracks = tracks.get(position);
        holder.textView.setText(currentTracks.getName());
        holder.rankTV.setText(currentTracks.getInAttr().getRank());
        holder.artistTV.setText(currentTracks.getArtist().getName());
        holder.listenersTV.setText("Escuchando: " + currentTracks.getListeners());
        holder.durationTV.setText(currentTracks.getDuration() + "s");
        Picasso.get().load(currentTracks.getImage().get(3).getText()).into(holder.songImage);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void setTracks(ArrayList<Track> tracks){
        this.tracks = tracks;
        notifyDataSetChanged();
    }

    class TopTracksHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView rankTV;
        private ImageView songImage;
        private TextView artistTV;
        private TextView listenersTV;
        private TextView durationTV;

        public TopTracksHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_top_tracks);
            rankTV = itemView.findViewById(R.id.text_rank);
            songImage = itemView.findViewById(R.id.image_song);
            artistTV = itemView.findViewById(R.id.text_artist);
            listenersTV = itemView.findViewById(R.id.text_listeners);
            durationTV = itemView.findViewById(R.id.text_duration);
        }
    }
}
