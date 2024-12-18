package com.musiccatalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "songs")
public class Song {
    @Id
    private String id;
    private String title;
    private Integer duration;
    private Integer trackNumber;
    private String albumId;
}