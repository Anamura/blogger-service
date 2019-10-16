package com.murava.bloggerservice.controller;

import com.murava.bloggerservice.model.Account;
import com.murava.bloggerservice.model.Post;
import com.murava.bloggerservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RestController
@RequestMapping("/api/accounts")
public class AccountWebAPI {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/register")
    public @ResponseBody
    Account createAccount(@RequestBody Account account) {
        return accountService.registerNewUser(account);
    }

    @GetMapping("/{accountId}")
    public Account getById(@PathVariable("accountId") Long accountId) {
        Account account = accountService.getById(accountId);
        return account;
    }

    @PostMapping(path = "/{accountId}/posts")
    public @ResponseBody
    Post addPost(@PathVariable("accountId") Long accountId, @RequestBody Post post) {
        return accountService.createPost(accountId, post);
    }

    @GetMapping("/{accountId}/posts")
    public ResponseEntity<Page<Post>> findAllPosts(@PathVariable("accountId") Long accountId,
                                                   @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                   @RequestParam(value = "size", defaultValue = "30", required = false) int size,
                                                   @RequestParam(value = "sort", defaultValue = "publicationDate", required = false) String sort) {
        Page<Post> posts = accountService.findAllPageable(accountId, PageRequest.of(page, size, DESC, sort));
        return ResponseEntity.ok(posts);
    }

    @PutMapping(path = "/update")
    public void updateAccount(@RequestBody Account account) {
        accountService.update(account);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        accountService.delete(id);
    }

    @DeleteMapping("/deleteAllConnectedPosts")
    public void deleteAllConnectedPosts() {
        accountService.deleteBatch();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<Account> getAll() {
        return accountService.list();
    }
}