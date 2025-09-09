package com.example.firstApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstApi.entities.UserEntity;

public interface  UserRepository extends JpaRepository<UserEntity, Long>{
    
}