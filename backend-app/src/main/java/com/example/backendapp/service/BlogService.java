package com.example.backendapp.service;

import com.example.backendapp.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> getAllBlogs();

    Optional<Blog> getBlogById(int id);

    List<Blog> getBlogsByTitleContainingOrContentContaining(String titleText, String contentText);

    Blog createBlog(Blog blog);

    Blog updateBlog(Optional<Blog> blog);

    Blog deleteBlog(Blog blog);
}
