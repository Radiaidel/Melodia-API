package com.aidar.Melodia_API.repository;

import com.aidar.Melodia_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
