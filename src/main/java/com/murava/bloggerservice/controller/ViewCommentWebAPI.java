package com.murava.bloggerservice.controller;

import com.murava.bloggerservice.model.Comment;
import com.murava.bloggerservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class ViewCommentWebAPI {

    @Autowired
    CommentService commentService;

    @GetMapping(path = "/all")
    public @ResponseBody
    List<Comment> getAll() {
        return commentService.list();
    }

    @GetMapping("/{commentId}")
    public Comment getById(@PathVariable("commentId") Long commentId) {
        Comment comment = commentService.getById(commentId);
        return comment;
    }

    @GetMapping(path = "/getByPostId/{postId}")
    public @ResponseBody
    List<Comment> getCommentsByPostId(@PathVariable("postId") Long postId) {
        return commentService.getByPostId(postId);
    }

    @PutMapping(path = "/update")
    public void updateComment(@RequestBody Comment comment) {
        commentService.update(comment);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        commentService.delete(id);
    }

    @DeleteMapping("/deleteByPostId/{postId}")
    public void deleteByPostId(@PathVariable("postId") Long postId) {
        commentService.deleteByPostId(postId);
    }

    @PutMapping("/{commentId}/like")
    public Integer like(@PathVariable("commentId") Long id) {
        return commentService.likeComment(id);
    }
}
