package com.example.demo.service;

import com.example.demo.dto.LessonDto;
import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class LessonServiceImp implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public LessonServiceImp(LessonRepository lessonRepository, CourseRepository courseRepository){
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<LessonDto> findAll(Long courseId) {
        List<LessonDto > lessonDtoList;
//        lessonDtoList = lessonRepository.findAll().stream()
//                .filter(l -> l.getCourse().getId().equals(courseId))
//                .map(l -> new LessonDto(l.getId(), l.getTitle(), l.getText(), l.getCourse().getId()))
//                .collect(Collectors.toList());
        lessonDtoList = lessonRepository.findAllWithProjection();
        return lessonDtoList;
    }

    @Override
    public LessonDto findById(Long id) {
        LessonDto lessonDto = lessonRepository.findById(id)
                .map(l -> new LessonDto(l.getId(), l.getTitle(), l.getText(), l.getCourse().getId())).orElseThrow();
        return lessonDto;
    }

    @Override
    public List<LessonDto> findByTitleWithPrefix(String prefix) {
        return null;
    }

    @Override
    public LessonDto save(@NotNull LessonDto lessonDto) {
        Course course = courseRepository.getReferenceById(lessonDto.getCourseId());
        Lesson lesson;
        if (lessonDto.getId() == null) { //create lesson
            lesson = new Lesson(lessonDto.getTitle(), lessonDto.getText(), course);
            lessonDto.setId(lesson.getId());
        } else { //update lesson
            lesson = new Lesson(lessonDto.getId(), lessonDto.getTitle(), lessonDto.getText(), course);
        }
        lessonRepository.save(lesson);
        return lessonDto;
    }

    @Override
    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }
}
