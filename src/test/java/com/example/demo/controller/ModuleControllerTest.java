package com.example.demo.controller;

import com.example.demo.security.SecurityConfiguration;
import com.example.demo.security.SecurityServiceConfig;
import com.example.demo.security.UserAuthService;
import com.example.demo.security.WebSecurityConfiguration;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseServiceImp;
import com.example.demo.service.ModuleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ModuleController.class)
@Import({SecurityServiceConfig.class})
class ModuleControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @MockBean
    private ModuleService moduleService;
    @MockBean
    private SecurityConfiguration securityConfiguration;

    @Test
    void getAllModules() {
    }

    @Test
    void getModule() {
    }

//    @Test
//    //@WithMockUser(value = "admin", password = "123", roles = {"ADMIN"})
//    void updateModuleTest() throws Exception {
//        ModuleRequestToUpdate moduleRequestToUpdate = new ModuleRequestToUpdate();
//        moduleRequestToUpdate.setTitle("Java course for dummies");
//        moduleRequestToUpdate.setAuthor("Great Ozz");
//
//        mockMvc.perform(post("/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(moduleRequestToUpdate))
//        )
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//
//        verify(moduleService, times(1));
//    }

    @Test
    void createModule() {
    }

    @Test
    void deleteModule() {
    }
}