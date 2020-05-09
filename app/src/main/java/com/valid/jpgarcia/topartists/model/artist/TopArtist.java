package com.valid.jpgarcia.topartists.model.artist;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.valid.jpgarcia.topartists.model.artist.Artist;
import com.valid.jpgarcia.topartists.model.artist.Attr;

public class TopArtist {

    @SerializedName("artist")
    @Expose
    private List<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }
}
