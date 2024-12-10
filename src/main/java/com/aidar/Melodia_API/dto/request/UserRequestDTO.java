package com.aidar.Melodia_API.dto.request;

import java.util.List;

public class UserRequestDTO {
    private String login;
    private String password;
    private Boolean active;
    private List<String> roleIds;
}
