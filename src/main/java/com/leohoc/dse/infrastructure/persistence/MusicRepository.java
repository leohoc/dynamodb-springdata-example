package com.leohoc.dse.infrastructure.persistence;

import com.leohoc.dse.domain.entity.Music;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MusicRepository extends CrudRepository<Music, String> {
}
