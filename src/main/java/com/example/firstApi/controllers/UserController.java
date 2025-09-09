package com.example.firstApi.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstApi.Repositories.UserRepository;
import com.example.firstApi.entities.UserEntity;
import com.example.firstApi.exceptions.ResponseNotFoundException;
import com.example.firstApi.models.User;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<UserEntity> listuser(){
        return userRepository.findAll();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() ->new ResponseNotFoundException("User not Found"));
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@RequestBody UserEntity user,@PathVariable Long id){
        UserEntity userdata =  userRepository.findById(id).orElseThrow(() -> new ResponseNotFoundException("User not Found"));

        userdata.setEmail(user.getEmail());
        userdata.setName(user.getName());
        return userRepository.save(userdata);
    
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        UserEntity userdata = userRepository.findById(id).orElseThrow(() -> new ResponseNotFoundException("User not found"));

        userRepository.delete(userdata);

        return ResponseEntity.ok().build();
    }
}
