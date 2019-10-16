package com.murava.bloggerservice.controller;

import com.murava.bloggerservice.model.Account;
import com.murava.bloggerservice.model.Comment;
import com.murava.bloggerservice.model.Post;
import com.murava.bloggerservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostWebAPI {

    @Autowired
    private PostService postService;

    @GetMapping("/{postId}")
    public Post getById(@PathVariable("postId") Long postId) {
        Post post = postService.getById(postId);
        return post;
    }

    // api/posts/{id}/comments
    @PostMapping(path = "/{postId}/comments")
    public @ResponseBody
    Comment addComment(@PathVariable("postId") Long postId, @RequestBody @Valid Comment comment,
                       @RequestParam(value = "author") Long accountId) {
        return postService.addComment(postId, comment, accountId);
    }

    // api/posts/{id}/comments/{id}
    @PostMapping(path = "/{postId}/comments/{commentId}")
    public @ResponseBody
    Long assignComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId) {
        return postService.assignToPost(postId, commentId);
    }

    @PutMapping(path = "/update")
    public void updatePost(@RequestBody Post post) {
        postService.update(post);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        postService.delete(id);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<Post> getAllPosts() {
        return postService.list();
    }

    @GetMapping(path = "/{postId}/comments")
    public @ResponseBody
    ResponseEntity<List<Comment>> fetch(@PathVariable("postId") Long postId) {
        List<Comment> comments = postService.fetch(postId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping(path = "/views")
    public @ResponseBody
    List<Post> getPostViews() {
        return postService.getViews();
    }

}
