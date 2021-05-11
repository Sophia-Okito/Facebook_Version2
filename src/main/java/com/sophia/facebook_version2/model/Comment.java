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
@Entity(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentID;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    private String comment;

    @OneToMany
    private List<CommentLike> commentLikes = new ArrayList<>();
}
