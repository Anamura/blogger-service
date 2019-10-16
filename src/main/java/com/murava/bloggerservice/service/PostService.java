package com.murava.bloggerservice.service;

import com.murava.bloggerservice.model.Comment;
import com.murava.bloggerservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 */
public interface PostService {

    Post getById(Long postId);

    Comment addComment(Long postId, Comment comment);

    List<Comment> fetch(Long postId, Comment comment);

    Long assignToPost(Long id, Long commentId);

    Long update(Post post);

    void delete(Long id);

    List<Post> list();

    List<Post> getViews();

    // Post create(Long userId, Post post);
    //
    // Page<Post> findAllPageable(Long userId, int page, int size, boolean sort);
    //
    // void deleteAllPostsByUser(Long userId);
}