package com.example.demo.dto;

import java.sql.Blob;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class UserDto {
    private Long id;
    private String nickname;
    private String password;
    private String username;
    private String email;
    private String phone;
    private Blob avatar;
    private String registrationDate;
    private String dateAuthorUpdate;
    private String dateAuthorDeletion;
    private String accessRights;
    private String communicationChannels;
    private String achievements;
    private Set<Long> courseIds;

    public UserDto() {
    }

    public UserDto(Long id,
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
                   Set<Long> courseIds) {
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
        this.courseIds = courseIds;
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
        Date date = new Date();
        this.dateAuthorUpdate = dateAuthorUpdate + " ( " + date.toString() + " ) ";
    }

    public String getDateAuthorDeletion() {
        return dateAuthorDeletion;
    }

    public void setDateAuthorDeletion(String dateAuthorDeletion) {
        Date date = new Date();
        this.dateAuthorDeletion = dateAuthorDeletion + " ( " + date.toString() + " ) ";
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

    public Set<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(Set<Long> courseIds) {
        this.courseIds = courseIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id.equals(userDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
