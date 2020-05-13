package com.leohoc.dse.application;

import com.leohoc.dse.domain.entity.Music;
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
public class MusicController {

    private static Logger LOGGER = LogManager.getLogger();

    @Autowired
    MusicService musicService;

    @GetMapping("/musics")
    public ResponseEntity listMusics() {

        LOGGER.info("m=listMusics");
        List<Music> musics = musicService.listAllMusic();
        return new ResponseEntity(musics, HttpStatus.OK);
    }

    @PostMapping(value = "/musics", consumes = "application/json")
    public ResponseEntity createMusic(@RequestBody final Music music) {

        LOGGER.info("m=createMusic, music={}", music);
        musicService.createMusic(music);
        return new ResponseEntity(HttpStatus.OK);
    }
}