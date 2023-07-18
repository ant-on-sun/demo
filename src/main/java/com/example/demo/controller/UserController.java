package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public List<UserDto> getAllUsers(HttpSession session) {
        return userService.findAll();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id,
                           @Valid @RequestBody UserRequestToUpdate request) {
        UserDto userDto = userService.findById(id);
        userDto.setUsername(request.getUsername());
        userDto.setDateAuthorUpdate(request.getAuthor());
        userService.save(userDto);
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserRequestToCreate request) {
        UserDto userDto = new UserDto();
        userDto.setUsername(request.getUsername());
        userDto.setPassword(request.getPassword());
        userDto.setEmail(request.getEmail());
        Date date = new Date();
        userDto.setRegistrationDate(date.toString());
        return userService.save(userDto);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
