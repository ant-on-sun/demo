package com.example.demo.service;

import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto findByUsername(String username);
    UserDto changeUsername(String currentUsername, String newUsername);
    UserDto changePassword(UserDto userDto, String password);
    UserDto save(UserDto userDto);
    UserDto createUser(UserDto userDto);
    void deleteById(Long id);

}
