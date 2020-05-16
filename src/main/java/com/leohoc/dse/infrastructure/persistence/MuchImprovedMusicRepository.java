package com.leohoc.dse.infrastructure.persistence;

import com.leohoc.dse.domain.entity.MuchImprovedMusic;
import com.leohoc.dse.domain.entity.MuchImprovedMusicId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MuchImprovedMusicRepository extends CrudRepository<MuchImprovedMusic, MuchImprovedMusicId> {
    MuchImprovedMusic findByMusicCode(String musicCode);
}
