package com.musiccatalog.service;

import com.musiccatalog.dto.AuthRequest;
import com.musiccatalog.dto.AuthResponse;
import com.musiccatalog.dto.UserDto;
import com.musiccatalog.mapper.UserMapper;
import com.musiccatalog.model.Role;
import com.musiccatalog.model.User;
import com.musiccatalog.repository.UserRepository;
import com.musiccatalog.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );

        String token = tokenProvider.generateToken(authentication);
        return new AuthResponse(token);
    }

    @Transactional
    public UserDto register(UserDto userDto) {
        if (userRepository.existsByLogin(userDto.getLogin())) {
            throw new RuntimeException("Username is already taken!");
        }

        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);

        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}