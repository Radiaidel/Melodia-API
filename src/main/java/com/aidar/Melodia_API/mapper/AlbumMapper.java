package com.aidar.Melodia_API.mapper;

import com.aidar.Melodia_API.dto.request.AlbumRequestDTO;
import com.aidar.Melodia_API.dto.response.AlbumResponseDTO;
import com.aidar.Melodia_API.entity.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    Album toEntity(AlbumRequestDTO albumRequest);

    AlbumResponseDTO toResponse(Album album);
}
