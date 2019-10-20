package com.drakeblader.pruebavalid.ui.toptracks;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.drakeblader.pruebavalid.R;
import com.drakeblader.pruebavalid.model.TopTracksPOJO;
import com.drakeblader.pruebavalid.utils.APIClient;
import com.drakeblader.pruebavalid.utils.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopTracksViewModel extends ViewModel {

    APIInterface apiInterface;

    private MutableLiveData<String> mText;

    public TopTracksViewModel() {

        mText = new MutableLiveData<>();
        //mText.setValue("This is Top Tracks fragment");

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<TopTracksPOJO> call = apiInterface.getTopTracks();
        call.enqueue(new Callback<TopTracksPOJO>() {
            @Override
            public void onResponse(Call<TopTracksPOJO> call, Response<TopTracksPOJO> response) {

            }

            @Override
            public void onFailure(Call<TopTracksPOJO> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public LiveData<String> getText() {
        return mText;
    }
}