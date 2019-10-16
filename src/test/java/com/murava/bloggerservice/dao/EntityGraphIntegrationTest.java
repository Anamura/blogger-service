package com.murava.bloggerservice.dao;

import com.murava.bloggerservice.exception.ResourceNotFoundException;
import com.murava.bloggerservice.model.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

//@DataJpaTest
@SpringBootTest
//@Sql(scripts = "/entitygraph_data.sql")
public class EntityGraphIntegrationTest {
    @Autowired
    private PostDao postDao;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void givenEntityGraph_whenCalled_shouldRetrunDefinedFields() throws ResourceNotFoundException {

        // Page<Post> post = postDao.findAllByAccount(null, null);
        // assertEquals(post.getTotalElements(), null);
    }

    @After
    public void tearDown() throws Exception {
    }
}