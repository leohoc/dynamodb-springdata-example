package com.leohoc.dse.service;

import com.google.common.collect.Lists;
import com.leohoc.dse.domain.entity.MuchImprovedMusic;
import com.leohoc.dse.domain.entity.MuchImprovedMusicId;
import com.leohoc.dse.infrastructure.persistence.MuchImprovedMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MuchImprovedMusicService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private MuchImprovedMusicRepository muchImprovedMusicRepository;

    public List<MuchImprovedMusic> listAllMuchImprovedMusics() {
        Iterable<MuchImprovedMusic> muchImprovedMusics = muchImprovedMusicRepository.findAll();
        return Lists.newArrayList(muchImprovedMusics);
    }

    public MuchImprovedMusic createMuchImprovedMusic(final UUID musicCode,
                                                     final LocalDateTime releaseDateTime,
                                                     final String artist,
                                                     final String songTitle) {
        MuchImprovedMusicId muchImprovedMusicId = new MuchImprovedMusicId(musicCode.toString(), releaseDateTime);
        return muchImprovedMusicRepository.save(new MuchImprovedMusic(muchImprovedMusicId, artist, songTitle));
    }

    public MuchImprovedMusic getMuchImprovedMusic(final String musicCode) {
        return muchImprovedMusicRepository.findByMusicCode(musicCode);
    }

    public List<MuchImprovedMusic> listArtistMusics(final String artist,
                                                    final LocalDateTime startReleaseDateTime,
                                                    final LocalDateTime endReleaseDateTime, Integer page) {
        if (startReleaseDateTime != null && endReleaseDateTime != null) {

            Page<MuchImprovedMusic> muchImprovedMusicPage = muchImprovedMusicRepository.findByArtistAndReleaseDateTimeBetween(
                                                                                                    artist,
                                                                                                    startReleaseDateTime,
                                                                                                    endReleaseDateTime,
                                                                                                    PageRequest.of(page, PAGE_SIZE));
            List<MuchImprovedMusic> muchImprovedMusics = muchImprovedMusicPage.getContent();

            return muchImprovedMusics;
        }
        if (startReleaseDateTime != null) {
            return muchImprovedMusicRepository.findByArtistAndReleaseDateTimeGreaterThan(artist, startReleaseDateTime);
        }
        if (endReleaseDateTime != null) {
            return muchImprovedMusicRepository.findByArtistAndReleaseDateTimeLessThan(artist, endReleaseDateTime);
        }
        return muchImprovedMusicRepository.findByArtist(artist);
    }
}