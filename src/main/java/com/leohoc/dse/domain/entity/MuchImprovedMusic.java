package com.leohoc.dse.domain.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.leohoc.dse.domain.entity.converter.LocalDateTimeConverter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@DynamoDBTable(tableName = "MuchImprovedMusic")
public class MuchImprovedMusic {

    @Id
    private MuchImprovedMusicId muchImprovedMusicId;

    private String artist;

    private String songTitle;

    public MuchImprovedMusic() {}

    public MuchImprovedMusic(MuchImprovedMusicId muchImprovedMusicId, String artist, String songTitle) {
        this.muchImprovedMusicId = muchImprovedMusicId;
        this.artist = artist;
        this.songTitle = songTitle;
    }

    @DynamoDBHashKey(attributeName = "MusicCode")
    public String getMusicCode() {
        return muchImprovedMusicId != null ? muchImprovedMusicId.getMusicCode() : null;
    }

    public void setMusicCode(String musicCode) {
        if (muchImprovedMusicId == null) {
            muchImprovedMusicId = new MuchImprovedMusicId();
        }
        muchImprovedMusicId.setMusicCode(musicCode);
    }

    @DynamoDBRangeKey(attributeName = "ReleaseDateTime")
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    public LocalDateTime getReleaseDateTime() {
        return muchImprovedMusicId != null ? muchImprovedMusicId.getReleaseDateTime() : null;
    }

    public void setReleaseDateTime(LocalDateTime releaseDateTime) {
        if (muchImprovedMusicId == null) {
            muchImprovedMusicId = new MuchImprovedMusicId();
        }
        muchImprovedMusicId.setReleaseDateTime(releaseDateTime);
    }

    @DynamoDBAttribute(attributeName = "Artist")
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @DynamoDBAttribute(attributeName = "SongTitle")
    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
}
