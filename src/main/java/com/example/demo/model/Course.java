package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column(name = "date_author_creation")
    private String dateAuthorCreation;
    @Column(name = "date_author_update")
    private String dateAuthorUpdate;
    @Column(name = "date_author_deletion")
    private String dateAuthorDeletion;
    @Column(name = "completion_time")
    private String completionTime;
    @Column
    private String tag;
    @Column
    private String category;

    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Module> modules = new ArrayList<>();

    @ManyToMany
    private Set<User> users;

    public Course() {
    }
    public Course(String dateAuthorCreation, String title) {
        this.dateAuthorCreation = dateAuthorCreation;
        this.title = title;
    }
    public Course(Long id, String dateAuthorCreation, String title) {
        this.id = id;
        this.dateAuthorCreation = dateAuthorCreation;
        this.title = title;
    }

    public void addLesson(Lesson lesson) {
        lesson.setCourse(this);
        this.lessons.add(lesson);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateAuthorCreation() {
        return dateAuthorCreation;
    }

    public void setDateAuthorCreation(String dateAuthorCreation) {
        this.dateAuthorCreation = dateAuthorCreation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
