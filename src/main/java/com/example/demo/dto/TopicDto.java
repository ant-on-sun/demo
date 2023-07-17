package com.example.demo.dto;

import java.sql.Blob;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TopicDto {
    private Long id;
    private String title;
    private String description;
    private String dateAuthorCreation;
    private String dateAuthorUpdate;
    private String dateAuthorDeletion;
    private Blob content;
    private Long moduleId;
    private Set<Long> testIds;

    public TopicDto() {
    }

    public TopicDto(Long moduleId) {
        this.moduleId = moduleId;
    }

    public TopicDto(Long id,
                    String title,
                    String description,
                    String dateAuthorCreation,
                    String dateAuthorUpdate,
                    String dateAuthorDeletion,
                    Blob content,
                    Long moduleId,
                    Set<Long> testIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAuthorCreation = dateAuthorCreation;
        this.dateAuthorUpdate = dateAuthorUpdate;
        this.dateAuthorDeletion = dateAuthorDeletion;
        this.content = content;
        this.moduleId = moduleId;
        this.testIds = testIds;
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

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Set<Long> getTestIds() {
        return testIds;
    }

    public void setTestIds(Set<Long> testIds) {
        this.testIds = testIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicDto topicDto = (TopicDto) o;
        return id.equals(topicDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
