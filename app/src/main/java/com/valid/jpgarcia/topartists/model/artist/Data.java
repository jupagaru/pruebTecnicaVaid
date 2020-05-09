package com.valid.jpgarcia.topartists.model.artist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("topartists")
    @Expose
    private TopArtist topArtist;

    public TopArtist getTopArtist() {
        return topArtist;
    }

    public void setTopArtist(TopArtist topArtist) {
        this.topArtist = topArtist;
    }
}
