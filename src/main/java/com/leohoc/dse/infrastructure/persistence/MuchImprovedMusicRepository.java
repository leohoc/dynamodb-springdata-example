package com.leohoc.dse.infrastructure.persistence;

import com.leohoc.dse.domain.entity.MuchImprovedMusic;
import com.leohoc.dse.domain.entity.MuchImprovedMusicId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

@EnableScan
public interface MuchImprovedMusicRepository extends CrudRepository<MuchImprovedMusic, MuchImprovedMusicId> {
    MuchImprovedMusic findByMusicCode(String musicCode);
    List<MuchImprovedMusic> findByArtist(String artist);
    List<MuchImprovedMusic> findByArtistAndReleaseDateTimeGreaterThan(final String artist, final LocalDateTime startReleaseDateTime);
    List<MuchImprovedMusic> findByArtistAndReleaseDateTimeLessThan(final String artist, final LocalDateTime endReleaseDateTime);
    List<MuchImprovedMusic> findByArtistAndReleaseDateTimeBetween(final String artist, final LocalDateTime startReleaseDateTime, final LocalDateTime endReleaseDateTime);

    Page<MuchImprovedMusic> findByArtistAndReleaseDateTimeBetween(final String artist,
                                                                  final LocalDateTime startReleaseDateTime,
                                                                  final LocalDateTime endReleaseDateTime,
                                                                  final Pageable pageRequest);
}
