package com.example.demo.dto;

import java.util.Objects;

public class AvatarImageDto {

    private Long id;
    private String contentType;
    private String filename;
    private Long userId;

    public AvatarImageDto() {
    }

    public AvatarImageDto(Long id, String contentType, String filename, Long userId) {
        this.id = id;
        this.contentType = contentType;
        this.filename = filename;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvatarImageDto avatarImageDto = (AvatarImageDto) o;
        return id.equals(avatarImageDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
