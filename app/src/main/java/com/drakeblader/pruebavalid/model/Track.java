package com.drakeblader.pruebavalid.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;
import androidx.room.TypeConverters;

import java.util.List;

import com.drakeblader.pruebavalid.utils.DataTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "track")
public class Track {

    @PrimaryKey
    @NonNull
    @SerializedName("name")
    @Expose
    private String name;
    @ColumnInfo(name = "duration")
    @SerializedName("duration")
    @Expose
    private String duration;
    @ColumnInfo(name = "listeners")
    @SerializedName("listeners")
    @Expose
    private String listeners;
    @ColumnInfo(name = "mbid")
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    private String url;
    @Embedded(prefix = "track_streamable_")
    @SerializedName("streamable")
    @Expose
    private Streamable streamable;
    @Embedded(prefix = "track_artist_")
    @SerializedName("artist")
    @Expose
    private Artist artist;
    @ColumnInfo(name = "image")
    @TypeConverters(DataTypeConverter.class)
    @SerializedName("image")
    @Expose
    private List<Image> image = null;
    @Embedded(prefix = "track_inattr_")
    @SerializedName("@attr")
    @Expose
    private InAttr inAttr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Streamable getStreamable() {
        return streamable;
    }

    public void setStreamable(Streamable streamable) {
        this.streamable = streamable;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public InAttr getInAttr() {
        return inAttr;
    }

    public void setInAttr(InAttr inAttr) {
        this.inAttr = inAttr;
    }

}