package com.example.demo.controller;

import com.example.demo.model.Course;

import java.util.List;
import java.util.NoSuchElementException;

public class CourseRepositoryImplementation implements CourseRepository {
    List<Course> listDB;

    public CourseRepositoryImplementation(List<Course> listDB) {
        this.listDB = listDB;
    }


    @Override
    public List<Course> findAll() {
        return listDB;
    }

    @Override
    public Course findById(Long id) {
        if(id < listDB.size() && id >= 0) {
            return listDB.get(id.intValue());
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<Course> findByTitleWithPrefix(String prefix) {
        return null;
    }

    @Override
    public Course save(Course course) {
        try {
            if (listDB.add(course)) {
                return course;
            }
            else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        if(id < listDB.size() && id >= 0) {
            listDB.remove(id.intValue());
        } else {
            throw new NoSuchElementException();
        }
    }

}
