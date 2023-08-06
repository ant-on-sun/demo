package com.example.demo.repository;

import com.example.demo.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("from Topic t where t.title = :title")
    Optional<Topic> findByTitle(@Param("title") String title);
    @Query("from Topic t where t.id = :id")
    Optional<Topic> findById(@Param("id") Long id);
    @Modifying
    @Query("delete from Topic t where t.id = :id")
    void deleteById(@Param("id") Long id);
}
