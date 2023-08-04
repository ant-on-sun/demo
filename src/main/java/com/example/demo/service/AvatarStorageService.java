package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.Optional;

@Service
public interface AvatarStorageService {
    @Transactional
    void save(String username, String contentType, InputStream is);

    Optional<String> getContentTypeByUser(String username);

    Optional<byte[]> getAvatarImageByUser(String username);
}
