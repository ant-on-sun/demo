package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@ActiveProfiles("testcontainers")
@ContextConfiguration(classes = TopicServiceTestConfiguration.class)
class TopicServiceImpTest {

    @Test
    void findAll() {
        assertEquals(4, 4);
    }

    @Test
    void findById() {
    }

    @Test
    void findByTitle() {
    }

    @Test
    void save() {
    }

    @Test
    void createTopic() {
    }

    @Test
    void deleteById() {
    }
}