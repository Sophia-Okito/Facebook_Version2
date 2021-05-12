package com.sophia.facebook_version2.service;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.PostLike;
import com.sophia.facebook_version2.repository.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikeService implements IPostLikeService {
    @Autowired
    PostLikeRepository likeRepository;


    public PostLike getLike(PostLike like) {
        return likeRepository.findAllByUserAndPost(like.getUser(), like.getPost());


    }

    public void deleteLike(PostLike like) {
        likeRepository.delete(like);
    }

    public void addLike(PostLike like) {
        likeRepository.save(like);
    }
    public Long countPostLikeByPost(Post post){
        return countPostLikeByPost(post);
    }

    @Override
    public List<PostLike> getAllLikeOfPost(Post post) {
        return likeRepository.findPostLikeByPost(post);
    }
}
