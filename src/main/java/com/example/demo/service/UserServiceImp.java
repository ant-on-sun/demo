package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.errorhandlers.UserAlreadyExistException;
import com.example.demo.model.Course;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserPrincipalRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
                .map(u -> userToUserDto(u)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userToUserDto(user);
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return userToUserDto(user);
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user;
        Optional<User> userRepo = userRepository.findByUsername(userDto.getUsername());
        if (userRepo.isEmpty()) { //new user creation
            user = userDtoToEnrichUser(userDto, new User());
        } else { //update user
            user = userDtoToEnrichUser(userDto, userRepo.get());
        }
        User userSaved = userRepository.save(user);
        return userToUserDto(userSaved);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> userRepo = userRepository.findByUsername(userDto.getUsername());
        if (userRepo.isPresent()) {
            throw new UserAlreadyExistException("User with such username already exist. Try another username.");
        }
        return save(userDto);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNickname(user.getNickname());
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAvatar(user.getAvatar());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setDateAuthorUpdate(user.getDateAuthorUpdate());
        userDto.setDateAuthorDeletion(user.getDateAuthorDeletion());
        userDto.setAccessRights(user.getAccessRights());
        userDto.setCommunicationChannels(user.getCommunicationChannels());
        userDto.setAchievements(user.getAchievements());
        if (user.getCourses() != null) {
            userDto.setCourseIds(user.getCourses().stream().map(Course::getId).collect(Collectors.toSet()));
        }
        if (user.getRoles() != null) {
            userDto.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        }
        return userDto;
    }

    private User userDtoToEnrichUser(UserDto userDto, User user) {
        if (userDto.getNickname() !=null && !userDto.getNickname().isEmpty()) {
            user.setNickname(userDto.getNickname());
        }
        if (userDto.getPassword() !=null && !userDto.getPassword().isEmpty()) {
            user.setPassword(userDto.getPassword());
        }
        if (userDto.getUsername() !=null && !userDto.getUsername().isEmpty()) {
            user.setUsername(userDto.getUsername());
        }
        if (userDto.getEmail() !=null && !userDto.getEmail().isEmpty()) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPhone() !=null && !userDto.getPhone().isEmpty()) {
            user.setPhone(userDto.getPhone());
        }
        long l = 0;
        try {
            if (userDto.getAvatar() != null) {
                l = userDto.getAvatar().length();
            }
        } catch (SQLException e) {
            //TO DO logging
            //e.printStackTrace();
        }
        if (l > 0) {
            user.setAvatar(userDto.getAvatar());
        }
        if (userDto.getRegistrationDate() !=null && !userDto.getRegistrationDate().isEmpty()) {
            user.setRegistrationDate(userDto.getRegistrationDate());
        }
        if (userDto.getDateAuthorUpdate() !=null && !userDto.getDateAuthorUpdate().isEmpty()) {
            user.setDateAuthorUpdate(userDto.getDateAuthorUpdate());
        }
        if (userDto.getDateAuthorDeletion() !=null && !userDto.getDateAuthorDeletion().isEmpty()) {
            user.setDateAuthorDeletion(userDto.getDateAuthorDeletion());
        }
        if (userDto.getAccessRights() !=null && !userDto.getAccessRights().isEmpty()) {
            user.setAccessRights(userDto.getAccessRights());
        }
        if (userDto.getCommunicationChannels() !=null && !userDto.getCommunicationChannels().isEmpty()) {
            user.setCommunicationChannels(userDto.getCommunicationChannels());
        }
        if (userDto.getAchievements() !=null && !userDto.getAchievements().isEmpty()) {
            user.setAchievements(userDto.getAchievements());
        }
        return user;
    }

}
