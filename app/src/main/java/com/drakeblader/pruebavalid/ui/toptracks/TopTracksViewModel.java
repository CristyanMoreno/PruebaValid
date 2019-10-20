package com.drakeblader.pruebavalid.ui.toptracks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.drakeblader.pruebavalid.model.TopTracksPOJO;
import com.drakeblader.pruebavalid.model.Track;
import com.drakeblader.pruebavalid.utils.APIClient;
import com.drakeblader.pruebavalid.utils.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopTracksViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Track>> topTracksPOJOMutableLiveData;

    public TopTracksViewModel() {

        topTracksPOJOMutableLiveData = new MutableLiveData<>();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<TopTracksPOJO> call = apiInterface.getTopTracks();
        call.enqueue(new Callback<TopTracksPOJO>() {
            @Override
            public void onResponse(Call<TopTracksPOJO> call, Response<TopTracksPOJO> response) {
                topTracksPOJOMutableLiveData.setValue(response.body().getTracks().getTrack());
            }

            @Override
            public void onFailure(Call<TopTracksPOJO> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public LiveData<ArrayList<Track>> getTracks() {
        return topTracksPOJOMutableLiveData;
    }
}