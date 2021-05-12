package com.sophia.facebook_version2.service;

import com.sophia.facebook_version2.model.Comment;
import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.User;
import com.sophia.facebook_version2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    CommentRepository commentRepository;
    public void addComment(Comment comment, User user) {
        comment.setUser(user);
        commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
