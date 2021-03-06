package com.sophia.facebook_version2.repository;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.PostLike;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostByPostID(Long postId);
}
