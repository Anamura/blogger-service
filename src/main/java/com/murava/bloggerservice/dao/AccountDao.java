package com.murava.bloggerservice.dao;

import com.murava.bloggerservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
}