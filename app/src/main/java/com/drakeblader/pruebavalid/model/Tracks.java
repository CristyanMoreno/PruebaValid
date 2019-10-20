package com.drakeblader.pruebavalid.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracks {

    @SerializedName("track")
    @Expose
    private ArrayList<Track> track = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public ArrayList<Track> getTrack() {
        return track;
    }

    public void setTrack(ArrayList<Track> track) {
        this.track = track;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

}