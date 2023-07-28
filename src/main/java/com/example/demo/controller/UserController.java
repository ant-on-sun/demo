package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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
    public ModelAndView getUser(@PathVariable("id") Long id) {
        UserDto userDto = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView("user_form");
        modelAndView.addObject("user", userDto);
        return modelAndView;
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
    public ModelAndView createUser(@Valid @RequestBody UserRequestToCreate request) {
        UserDto userDto = new UserDto();
        userDto.setUsername(request.getUsername());
        userDto.setPassword(request.getPassword());
        userDto.setEmail(request.getEmail());
        Date date = new Date();
        userDto.setRegistrationDate(date.toString());
        ModelAndView modelAndView = new ModelAndView("redirect:/user_card");
        //modelAndView.setStatus(HttpStatus.PERMANENT_REDIRECT);
        //modelAndView.addObject("user", userDto);
        UserDto userDtoCreated = userService.createUser(userDto);
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
