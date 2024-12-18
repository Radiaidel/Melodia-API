package com.musiccatalog.mapper;

import com.musiccatalog.dto.AlbumDto;
import com.musiccatalog.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AlbumMapper {
    
    AlbumDto toDto(Album album);
    
    @Mapping(target = "songs", ignore = true)
    Album toEntity(AlbumDto albumDto);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "songs", ignore = true)
    void updateEntityFromDto(AlbumDto albumDto, @MappingTarget Album album);
}