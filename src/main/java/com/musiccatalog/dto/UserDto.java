package com.musiccatalog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Set;
import com.musiccatalog.model.Role;

@Data
public class UserDto {
    private String id;

    @NotBlank(message = "login is required")
    private String login;
    
    @NotBlank(message = "Password is required")
    private String password;
    
    private boolean active;
    private Set<Role> roles;
}