package com.drakeblader.pruebavalid.utils;

import com.drakeblader.pruebavalid.model.TopArtistsPOJO;
import com.drakeblader.pruebavalid.model.TopTracksPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("2.0/?method=geo.gettoptracks&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    Call<TopTracksPOJO> getTopTracks();

    @GET("2.0/?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    Call<List<TopArtistsPOJO>> getTopArtists();
}
