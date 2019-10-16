package com.murava.bloggerservice.service.impl;

import com.murava.bloggerservice.dao.CommentDao;
import com.murava.bloggerservice.model.Comment;
import com.murava.bloggerservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> list() {
        return commentDao.findAll();
    }

    @Override
    public Comment getById(Long commentId) {
        Optional<Comment> comment = commentDao.findById(commentId);
        return comment.get();
    }

    @Override
    public List<Comment> getByPostId(Long postId) {
        return null;
    }

    @Override
    public Long update(Comment comment) {
        Comment updatedPost = commentDao.save(comment);
        return updatedPost.getId();
    }

    @Override
    public void delete(Long commentId) {
        commentDao.deleteById(commentId);
    }

    @Override
    public void deleteByPostId(Long postId) {
    }

    @Override
    public Integer likeComment(Long commentId) {
        Optional<Comment> opt = commentDao.findById(commentId);
        if (opt.isPresent()) {
            Comment comment = opt.get();
            int count = comment.getLikeCount() + 1;
            comment.setLikeCount(count);
            commentDao.save(comment);
            return count;
        }
        return 0;
    }
}
