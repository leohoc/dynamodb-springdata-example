package com.leohoc.dse.application;

import com.leohoc.dse.domain.dto.MuchImprovedMusicDTO;
import com.leohoc.dse.domain.entity.MuchImprovedMusic;
import com.leohoc.dse.service.MuchImprovedMusicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class MuchImprovedMusicController {

    private static Logger LOGGER = LogManager.getLogger();

    @Autowired
    MuchImprovedMusicService muchImprovedMusicService;

    @PostMapping(value = "/much-improved-musics", consumes = "application/json")
    public ResponseEntity createMuchImprovedMusic(@RequestBody final MuchImprovedMusicDTO muchImprovedMusicDTO) {

        LOGGER.info("m=createImprovedMusic, muchImprovedMusicDTO={}", muchImprovedMusicDTO);

        MuchImprovedMusic muchImprovedMusic = muchImprovedMusicService.createMuchImprovedMusic(
                UUID.randomUUID(),
                LocalDateTime.now(),
                muchImprovedMusicDTO.getArtist(),
                muchImprovedMusicDTO.getSongTitle());

        return new ResponseEntity(muchImprovedMusic, HttpStatus.OK);
    }

    @GetMapping("/much-improved-musics/{musicCode}")
    public ResponseEntity getMuchImprovedMusic(@PathVariable(value = "musicCode") final String musicCode) {

        LOGGER.info("m=getMuchImprovedMusic, musicCode={}", musicCode);

        MuchImprovedMusic muchImprovedMusic = muchImprovedMusicService.getMuchImprovedMusic(musicCode);
        return new ResponseEntity(muchImprovedMusic, HttpStatus.OK);
    }

    @GetMapping("/much-improved-musics")
    public ResponseEntity listAllMuchImprovedMusics(
                @RequestParam(value = "artist", required = false) final String artist,
                @RequestParam(value = "startReleaseDateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime startReleaseDateTime,
                @RequestParam(value = "endReleaseDateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime endReleaseDateTime,
                @RequestParam(value = "page", required = false, defaultValue = "0") final Integer page) {

        LOGGER.info("m=listAllMuchImprovedMusics, artist={}, startReleaseDateTime={}, endReleaseDateTime={}, page={}", artist, startReleaseDateTime, endReleaseDateTime, page);
        List<MuchImprovedMusic> muchImprovedMusics;

        if (artist == null) {
            muchImprovedMusics = muchImprovedMusicService.listAllMuchImprovedMusics();
        } else {
            muchImprovedMusics = muchImprovedMusicService.listArtistMusics(artist, startReleaseDateTime, endReleaseDateTime, page);
        }

        return new ResponseEntity(muchImprovedMusics, HttpStatus.OK);
    }
}