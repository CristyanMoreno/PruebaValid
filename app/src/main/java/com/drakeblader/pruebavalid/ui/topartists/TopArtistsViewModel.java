package com.drakeblader.pruebavalid.ui.topartists;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.drakeblader.pruebavalid.model.Artist;
import com.drakeblader.pruebavalid.model.TopArtistsPOJO;
import com.drakeblader.pruebavalid.utils.APIClient;
import com.drakeblader.pruebavalid.utils.APIInterface;
import com.drakeblader.pruebavalid.utils.AppDatabase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopArtistsViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Artist>> topArtistsPOJOMutableLiveData;

    public TopArtistsViewModel(final Application application) {
        super(application);

        topArtistsPOJOMutableLiveData = new MutableLiveData<>();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<TopArtistsPOJO> call = apiInterface.getTopArtists();
        call.enqueue(new Callback<TopArtistsPOJO>() {
            @Override
            public void onResponse(Call<TopArtistsPOJO> call, Response<TopArtistsPOJO> response) {
                topArtistsPOJOMutableLiveData.setValue(response.body().getTopartists().getArtist());
                AppDatabase appDatabase = Room.databaseBuilder(application,
                        AppDatabase.class, "lastfm").allowMainThreadQueries().build();
                appDatabase.artistDAO().insertAll(response.body().getTopartists().getArtist());
            }

            @Override
            public void onFailure(Call<TopArtistsPOJO> call, Throwable t) {
                call.cancel();
                AppDatabase appDatabase = Room.databaseBuilder(application,
                        AppDatabase.class, "lastfm").allowMainThreadQueries().build();
                topArtistsPOJOMutableLiveData.setValue(new ArrayList<Artist>(appDatabase.artistDAO().getAll()));
            }
        });
    }

    public LiveData<ArrayList<Artist>> getTracks() {
        return topArtistsPOJOMutableLiveData;
    }
}