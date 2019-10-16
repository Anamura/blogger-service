package com.murava.bloggerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "account")
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<Post> posts;

    private String email;

    private String logo;

    private String social_network;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<Comment> comments;
}