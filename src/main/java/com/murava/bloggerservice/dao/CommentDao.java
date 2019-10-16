package com.murava.bloggerservice.dao;

import com.murava.bloggerservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {
}