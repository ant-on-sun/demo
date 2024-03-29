package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.requireNonNullElse;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final RoleRepository roleRepository; //For role assign to the user, just for test
    private final UserRepository userRepository; //For role assign to the user, just for test

    @Autowired
    public CourseController(CourseService courseService,
                            RoleRepository roleRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.courseService = courseService;
    }

    @GetMapping("")
    public List<CourseDto> courseTable(HttpSession session) {
        //just for test
        Role role = roleRepository.getReferenceById(2L);
        User user = userRepository.getReferenceById(5L);
        role.getUsers().add(user);
        user.getRoles().add(role);
        roleRepository.save(role);
        //
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable("id") Long id) {
        return courseService.findById(id);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id") Long id,
                             @Valid @RequestBody CourseRequestToUpdate request) {
        CourseDto courseDto = courseService.findById(id);
        courseDto.setTitle(request.getTitle());
        courseDto.setDateAuthorUpdate(request.getAuthor());
        courseService.save(courseDto);
    }

    @GetMapping("/filter")
    public List<CourseDto> getCoursesByTitlePrefix(@RequestParam(name = "titlePrefix", required = false)
                                                            String titlePrefix) {
        return courseService.findByTitleWithPrefix(requireNonNullElse(titlePrefix, ""));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public CourseDto createCourse(@RequestBody CourseRequestToCreate request) {
        CourseDto courseDto = new CourseDto(request.getTitle(), request.getAuthor());
        return courseService.save(courseDto);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @PostMapping("/{courseId}/assign")
    public CourseDto assignUser(@PathVariable("courseId") Long courseId,
                             @RequestParam("userId") Long userId) {
        return courseService.assignUser(courseId, userId);
    }

    @PostMapping("/{courseId}/unassign")
    public CourseDto unassignUser(@PathVariable("courseId") Long courseId,
                               @RequestParam("userId") Long userId) {
        return courseService.unassignUser(courseId, userId);
    }

//    @ExceptionHandler
//    public ResponseEntity<ApiError> noSuchElementExceptionHandler(NoSuchElementException ex) {
//        return new ResponseEntity<ApiError>(new ApiError(ex.getMessage()), HttpStatus.NOT_FOUND);
//    }

}
