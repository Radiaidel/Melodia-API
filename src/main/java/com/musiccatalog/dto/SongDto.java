package com.musiccatalog.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
    public class SongDto {
    private String id;
    
    @NotBlank(message = "Title is required")
    private String title;
    
    @Min(value = 1, message = "Duration must be positive")
    private Integer duration;
    
    @NotNull(message = "Track number is required")
    @Min(value = 1, message = "Track number must be positive")
    private Integer trackNumber;
    
    private String albumId;
}