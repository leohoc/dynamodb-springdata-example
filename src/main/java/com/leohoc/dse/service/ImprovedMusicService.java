package com.leohoc.dse.service;

import com.google.common.collect.Lists;
import com.leohoc.dse.domain.entity.ImprovedMusic;
import com.leohoc.dse.domain.entity.ImprovedMusicId;
import com.leohoc.dse.infrastructure.persistence.ImprovedMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImprovedMusicService {

    @Autowired
    private ImprovedMusicRepository improvedMusicRepository;

    public List<ImprovedMusic> listAllImprovedMusics() {
        Iterable<ImprovedMusic> improvedMusics = improvedMusicRepository.findAll();
        return Lists.newArrayList(improvedMusics);
    }

    public ImprovedMusic createImprovedMusic(final ImprovedMusicId improvedMusicId) {
        return improvedMusicRepository.save(new ImprovedMusic(improvedMusicId));
    }

    public ImprovedMusic getImprovedMusic(final String artist, final String songTitle) {
        Optional<ImprovedMusic> improvedMusicOptional = improvedMusicRepository.findById(new ImprovedMusicId(artist, songTitle));
        return improvedMusicOptional.get();
    }
}