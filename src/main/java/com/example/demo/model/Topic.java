package com.example.demo.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "topics")
public class Topic {
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
    @Type(type = "org.hibernate.type.BinaryType")
    @Column
    private Blob content;

    @ManyToOne(optional = false)
    private Module module;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Test> tests = new ArrayList<>();

    public Topic() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return id.equals(topic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
