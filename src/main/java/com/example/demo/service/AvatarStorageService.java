package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.InputStream;

@Service
public interface AvatarStorageService {
    @Transactional
    void save(String username, String contentType, InputStream is);
}
