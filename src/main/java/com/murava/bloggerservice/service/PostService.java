package com.murava.bloggerservice.service;

import com.murava.bloggerservice.model.Comment;
import com.murava.bloggerservice.model.Post;

import java.util.List;

/**
 *
 */
public interface PostService {

    Post getById(Long postId);

    Comment addComment(Long postId, Comment comment, Long accountId);

    List<Comment> fetch(Long postId);

    Long assignToPost(Long id, Long commentId);

    Long update(Post post);

    void delete(Long id);

    List<Post> list();

    List<Post> getViews();
}