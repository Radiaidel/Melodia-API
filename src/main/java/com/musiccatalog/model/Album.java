package com.musiccatalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "albums")
public class Album {
    @Id
    private String id;
    private String title;
    private String artist;
    private Integer year;
    
    @DBRef
    private List<Song> songs = new ArrayList<>();
}