package com.sophia.facebook_version2.repository;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.PostLike;
import com.sophia.facebook_version2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    public PostLike findAllByUserAndPost(User user, Post post);
    public Long countPostLikeByPost(Post post);
    List<PostLike> findPostLikeByPost(Post post);
}
