package com.drakeblader.pruebavalid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopArtistsPOJO {

    @SerializedName("topartists")
    @Expose
    private TopArtists topArtists;

    public TopArtists getTopartists() {
        return topArtists;
    }

    public void setTopartists(TopArtists topartists) {
        this.topArtists = topartists;
    }

}