package com.aidar.Melodia_API.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "songs")
public class Song {

    @Id
    private String id;

    private String title;
    private String albumId;
    private String genre;
    private int duration;
    private Album album;
}
