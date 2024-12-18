package com.musiccatalog.mapper;

import com.musiccatalog.dto.SongDto;
import com.musiccatalog.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SongMapper {

    SongDto toDto(Song song);

    Song toEntity(SongDto songDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(SongDto songDto, @MappingTarget Song song);
}