package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.sql.Blob;
import org.hibernate.annotations.Type;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

    @ManyToMany
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private AvatarImage avatarImage;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(Long id,
                String nickname,
                String password,
                String username,
                String email,
                String phone,
                Blob avatar,
                String registrationDate,
                String dateAuthorUpdate,
                String dateAuthorDeletion,
                String accessRights,
                String communicationChannels,
                String achievements,
                Set<Course> courses) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.registrationDate = registrationDate;
        this.dateAuthorUpdate = dateAuthorUpdate;
        this.dateAuthorDeletion = dateAuthorDeletion;
        this.accessRights = accessRights;
        this.communicationChannels = communicationChannels;
        this.achievements = achievements;
        this.courses = courses;
    }

    public <R> User(String username, String password, List<SimpleGrantedAuthority> roles) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
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

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public String getCommunicationChannels() {
        return communicationChannels;
    }

    public void setCommunicationChannels(String communicationChannels) {
        this.communicationChannels = communicationChannels;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
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
