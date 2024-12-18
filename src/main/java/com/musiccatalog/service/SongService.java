package com.musiccatalog.service;

import com.musiccatalog.dto.SongDto;
import com.musiccatalog.exception.ResourceNotFoundException;
import com.musiccatalog.mapper.SongMapper;
import com.musiccatalog.model.Song;
import com.musiccatalog.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public Page<SongDto> findAll(Pageable pageable) {
        return songRepository.findAll(pageable)
                .map(songMapper::toDto);
    }

    public Page<SongDto> findByTitle(String title, Pageable pageable) {
        return songRepository.findByTitleContainingIgnoreCase(title, pageable)
                .map(songMapper::toDto);
    }

    public Page<SongDto> findByAlbumId(String albumId, Pageable pageable) {
        return songRepository.findByAlbumId(albumId, pageable)
                .map(songMapper::toDto);
    }

    @Transactional
    public SongDto create(SongDto songDto) {
        Song song = songMapper.toEntity(songDto);
        Song savedSong = songRepository.save(song);
        return songMapper.toDto(savedSong);
    }

    @Transactional
    public SongDto update(String id, SongDto songDto) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id: " + id));

        songMapper.updateEntityFromDto(songDto, song);
        Song updatedSong = songRepository.save(song);
        return songMapper.toDto(updatedSong);
    }

    @Transactional
    public void delete(String id) {
        if (!songRepository.existsById(id)) {
            throw new ResourceNotFoundException("Song not found with id: " + id);
        }
        songRepository.deleteById(id);
    }
}