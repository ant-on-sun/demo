package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private UserService userService;

    @Test
    void getAllUsers() {
    }

    @Test
    @WithMockUser(value = "admin", password = "123", roles = {"ADMIN"})
    void getUserTest() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("TestUsername");
        userDto.setPassword("TestPassword");
        UserDto savedUserDto = userService.save(userDto);
        mvc.perform(MockMvcRequestBuilders.get("/admin/user/" + savedUserDto.getId()).with(csrf()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user_form"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", new BaseMatcher<UserDto>() {
                    @Override
                    public void describeTo(Description description) {
                    }

                    @Override
                    public boolean matches(Object o) {
                        if (o instanceof UserDto) {
                            UserDto userDtoFromRepo = (UserDto) o;
                            return userDtoFromRepo.getId().equals(savedUserDto.getId());
                        }
                        return false;
                    }
                }));
    }

    @Test
    void updateUser() {
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteUser() {
    }
}