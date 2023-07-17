package com.example.demo.service;

import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto findByUsername(String username);
    UserDto save(UserDto userDto);
    void deleteById(Long id);

}
