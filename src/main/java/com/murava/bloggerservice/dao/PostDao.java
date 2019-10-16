package com.murava.bloggerservice.dao;

import com.murava.bloggerservice.model.Account;
import com.murava.bloggerservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Because we can have thousands of users we need to
 * Fetch comments in a single ds query and use Pageable.
 * <p>
 * see @EntityGraph output.log
 */
public interface PostDao extends JpaRepository<Post, Long> {
    @EntityGraph(attributePaths = {"comments"})
    @Query("SELECT p FROM Post p WHERE p.owner = ?1")
    Page<Post> findAllByAccount(Account account, Pageable pageable);


    /**
     * We can use @NamedEntityGraph directly annotation on Post entity.
     */
    @EntityGraph(value = "Post.comments")
    List<Post> findAll();
}