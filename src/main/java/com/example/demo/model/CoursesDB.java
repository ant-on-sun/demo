package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoursesDB {

    private List<Course> coursesDB;

    public CoursesDB(List<Course> coursesDB) {
        this.coursesDB = coursesDB;
    }

    public List<Course> getCoursesDB() {
        return coursesDB;
    }

    public void setCoursesDB(List<Course> coursesDB) {
        this.coursesDB = coursesDB;
    }

}
