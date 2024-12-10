package com.aidar.Melodia_API.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "albums")
public class Album {

    @Id
    private String id;

    private String title;
    private String artist;
    private int year;
    private List<Song> songs;
}
