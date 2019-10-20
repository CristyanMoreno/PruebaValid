package com.drakeblader.pruebavalid.ui.topartists;

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
import com.drakeblader.pruebavalid.model.Artist;

import java.util.ArrayList;

public class TopArtistsFragment extends Fragment {

    private TopArtistsViewModel topArtistsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topArtistsViewModel =
                ViewModelProviders.of(this).get(TopArtistsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_top_artists, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_artists);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final TopArtistsAdapter topArtistsAdapter = new TopArtistsAdapter();

        topArtistsViewModel.getTracks().observe(this, new Observer<ArrayList<Artist>>() {
            @Override
            public void onChanged(ArrayList<Artist> artists) {
                topArtistsAdapter.setArtists(artists);
            }
        });

        recyclerView.setAdapter(topArtistsAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return root;
    }
}