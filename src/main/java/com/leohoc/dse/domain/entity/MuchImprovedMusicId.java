package com.leohoc.dse.domain.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.leohoc.dse.domain.entity.converter.LocalDateTimeConverter;

import java.time.LocalDateTime;

public class MuchImprovedMusicId {

    private String musicCode;
    private LocalDateTime releaseDateTime;

    public MuchImprovedMusicId() {}

    public MuchImprovedMusicId(String musicCode, LocalDateTime releaseDateTime) {
        this.musicCode = musicCode;
        this.releaseDateTime = releaseDateTime;
    }

    @DynamoDBHashKey(attributeName = "MusicCode")
    public String getMusicCode() {
        return musicCode;
    }

    public void setMusicCode(String musicCode) {
        this.musicCode = musicCode;
    }

    @DynamoDBRangeKey(attributeName = "ReleaseDateTime")
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    public LocalDateTime getReleaseDateTime() {
        return releaseDateTime;
    }

    public void setReleaseDateTime(LocalDateTime releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }
}