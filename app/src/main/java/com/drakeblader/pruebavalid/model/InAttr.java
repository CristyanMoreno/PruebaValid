package com.drakeblader.pruebavalid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InAttr {

    @SerializedName("rank")
    @Expose
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}