package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.model.Course;
import com.example.demo.model.Lesson;
import com.example.demo.model.Module;
import com.example.demo.model.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public CourseServiceImp(CourseRepository courseRepository, UserRepository userRepository,
                            ModuleRepository moduleRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<CourseDto> findAll() {
        List<CourseDto> courses = courseRepository.findAll().stream()
                .map(c -> new CourseDto(c.getId(), c.getTitle(), c.getDescription(),
                        c.getDateAuthorCreation(), c.getDateAuthorUpdate(), c.getDateAuthorDeletion(),
                        c.getCompletionTime(), c.getTag(), c.getCategory(),
                        c.getModules().stream().map(Module::getId).collect(Collectors.toSet()),
                        c.getUsers().stream().map(User::getId).collect(Collectors.toSet())))
                .collect(Collectors.toList());
        return courses;
    }

    @Override
    public CourseDto findById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        Course course = optionalCourse.orElseThrow();
        CourseDto courseDto = new CourseDto(course.getId(), course.getTitle(), course.getDescription(),
                course.getDateAuthorCreation(), course.getDateAuthorUpdate(), course.getDateAuthorDeletion(),
                course.getCompletionTime(), course.getTag(), course.getCategory(),
                course.getModules().stream().map(Module::getId).collect(Collectors.toSet()),
                course.getUsers().stream().map(User::getId).collect(Collectors.toSet()));
        return courseDto;
    }

    @Override
    public List<CourseDto> findByTitleWithPrefix(String prefix) {
        List<CourseDto> courses = courseRepository.findByTitleLike(prefix + "%").stream()
                .map(c -> new CourseDto(c.getId(), c.getTitle(), c.getDescription(),
                        c.getDateAuthorCreation(), c.getDateAuthorUpdate(), c.getDateAuthorDeletion(),
                        c.getCompletionTime(), c.getTag(), c.getCategory(),
                        c.getModules().stream().map(Module::getId).collect(Collectors.toSet()),
                        c.getUsers().stream().map(User::getId).collect(Collectors.toSet())))
                .collect(Collectors.toList());
        return courses;
    }

    @Override
    public CourseDto save(CourseDto courseDto) {
        Course course;
        if (courseDto.getId() == null) { //create course
            course = new Course();
            courseDto.setId(course.getId());
        } else { //update course
            course = courseRepository.findById(courseDto.getId()).orElseThrow();
        }
        if (!courseDto.getTitle().equalsIgnoreCase(course.getTitle())) {
            course.setTitle(courseDto.getTitle());
        }
        if (!courseDto.getDescription().equalsIgnoreCase(course.getDescription())) {
            course.setDescription(courseDto.getDescription());
        }
        if (!courseDto.getCompletionTime().equalsIgnoreCase(course.getCompletionTime())) {
            course.setCompletionTime(courseDto.getCompletionTime());
        }
        if (!courseDto.getTag().equalsIgnoreCase(course.getTag())) {
            course.setTag(courseDto.getTag());
        }
        if (!courseDto.getModuleIds().isEmpty()) {
            for (Long id : courseDto.getModuleIds()) {
                if (!course.getModules().stream()
                        .map(m -> m.getId()).collect(Collectors.toSet()).contains(id)) {
                    course.getModules().add(moduleRepository.getReferenceById(id));
                }
            }
        }
        if (!courseDto.getUserIds().isEmpty()) {
            for (Long id : courseDto.getUserIds()) {
                if (!course.getUsers().stream()
                .map(u -> u.getId()).collect(Collectors.toSet()).contains(id)) {
                    course.getUsers().add(userRepository.getReferenceById(id));
                }
            }
        }
        courseRepository.save(course);
        return courseDto;
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDto assignUser(Long courseId, Long userId) {
        User user = userRepository.getReferenceById(userId);
        Course course = courseRepository.getReferenceById(courseId);
        user.getCourses().add(course);
        course.getUsers().add(user);
        courseRepository.save(course);
        CourseDto courseDto = new CourseDto(course.getId(), course.getTitle(), course.getDescription(),
                course.getDateAuthorCreation(), course.getDateAuthorUpdate(), course.getDateAuthorDeletion(),
                course.getCompletionTime(), course.getTag(), course.getCategory(),
                course.getModules().stream().map(Module::getId).collect(Collectors.toSet()),
                course.getUsers().stream().map(User::getId).collect(Collectors.toSet()));
        return courseDto;
    }

    @Override
    public CourseDto unassignUser(Long courseId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        user.getCourses().remove(course);
        course.getUsers().remove(user);
        courseRepository.save(course);
        CourseDto courseDto = new CourseDto(course.getId(), course.getTitle(), course.getDescription(),
                course.getDateAuthorCreation(), course.getDateAuthorUpdate(), course.getDateAuthorDeletion(),
                course.getCompletionTime(), course.getTag(), course.getCategory(),
                course.getModules().stream().map(Module::getId).collect(Collectors.toSet()),
                course.getUsers().stream().map(User::getId).collect(Collectors.toSet()));
        return courseDto;
    }


}
