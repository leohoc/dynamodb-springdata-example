package com.leohoc.dse.domain.dto;

public class MuchImprovedMusicDTO {

    private String artist;
    private String songTitle;

    public MuchImprovedMusicDTO() {}

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    @Override
    public String toString() {
        return "MuchImprovedMusicDTO{" +
                "artist='" + artist + '\'' +
                ", songTitle='" + songTitle + '\'' +
                '}';
    }
}
