package com.aidar.Melodia_API.mapper;

import com.aidar.Melodia_API.dto.request.UserRequestDTO;
import com.aidar.Melodia_API.dto.response.UserResponseDTO;
import com.aidar.Melodia_API.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO userRequest);

    UserResponseDTO toResponse(User user);
}
