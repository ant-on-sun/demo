package com.example.demo.repository;

import com.example.demo.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query("from Module m " +
            "where m.title = :title")
    Optional<Module> findByTitle(@Param("title") String title);
}
