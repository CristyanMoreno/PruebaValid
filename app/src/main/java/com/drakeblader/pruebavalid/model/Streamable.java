package com.drakeblader.pruebavalid.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "streamable")
public class Streamable {

    @ColumnInfo(name = "text")
    @SerializedName("#text")
    @Expose
    private String text;
    @ColumnInfo(name = "fulltrack")
    @SerializedName("fulltrack")
    @Expose
    private String fulltrack;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }

}