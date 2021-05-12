package com.sophia.facebook_version2.service;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.PostLike;

import java.util.List;

public interface IPostLikeService {

    List<PostLike> getAllLikeOfPost(Post post);
}
