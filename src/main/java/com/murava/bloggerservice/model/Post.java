package com.murava.bloggerservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "post")
@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable=false)
    private Account owner;

    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    private List<Comment> comments;

    private String slugs;

    private Date publicationDate;

    private String content;

    private int views;
}