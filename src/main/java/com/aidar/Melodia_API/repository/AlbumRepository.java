package com.aidar.Melodia_API.repository;

import com.aidar.Melodia_API.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
