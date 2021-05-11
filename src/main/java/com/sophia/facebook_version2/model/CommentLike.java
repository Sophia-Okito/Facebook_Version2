package com.sophia.facebook_version2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="commentLikes")
public class CommentLike {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long commentID;

    @ManyToOne
    private Comment comment;

    @ManyToOne
    private User user;

}
