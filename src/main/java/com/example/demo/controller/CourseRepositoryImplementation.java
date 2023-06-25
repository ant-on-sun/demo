package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public abstract class CourseRepositoryImplementation implements CourseRepository {
//    List<Course> listDB;
//
//    @Autowired
//    public CourseRepositoryImplementation(List<Course> listDB) {
//        this.listDB = listDB;
//    }
//
//
//    @Override
//    public List<Course> findAll() {
//        return listDB;
//    }
//
//    @Override
//    public Course findById(Long id) {
//        if(id <= listDB.size() && id > 0) {
//            return listDB.get(id.intValue() - 1);
//        } else {
//            throw new NoSuchElementException();
//        }
//    }
//
//    @Override
//    public List<Course> findByTitleWithPrefix(String prefix) {
//        return listDB.stream()
//                .filter(course -> course.getTitle().startsWith(prefix))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Course save(Course course) {
//        try {
//            if (listDB.add(course)) {
//                course.setId((long) listDB.size());
//                return course;
//            }
//            else {
//                return null;
//            }
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        if(id <= listDB.size() && id > 0) {
//            listDB.remove(id.intValue() - 1);
//        } else {
//            throw new NoSuchElementException();
//        }
//    }

}
