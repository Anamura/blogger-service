package com.murava.bloggerservice.service.impl;

import com.murava.bloggerservice.dao.AccountDao;
import com.murava.bloggerservice.dao.PostDao;
import com.murava.bloggerservice.model.Account;
import com.murava.bloggerservice.model.Post;
import com.murava.bloggerservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    PostDao postDao;

    @Override
    public Account registerNewUser(Account account) {
        return accountDao.save(account);
    }

    @Override
    public Account getById(Long id) {
        Optional<Account> account = accountDao.findById(id);
        return account.get();
    }

    @Override
    public Post createPost(Long accountId, Post post) {
        Optional<Account> account = accountDao.findById(accountId);
        if (account.isPresent()) {
            post.setOwner(account.get());
        }
        post.setPublicationDate(new Date());
        return postDao.save(post);
    }

    public Page<Post> findAllPageable(Long accountId, PageRequest of) {
        Optional<Account> account = accountDao.findById(accountId);
        if (account.isPresent()) {
            return postDao.findAllByAccount(account.get(), of);
        }
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public Long update(Account account) {
        Account updatedUser = accountDao.save(account);
        return updatedUser.getId();
    }

    @Override
    public void delete(Long id) {
        accountDao.deleteById(id);
    }

    @Override
    public void deleteBatch() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Account> list() {
        return accountDao.findAll();
    }

}
