package com.example.demo.dto;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class ModuleDto {

    private Long id;
    private String title;
    private String description;
    private String dateAuthorCreation;
    private String dateAuthorUpdate;
    private String dateAuthorDeletion;
    private Long courseId;
    private Set<Long> topicIds;

    public ModuleDto() {}

    public ModuleDto(Long courseId) {
        this.courseId = courseId;
    }

    public ModuleDto(Long id,
                     String title,
                     String description,
                     String dateAuthorCreation,
                     String dateAuthorUpdate,
                     String dateAuthorDeletion,
                     Long courseId,
                     Set<Long> topicIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAuthorCreation = dateAuthorCreation;
        this.dateAuthorUpdate = dateAuthorUpdate;
        this.dateAuthorDeletion = dateAuthorDeletion;
        this.courseId = courseId;
        this.topicIds = topicIds;
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
        Date date = new Date();
        this.dateAuthorCreation = dateAuthorCreation + " ( " + date.toString() + " ) ";
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Set<Long> getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(Set<Long> topicIds) {
        this.topicIds = topicIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleDto moduleDto = (ModuleDto) o;
        return id.equals(moduleDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
