package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.errorhandlers.InternalServerError;
import com.example.demo.service.AvatarStorageService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Multipart;
import javax.validation.Valid;
import java.io.IOException;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
    private final AvatarStorageService avatarStorageService;
    private final UserService userService;

    @Autowired
    public ProfileController(AvatarStorageService avatarStorageService, UserService userService) {
        this.avatarStorageService = avatarStorageService;
        this.userService = userService;
    }

    //For testing
    @PreAuthorize("isAuthenticated()") //access for authenticated users only
    @GetMapping("")
    public ModelAndView userProfile() {
        ModelAndView modelAndView = new ModelAndView("user_avatar");
        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()") //access for authenticated users only
    @PutMapping("/{id}")
    public UserDto updateUsernameOrPassword(@PathVariable("id") Long id,
                                  @Valid @RequestBody UserRequestToUpdate request) {
        UserDto userDto = new UserDto();
        userDto.setUsername(request.getUsername());
        if (!request.getNewUsername().isEmpty()) {
            userDto = userService.changeUsername(request.getUsername(), request.getNewUsername());
        }
        if (!request.getPassword().isEmpty()) {
            userDto = userService.changePassword(userDto, request.getPassword());
        }
        return userDto;
    }

    @PreAuthorize("isAuthenticated()") //access for authenticated users only
    @PostMapping("/avatar")
    public String updateAvatarImage(Authentication auth, @RequestParam("avatar") MultipartFile avatar) {
        logger.info("File name {}, file content type {}, file size {}",
                avatar.getOriginalFilename(), avatar.getContentType(), avatar.getSize());
        try {
            avatarStorageService.save(auth.getName(), avatar.getContentType(), avatar.getInputStream());
        } catch (IOException ex) {
            logger.info("", ex);
            throw new InternalServerError("Can't save avatar file on server, IOException: " + ex);
        }
        return "Success";
    }

    @GetMapping("/avatar")
    public ResponseEntity<byte[]> avatarImage(Authentication auth) throws ChangeSetPersister.NotFoundException {
        String contentType = avatarStorageService.getContentTypeByUser(auth.getName())
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        byte[] data = avatarStorageService.getAvatarImageByUser(auth.getName())
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(data);
    }

    @ExceptionHandler
    public ResponseEntity<Void> notFoundExceptionHandler(ChangeSetPersister.NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

}
