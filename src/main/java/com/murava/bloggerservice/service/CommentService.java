package com.murava.bloggerservice.service;

import com.murava.bloggerservice.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> list();

    Integer likeComment(Long id);

    Comment getById(Long commentId);

    List<Comment> getByPostId(Long postId);

    Long update(Comment post);

    void delete(Long commentId);

    void deleteByPostId(Long postId);


//     int likePost(Post post);
//
//    int likePost(long postId);
//
//    Post create(Long userId, Post post);
//
//    Page<Post> findAllPageable(Long userId, int page, int size, boolean sort);
//
//    void deleteAllPostsByUser(Long userId);
}