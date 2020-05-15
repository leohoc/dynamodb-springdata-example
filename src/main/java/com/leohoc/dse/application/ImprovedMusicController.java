package com.leohoc.dse.application;

import com.leohoc.dse.domain.entity.ImprovedMusic;
import com.leohoc.dse.domain.entity.ImprovedMusicId;
import com.leohoc.dse.domain.entity.Music;
import com.leohoc.dse.service.ImprovedMusicService;
import com.leohoc.dse.service.MusicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImprovedMusicController {

    private static Logger LOGGER = LogManager.getLogger();

    @Autowired
    ImprovedMusicService improvedMusicService;

    @GetMapping("/improved-musics")
    public ResponseEntity listImprovedMusics() {

        LOGGER.info("m=listImprovedMusics");
        List<ImprovedMusic> improvedMusics = improvedMusicService.listAllImprovedMusics();
        return new ResponseEntity(improvedMusics, HttpStatus.OK);
    }

    @PostMapping(value = "/improved-musics", consumes = "application/json")
    public ResponseEntity createImprovedMusic(@RequestBody final ImprovedMusicId improvedMusicId) {

        LOGGER.info("m=createImprovedMusic, improvedMusic={}", improvedMusicId);
        improvedMusicService.createImprovedMusic(improvedMusicId);
        return new ResponseEntity(HttpStatus.OK);
    }
}