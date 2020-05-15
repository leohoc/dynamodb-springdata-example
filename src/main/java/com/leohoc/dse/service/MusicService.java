package com.leohoc.dse.service;

import com.google.common.collect.Lists;
import com.leohoc.dse.domain.entity.Music;
import com.leohoc.dse.infrastructure.persistence.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> listAllMusics() {
        Iterable<Music> musics = musicRepository.findAll();
        return Lists.newArrayList(musics);
    }

    public Music createMusic(final Music music) {
        return musicRepository.save(music);
    }
}