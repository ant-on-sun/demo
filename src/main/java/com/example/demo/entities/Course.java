package com.example.demo.entities;

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
    private Set<Module> modules;

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

    public Course(Long id, String title, String description, String dateAuthorCreation,
                  String dateAuthorUpdate, String dateAuthorDeletion, String completionTime,
                  String tag, String category, List<Lesson> lessons, Set<Module> modules,
                  Set<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAuthorCreation = dateAuthorCreation;
        this.dateAuthorUpdate = dateAuthorUpdate;
        this.dateAuthorDeletion = dateAuthorDeletion;
        this.completionTime = completionTime;
        this.tag = tag;
        this.category = category;
        this.lessons = lessons;
        this.modules = modules;
        this.users = users;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAuthorUpdate() {
        return dateAuthorUpdate;
    }

    public void setDateAuthorUpdate(String dateAuthorUpdate) {
        this.dateAuthorUpdate = dateAuthorUpdate;
    }

    public String getDateAuthorDeletion() {
        return dateAuthorDeletion;
    }

    public void setDateAuthorDeletion(String dateAuthorDeletion) {
        this.dateAuthorDeletion = dateAuthorDeletion;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
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
