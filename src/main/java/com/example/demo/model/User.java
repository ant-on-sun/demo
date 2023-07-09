package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.sql.Blob;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nickname;
    @Column
    private String password;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String phone;
    @Type(type = "org.hibernate.type.BinaryType")
    @Column
    private Blob avatar;
    @Column(name = "registration_date")
    private String registrationDate;
    @Column(name = "date_author_update")
    private String dateAuthorUpdate;
    @Column(name = "date_author_deletion")
    private String dateAuthorDeletion;
    @Column(name = "access_rights")
    private String accessRights;
    @Column(name = "communication_channels")
    private String communicationChannels;
    @Column
    private String achievements;

    @ManyToMany(mappedBy = "users")
    private Set<Course> courses;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public void addCourse(Course course) {
        course.getUsers().add(this);
        this.courses.add(course);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
