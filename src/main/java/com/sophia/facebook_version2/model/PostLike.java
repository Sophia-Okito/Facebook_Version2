package com.sophia.facebook_version2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "likes")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeID;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;
}
