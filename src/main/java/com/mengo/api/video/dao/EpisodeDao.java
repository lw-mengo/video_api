package com.mengo.api.video.dao;

import com.mengo.api.video.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeDao extends JpaRepository<Episode,Integer> {
    List<Episode> findByBid(String bid);
}
