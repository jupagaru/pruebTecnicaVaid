package com.valid.jpgarcia.topartists.model.track;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.valid.jpgarcia.topartists.model.artist.TopArtist;

public class Data {

    @SerializedName("tracks")
    @Expose
    private Tracks tracks;

    public Tracks getTracks() {

        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }
}
