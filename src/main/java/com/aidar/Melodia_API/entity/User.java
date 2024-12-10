package com.aidar.Melodia_API.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String id;  // Identifiant unique du document

    private String username;
    private String password;
    private String email;
    private List<Role> role;
}
