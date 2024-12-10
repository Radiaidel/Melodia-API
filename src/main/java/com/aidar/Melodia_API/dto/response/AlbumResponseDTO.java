package com.aidar.Melodia_API.dto.response;

import com.aidar.Melodia_API.dto.embedded.SongEmbeddedDTO;

import java.util.List;

public class AlbumResponseDTO {
    private String id;
    private String title;
    private String artist;
    private Integer year;
    private List<SongEmbeddedDTO> songs;
}
