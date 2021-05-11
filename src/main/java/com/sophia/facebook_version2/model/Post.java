package com.sophia.facebook_version2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postID;

    @ManyToOne //many post to one user
    private User user;

    @Column(nullable = false)
    private String message;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    @OneToMany
    private List<PostLike> likes = new ArrayList<>();

}
