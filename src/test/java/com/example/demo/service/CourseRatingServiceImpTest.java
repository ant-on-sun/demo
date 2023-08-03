package com.example.demo.service;

import com.example.demo.dto.CourseRatingDto;
import com.example.demo.entities.CourseRating;
import com.example.demo.entities.CourseRatingId;
import com.example.demo.repository.CourseRatingRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CourseRatingServiceImpTest {
    static CourseRatingServiceImp courseRatingServiceImp;
    static CourseRatingRepository courseRatingRepositoryMock;
    static CourseRatingId courseRatingId1 = new CourseRatingId(1L, 1L);
    static CourseRatingId courseRatingId2 = new CourseRatingId(1L, 2L);
    static CourseRatingId courseRatingId3 = new CourseRatingId(2L, 3L);
    static CourseRatingId courseRatingId4 = new CourseRatingId(3L, 2L);
    static CourseRating courseRating1 = new CourseRating(courseRatingId1, 5, 4);
    static CourseRating courseRating2 = new CourseRating(courseRatingId2, 5, 10);
    static CourseRating courseRating3 = new CourseRating(courseRatingId3, 2, 1);
    static CourseRating courseRating4 = new CourseRating(courseRatingId4, 2, 5);
    @BeforeAll
    public static void setUp() {

        List<CourseRating> courseRatingList = List.of (courseRating1, courseRating2, courseRating3, courseRating4);
        courseRatingRepositoryMock = Mockito.mock(CourseRatingRepository.class);
        Mockito.when(courseRatingRepositoryMock.findByCourseRatingId_courseId(1L))
                .thenReturn(courseRatingList.stream().filter(c -> c.getCourseRatingId().getCourseId() == 1L)
                .collect(Collectors.toList()));
        Mockito.when(courseRatingRepositoryMock.findByCourseRatingId_userId(2L))
                .thenReturn(courseRatingList.stream().filter(u -> u.getCourseRatingId().getUserId() == 2L)
                .collect(Collectors.toList()));
        Mockito.when(courseRatingRepositoryMock.findByCourseRatingId(courseRatingId4)).thenReturn(courseRating4);
        Mockito.when(courseRatingRepositoryMock.save(courseRating1)).thenReturn(courseRating1);
        Mockito.doNothing().when(courseRatingRepositoryMock).deleteByCourseRatingId(courseRatingId3);
        courseRatingServiceImp = new CourseRatingServiceImp(courseRatingRepositoryMock);
    }

    @Test
    void findAllRatingsOfCourseTest() {
        List<CourseRatingDto> courseRatingDtoListActual = courseRatingServiceImp.findAllRatingsOfCourse(1L);
        List<CourseRatingDto> courseRatingDtoListExpected = List
                .of(new CourseRatingDto(1L, 1L, 5, 4));
        assertEquals(courseRatingDtoListExpected, courseRatingDtoListActual);
    }

    @Test
    void findAllGradesOfUserTest() {
        List<CourseRatingDto> courseRatingDtoListActual = courseRatingServiceImp.findAllGradesOfUser(2L);
        List<CourseRatingDto> courseRatingDtoListExpected = List
                .of(new CourseRatingDto(2L, 3L, 2, 1));
        assertEquals(courseRatingDtoListExpected, courseRatingDtoListActual);
    }

    @Test
    void findByIdTest() {
        CourseRatingDto courseRatingDtoActual = courseRatingServiceImp.findById(3L, 2L);
        CourseRatingDto courseRatingDtoExpected = new CourseRatingDto(3L, 2L, 2, 5);
        assertEquals(courseRatingDtoExpected, courseRatingDtoActual);
        assertEquals(courseRatingDtoExpected.getRating(), courseRatingDtoActual.getRating());
        assertEquals(courseRatingDtoExpected.getGrade(), courseRatingDtoActual.getGrade());
    }

    @Test
    void save() {
        CourseRatingDto courseRatingDto = new CourseRatingDto(1L, 1L, 5, 4);
        courseRatingServiceImp.save(courseRatingDto);
        Mockito.verify(courseRatingRepositoryMock, Mockito.times(1)).save(courseRating1);
    }

    @Test
    void deleteById() {
        courseRatingServiceImp.deleteById(2L, 3L);
        Mockito.verify(courseRatingRepositoryMock, Mockito.times(1))
                .deleteByCourseRatingId(courseRatingId3);
    }
}