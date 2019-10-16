package com.murava.bloggerservice.service;

import com.murava.bloggerservice.model.Account;
import com.murava.bloggerservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AccountService {

    Account registerNewUser(Account account);

    Account getById(Long id);

    Post createPost(Long accountId, Post post);

    Page<Post> findAllPageable(Long accountId, PageRequest of);

    Long update(Account account);

    void delete(Long id);

    void deleteBatch();

    List<Account> list();
}