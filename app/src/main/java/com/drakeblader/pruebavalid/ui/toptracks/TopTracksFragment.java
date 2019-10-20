package com.drakeblader.pruebavalid.ui.toptracks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeblader.pruebavalid.R;
import com.drakeblader.pruebavalid.model.Track;

import java.util.ArrayList;

public class TopTracksFragment extends Fragment {

    private TopTracksViewModel topTracksViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topTracksViewModel =
                ViewModelProviders.of(this).get(TopTracksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_top_tracks, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final TopTracksAdapter topTracksAdapter = new TopTracksAdapter();

        topTracksViewModel.getTracks().observe(this, new Observer<ArrayList<Track>>() {
            @Override
            public void onChanged(ArrayList<Track> tracks) {
                topTracksAdapter.setTracks(tracks);
            }
        });

        recyclerView.setAdapter(topTracksAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return root;
    }
}