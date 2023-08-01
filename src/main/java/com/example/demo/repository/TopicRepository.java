package com.example.demo.repository;

import com.example.demo.model.Module;
import com.example.demo.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("from Topic t where t.title = :title")
    Optional<Topic> findByTitle(@Param("title") String title);
}
