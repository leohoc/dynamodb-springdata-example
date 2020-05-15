package com.leohoc.dse.infrastructure.persistence;

import com.leohoc.dse.domain.entity.ImprovedMusic;
import com.leohoc.dse.domain.entity.ImprovedMusicId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ImprovedMusicRepository extends CrudRepository<ImprovedMusic, ImprovedMusicId> {
}
