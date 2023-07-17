package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Course;
import com.example.demo.repository.UserPrincipalRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserPrincipalRepository userPrincipalRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, UserPrincipalRepository userPrincipalRepository) {
        this.userRepository = userRepository;
        this.userPrincipalRepository = userPrincipalRepository;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtoList = userRepository.findAll().stream()
                .map(u -> new UserDto(
                        u.getId(),
                        u.getNickname(),
                        u.getPassword(),
                        u.getUsername(),
                        u.getEmail(),
                        u.getPhone(),
                        u.getAvatar(),
                        u.getRegistrationDate(),
                        u.getDateAuthorUpdate(),
                        u.getDateAuthorDeletion(),
                        u.getAccessRights(),
                        u.getCommunicationChannels(),
                        u.getAchievements(),
                        u.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                )).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public UserDto findByUsername(String username) {
        return null;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
