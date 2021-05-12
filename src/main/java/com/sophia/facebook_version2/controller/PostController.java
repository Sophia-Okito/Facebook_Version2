package com.sophia.facebook_version2.controller;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.PostLike;
import com.sophia.facebook_version2.model.User;
import com.sophia.facebook_version2.service.PostLikeService;
import com.sophia.facebook_version2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostLikeService likeService;

    @PostMapping("/post")
    public String makePost(HttpSession httpSession, Model model, Post post) {
        User user = (User)httpSession.getAttribute("user");

        if (post.getMessage().length() == 0) {
            model.addAttribute("emptyPost", "Post can not be empty");
        }
        postService.addPost(post, user);
        return "redirect:/home";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(HttpSession httpSession, @PathVariable("id") Long id){
        User user = (User) httpSession.getAttribute("user");
        if(user == null)
            return "home";
        Post post = postService.getPostById(id);
        postService.deletePost(post);
        return "redirect:/home";
    }

    @PostMapping("/like/{id}")
    public String likeIndex(@PathVariable("id") Long id, HttpSession session, PostLike like, Model model) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        like.setPost(postService.getPostById(id));
        like.setUser((User) userObj);

        if(likeService.getLike(like) != null) {
            likeService.deleteLike(like);
        } else {
            likeService.addLike(like);
        }
        return "redirect:/home";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable("id") Long id, HttpSession session, Post postUpdate) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        Post post = postService.getPostById(id);
        postService.editPost(post, postUpdate.getMessage());
        return "redirect:/home";
    }
}
