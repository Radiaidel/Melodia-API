package com.aidar.Melodia_API.mapper;

import com.aidar.Melodia_API.dto.request.SongRequestDTO;
import com.aidar.Melodia_API.dto.response.SongResponseDTO;
import com.aidar.Melodia_API.entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {
    Song toEntity(SongRequestDTO songRequest);

    SongResponseDTO toResponse(Song song);
}
