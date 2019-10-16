package com.murava.bloggerservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Table(name = "post")
@Entity
@Data
@NamedEntityGraph(name = "Post.comments",
        attributeNodes = @NamedAttributeNode("comments")
)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account owner;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    private String slugs;

    private Date publicationDate;

    @NotNull
    private String content;

    private int views;
}