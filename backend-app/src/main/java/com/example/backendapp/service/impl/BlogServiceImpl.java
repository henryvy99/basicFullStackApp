package com.example.backendapp.service.impl;

import com.example.backendapp.model.Blog;
import com.example.backendapp.repository.BlogRepository;
import com.example.backendapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> getBlogById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> getBlogsByTitleContainingOrContentContaining(String titleText, String contentText) {
        return blogRepository.findByTitleContainingOrContentContaining(titleText, contentText);
    }

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Optional<Blog> blog) {
        return blogRepository.save(blog.get());
    }

    @Override
    public Blog deleteBlog(Blog blog) {
        blogRepository.delete(blog);
        return blog;
    }
}
