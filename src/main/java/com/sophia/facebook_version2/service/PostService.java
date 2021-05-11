package com.sophia.facebook_version2.service;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.User;
import com.sophia.facebook_version2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    PostRepository postRepository;
    public void addPost(Post post, User user) {
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }
}
