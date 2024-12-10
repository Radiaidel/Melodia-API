package com.aidar.Melodia_API.dto.response;

import com.aidar.Melodia_API.dto.embedded.RoleEmbeddedDTO;

import java.util.List;

public class UserResponseDTO {
    private String id;
    private String login;
    private Boolean active;
    private List<RoleEmbeddedDTO> roles;
}
