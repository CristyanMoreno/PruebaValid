package com.drakeblader.pruebavalid.ui.topartists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TopArtistsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TopArtistsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Top Artists fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}