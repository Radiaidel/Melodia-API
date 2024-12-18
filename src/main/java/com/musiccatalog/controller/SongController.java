package com.musiccatalog.controller;

import com.musiccatalog.dto.SongDto;
import com.musiccatalog.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/user/songs")
    public ResponseEntity<Page<SongDto>> getAllSongs(Pageable pageable) {
        return ResponseEntity.ok(songService.findAll(pageable));
    }

    @GetMapping("/user/songs/search/title")
    public ResponseEntity<Page<SongDto>> searchByTitle(
            @RequestParam String title,
            Pageable pageable) {
        return ResponseEntity.ok(songService.findByTitle(title, pageable));
    }

    @GetMapping("/user/songs/album/{albumId}")
    public ResponseEntity<Page<SongDto>> getSongsByAlbum(
            @PathVariable String albumId,
            Pageable pageable) {
        return ResponseEntity.ok(songService.findByAlbumId(albumId, pageable));
    }

    @PostMapping("/admin/songs")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SongDto> createSong(@Valid @RequestBody SongDto songDto) {
        return ResponseEntity.ok(songService.create(songDto));
    }

    @PutMapping("/admin/songs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SongDto> updateSong(
            @PathVariable String id,
            @Valid @RequestBody SongDto songDto) {
        return ResponseEntity.ok(songService.update(id, songDto));
    }

    @DeleteMapping("/admin/songs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteSong(@PathVariable String id) {
        songService.delete(id);
        return ResponseEntity.noContent().build();
    }
}