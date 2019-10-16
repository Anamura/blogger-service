package com.murava.bloggerservice.service.impl;

import com.murava.bloggerservice.dao.AccountDao;
import com.murava.bloggerservice.dao.CommentDao;
import com.murava.bloggerservice.dao.PostDao;
import com.murava.bloggerservice.model.Account;
import com.murava.bloggerservice.model.Comment;
import com.murava.bloggerservice.model.Post;
import com.murava.bloggerservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Autowired
    CommentDao commentDao;

    @Override
    public Post getById(Long postId) {
        Optional<Post> post = postDao.findById(postId);
        return post.get();
    }

    @Override
    public List<Comment> fetch(Long postId, Comment comment) {
        return commentDao.findAll(); //Pageable of
    }

    @Override
    public Comment addComment(Long postId, Comment comment) {
        Optional<Post> post = postDao.findById(postId);
        if (post.isPresent()) {
            comment.setPost(post.get());
        }
        comment.setLastModified(new Date());
        return commentDao.save(comment);
    }

    @Override
    public Long assignToPost(Long id, Long commentId) {
        return null;
    }

    @Override
    public Long update(Post post) {
        Post updatedPost = postDao.save(post);
        return updatedPost.getId();
    }

    @Override
    public void delete(Long id) {
        postDao.deleteById(id);
    }

    @Override
    public List<Post> list() {
        return postDao.findAll();
    }

    @Override
    public List<Post> getViews() {
        return null; // TODO
    }
}
