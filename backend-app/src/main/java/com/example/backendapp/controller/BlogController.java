package com.example.backendapp.controller;

import com.example.backendapp.model.Blog;
import com.example.backendapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// CrossOrigin allows the frontend localhost to make requests to the backend localhost
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v2")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogService.getBlogById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogService.getBlogsByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        Blog newBlog = new Blog(title, content);
        return blogService.createBlog(newBlog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        // getting blog
        Optional<Blog> blog = blogService.getBlogById(blogId);
        blog.get().setTitle(body.get("title"));
        blog.get().setContent(body.get("content"));
        return blogService.updateBlog(blog);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        Blog blog = new Blog();
        blog.setId(blogId);
        blogService.deleteBlog(blog);
        return true;
    }


}
