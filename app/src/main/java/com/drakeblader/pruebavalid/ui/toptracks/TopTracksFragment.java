package com.drakeblader.pruebavalid.ui.toptracks;

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

public class TopTracksFragment extends Fragment {

    private TopTracksViewModel topTracksViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        topTracksViewModel =
                ViewModelProviders.of(this).get(TopTracksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_top_tracks, container, false);
        final TextView textView = root.findViewById(R.id.navigation_top_tracks);
        topTracksViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}