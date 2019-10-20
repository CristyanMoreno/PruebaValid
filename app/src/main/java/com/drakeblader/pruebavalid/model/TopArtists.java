package com.drakeblader.pruebavalid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopArtists {

    @SerializedName("artist")
    @Expose
    private ArrayList<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public ArrayList<Artist> getArtist() {
        return artist;
    }

    public void setArtist(ArrayList<Artist> artist) {
        this.artist = artist;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

}