package com.musiccatalog.service;

import com.musiccatalog.dto.UserDto;
import com.musiccatalog.exception.ResourceNotFoundException;
import com.musiccatalog.mapper.UserMapper;
import com.musiccatalog.model.Role;
import com.musiccatalog.model.User;
import com.musiccatalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);
    }

    @Transactional
    public UserDto updateRoles(String id, Set<String> roles) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        Set<Role> newRoles = roles.stream()
                .map(Role::valueOf)
                .collect(Collectors.toSet());

        user.setRoles(newRoles);
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }
}