package com.variety.shop.indi.java8.stream;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by rongbin.xie on 2017/12/28.
 */
public class Album {
    private String name;
    private Stream<Track> tracks;
    private Stream<Artist> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stream<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Stream<Track> tracks) {
        this.tracks = tracks;
    }

    public Stream<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(Stream<Artist> musicians) {
        this.musicians = musicians;
    }
}
