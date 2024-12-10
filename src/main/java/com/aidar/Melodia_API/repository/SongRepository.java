package com.aidar.Melodia_API.repository;

import com.aidar.Melodia_API.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
