package com.sophia.facebook_version2.service;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.PostLike;
import com.sophia.facebook_version2.model.User;
import com.sophia.facebook_version2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public void removePost(Post post) {
        postRepository.delete(post);
    }

    public Post findPost(Long postId) {
        return postRepository.findPostByPostID(postId);
    }

    public Post getPostById(Long id) {
        return postRepository.findPostByPostID(id);
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }
    public Post editPost(Post post, String messageBody) {
        post.setMessage(messageBody);
        return postRepository.save(post);
    }

}
