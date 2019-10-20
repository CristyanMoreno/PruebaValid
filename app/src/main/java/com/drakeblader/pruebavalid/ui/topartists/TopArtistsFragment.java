package com.drakeblader.pruebavalid.ui.topartists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.drakeblader.pruebavalid.R;

public class TopArtistsFragment extends Fragment {

    private TopArtistsViewModel topArtistsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topArtistsViewModel =
                ViewModelProviders.of(this).get(TopArtistsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_top_artists, container, false);
        final TextView textView = root.findViewById(R.id.text_top_artists);
        topArtistsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}