package com.example.demo.service;

import com.example.demo.entities.AvatarImage;
import com.example.demo.entities.User;
import com.example.demo.repository.AvatarImageRepository;
import com.example.demo.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

import static java.nio.file.StandardOpenOption.*;

@Service
public class AvatarStorageServiceImp implements AvatarStorageService {

    private static final Logger logger = LoggerFactory.getLogger(AvatarStorageServiceImp.class);

    private final AvatarImageRepository avatarImageRepository;
    private final UserRepository userRepository;

    @Value("${file.storage.path}")
    private String path;

    public AvatarStorageServiceImp(AvatarImageRepository avatarImageRepository, UserRepository userRepository) {
        this.avatarImageRepository = avatarImageRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void save(String username, String contentType, InputStream is) {
        Optional<AvatarImage> opt = avatarImageRepository.findByUsername(username);
        AvatarImage avatarImage;
        String filename;
        if (opt.isEmpty()) {//user has no avatar yet
            filename = UUID.randomUUID().toString();
            User user = userRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new);
            avatarImage = new AvatarImage(null, contentType, filename, user);
        } else { //user has (old) avatar
            avatarImage = opt.get();
            filename = avatarImage.getFilename();
            avatarImage.setContentType(contentType);
        }
        avatarImageRepository.save(avatarImage);

        try (OutputStream os = Files.newOutputStream(Path.of(path, filename), CREATE, WRITE, TRUNCATE_EXISTING)) {
            is.transferTo(os);
        } catch (IOException ex) {
            logger.error("Can't write to file {}", filename, ex);
            throw new IllegalStateException();
        }
    }

    @Override
    public Optional<String> getContentTypeByUser(String username) {
        return avatarImageRepository.findByUsername(username)
                .map(AvatarImage::getContentType);
    }

    @Override
    public Optional<byte[]> getAvatarImageByUser(String username) {
        return avatarImageRepository.findByUsername(username)
                .map(AvatarImage::getFilename)
                .map(filename -> {
                    try {
                        return Files.readAllBytes(Path.of(path, filename));
                    } catch (IOException ex) {
                        logger.error("Can't read file {}", filename, ex);
                        throw new IllegalStateException(ex);
                    }
                });
    }

}
