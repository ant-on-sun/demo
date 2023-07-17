package com.example.demo.dto;

import java.sql.Blob;
import java.util.Objects;

public class TestDto {
    private Long id;
    private String type;
    private String title;
    private String description;
    private String dateAuthorCreation;
    private String dateAuthorUpdate;
    private String dateAuthorDeletion;
    private Blob content;
    private Long topicId;

    public TestDto() {
    }

    public TestDto(Long topicId) {
        this.topicId = topicId;
    }

    public TestDto(Long id,
                   String type,
                   String title,
                   String description,
                   String dateAuthorCreation,
                   String dateAuthorUpdate,
                   String dateAuthorDeletion,
                   Blob content,
                   Long topicId) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.dateAuthorCreation = dateAuthorCreation;
        this.dateAuthorUpdate = dateAuthorUpdate;
        this.dateAuthorDeletion = dateAuthorDeletion;
        this.content = content;
        this.topicId = topicId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestDto testDto = (TestDto) o;
        return id.equals(testDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
