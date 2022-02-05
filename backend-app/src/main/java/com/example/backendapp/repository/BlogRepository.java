package com.example.backendapp.repository;

import com.example.backendapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

    Optional<Blog> findById(int id);
}
