package com.leohoc.dse.domain.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "ImprovedMusic")
public class ImprovedMusic {

    @Id
    private ImprovedMusicId improvedMusicId;

    public ImprovedMusic() {}

    public ImprovedMusic(ImprovedMusicId improvedMusicId) {
        this.improvedMusicId = improvedMusicId;
    }

    @DynamoDBHashKey(attributeName = "Artist")
    public String getArtist() {
        return improvedMusicId != null ? improvedMusicId.getArtist() : null;
    }

    public void setArtist(String artist) {
        if (improvedMusicId == null) {
            improvedMusicId = new ImprovedMusicId();
        }
        improvedMusicId.setArtist(artist);
    }

    @DynamoDBRangeKey(attributeName = "SongTitle")
    public String getSongTitle() {
        return improvedMusicId != null ? improvedMusicId.getSongTitle() : null;
    }

    public void setSongTitle(String songTitle) {
        if (improvedMusicId == null) {
            improvedMusicId = new ImprovedMusicId();
        }
        improvedMusicId.setSongTitle(songTitle);
    }
}
