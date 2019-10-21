package com.drakeblader.pruebavalid.ui.toptracks;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.drakeblader.pruebavalid.model.TopTracksPOJO;
import com.drakeblader.pruebavalid.model.Track;
import com.drakeblader.pruebavalid.utils.APIClient;
import com.drakeblader.pruebavalid.utils.APIInterface;
import com.drakeblader.pruebavalid.utils.AppDatabase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopTracksViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Track>> topTracksPOJOMutableLiveData;

    public TopTracksViewModel(final Application application) {
        super(application);

        topTracksPOJOMutableLiveData = new MutableLiveData<>();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<TopTracksPOJO> call = apiInterface.getTopTracks();
        call.enqueue(new Callback<TopTracksPOJO>() {
            @Override
            public void onResponse(Call<TopTracksPOJO> call, Response<TopTracksPOJO> response) {
                topTracksPOJOMutableLiveData.setValue(response.body().getTracks().getTrack());
                AppDatabase appDatabase = Room.databaseBuilder(application,
                        AppDatabase.class, "lastfm").allowMainThreadQueries().build();
                appDatabase.trackDAO().insertAll(response.body().getTracks().getTrack());
            }

            @Override
            public void onFailure(Call<TopTracksPOJO> call, Throwable t) {
                call.cancel();
                AppDatabase appDatabase = Room.databaseBuilder(application,
                        AppDatabase.class, "lastfm").allowMainThreadQueries().build();
                topTracksPOJOMutableLiveData.setValue(new ArrayList<Track>(appDatabase.trackDAO().getAll()));
            }
        });
    }

    public LiveData<ArrayList<Track>> getTracks() {
        return topTracksPOJOMutableLiveData;
    }
}