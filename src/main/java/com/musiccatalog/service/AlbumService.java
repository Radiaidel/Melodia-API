package com.musiccatalog.service;

import com.musiccatalog.dto.AlbumDto;
import com.musiccatalog.exception.ResourceNotFoundException;
import com.musiccatalog.mapper.AlbumMapper;
import com.musiccatalog.model.Album;
import com.musiccatalog.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    public Page<AlbumDto> findAll(Pageable pageable) {
        return albumRepository.findAll(pageable)
                .map(albumMapper::toDto);
    }

    public Page<AlbumDto> findByTitle(String title, Pageable pageable) {
        return albumRepository.findByTitleContainingIgnoreCase(title, pageable)
                .map(albumMapper::toDto);
    }

    public Page<AlbumDto> findByArtist(String artist, Pageable pageable) {
        return albumRepository.findByArtistContainingIgnoreCase(artist, pageable)
                .map(albumMapper::toDto);
    }

    public Page<AlbumDto> findByYear(Integer year, Pageable pageable) {
        return albumRepository.findByYear(year, pageable)
                .map(albumMapper::toDto);
    }

    @Transactional
    public AlbumDto create(AlbumDto albumDto) {
        Album album = albumMapper.toEntity(albumDto);
        Album savedAlbum = albumRepository.save(album);
        return albumMapper.toDto(savedAlbum);
    }

    @Transactional
    public AlbumDto update(String id, AlbumDto albumDto) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not found with id: " + id));
        
        albumMapper.updateEntityFromDto(albumDto, album);
        Album updatedAlbum = albumRepository.save(album);
        return albumMapper.toDto(updatedAlbum);
    }

    @Transactional
    public void delete(String id) {
        if (!albumRepository.existsById(id)) {
            throw new ResourceNotFoundException("Album not found with id: " + id);
        }
        albumRepository.deleteById(id);
    }
}