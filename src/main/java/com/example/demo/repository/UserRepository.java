package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u " +
            "where u.id not in ( " +
                "select u.id " +
                "from User u " +
                "left join u.courses c " +
                "where c.id = :courseId)")
    List<User> findUsersNotAssignedToCourse(@Param("courseId") long courseId);

    Optional<User> findByUsername(String username);

}
