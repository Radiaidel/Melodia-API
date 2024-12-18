package com.musiccatalog.repository;

import com.musiccatalog.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
    Page<Album> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Album> findByArtistContainingIgnoreCase(String artist, Pageable pageable);
    Page<Album> findByYear(Integer year, Pageable pageable);
}