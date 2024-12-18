package com.musiccatalog.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import java.util.List;

@Data
public class AlbumDto {
    private String id;
    
    @NotBlank(message = "Title is required")
    private String title;
    
    @NotBlank(message = "Artist is required")
    private String artist;
    
    @Min(value = 1900, message = "Year must be after 1900")
    private Integer year;
    
    private List<String> songIds;
}