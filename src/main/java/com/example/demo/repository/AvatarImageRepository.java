package com.example.demo.repository;

import com.example.demo.entities.AvatarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvatarImageRepository extends JpaRepository<AvatarImage, Long> {
//    @Query("select a " +
//            "from AvatarImage a, User u " +
//            "where u.username = :username " +
//                "and a.user_id = u.id")
    @Query("select a " +
            "from AvatarImage a, User u " +
            "where a.user.username = :username")
    Optional<AvatarImage> findByUsername(@Param("username") String username);
}
