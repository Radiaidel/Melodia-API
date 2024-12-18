package com.musiccatalog.controller;

import com.musiccatalog.dto.AlbumDto;
import com.musiccatalog.service.AlbumService;
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
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/user/albums")
    public ResponseEntity<Page<AlbumDto>> getAllAlbums(Pageable pageable) {
        return ResponseEntity.ok(albumService.findAll(pageable));
    }

    @GetMapping("/user/albums/search/title")
    public ResponseEntity<Page<AlbumDto>> searchByTitle(
            @RequestParam String title,
            Pageable pageable) {
        return ResponseEntity.ok(albumService.findByTitle(title, pageable));
    }

    @GetMapping("/user/albums/search/artist")
    public ResponseEntity<Page<AlbumDto>> searchByArtist(
            @RequestParam String artist,
            Pageable pageable) {
        return ResponseEntity.ok(albumService.findByArtist(artist, pageable));
    }

    @GetMapping("/user/albums/search/year")
    public ResponseEntity<Page<AlbumDto>> searchByYear(
            @RequestParam Integer year,
            Pageable pageable) {
        return ResponseEntity.ok(albumService.findByYear(year, pageable));
    }

    @PostMapping("/admin/albums")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AlbumDto> createAlbum(@Valid @RequestBody AlbumDto albumDto) {
        return ResponseEntity.ok(albumService.create(albumDto));
    }

    @PutMapping("/admin/albums/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AlbumDto> updateAlbum(
            @PathVariable String id,
            @Valid @RequestBody AlbumDto albumDto) {
        return ResponseEntity.ok(albumService.update(id, albumDto));
    }

    @DeleteMapping("/admin/albums/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAlbum(@PathVariable String id) {
        albumService.delete(id);
        return ResponseEntity.noContent().build();
    }
}