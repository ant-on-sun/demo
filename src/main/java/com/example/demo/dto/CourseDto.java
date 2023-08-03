package com.example.demo.dto;

import java.util.Objects;
import java.util.Set;

public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private String dateAuthorCreation;
    private String dateAuthorUpdate;
    private String dateAuthorDeletion;
    private String completionTime;
    private String tag;
    private String category;
    private Set<Long> moduleIds;
    private Set<Long> userIds;

    public CourseDto() {
    }

    public CourseDto(String title, String dateAuthorCreation) {
        this.title = title;
        this.dateAuthorCreation = dateAuthorCreation;
    }

    public CourseDto(Long id,
                     String title,
                     String description,
                     String dateAuthorCreation,
                     String dateAuthorUpdate,
                     String dateAuthorDeletion,
                     String completionTime,
                     String tag,
                     String category,
                     Set<Long> moduleIds,
                     Set<Long> userIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAuthorCreation = dateAuthorCreation;
        this.dateAuthorUpdate = dateAuthorUpdate;
        this.dateAuthorDeletion = dateAuthorDeletion;
        this.completionTime = completionTime;
        this.tag = tag;
        this.category = category;
        this.moduleIds = moduleIds;
        this.userIds = userIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAuthorCreation() {
        return dateAuthorCreation;
    }

    public void setDateAuthorCreation(String dateAuthorCreation) {
        this.dateAuthorCreation = dateAuthorCreation;
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

    public Set<Long> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(Set<Long> moduleIds) {
        this.moduleIds = moduleIds;
    }

    public Set<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<Long> userIds) {
        this.userIds = userIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return id.equals(courseDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
