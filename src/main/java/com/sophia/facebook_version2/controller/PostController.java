package com.sophia.facebook_version2.controller;

import com.sophia.facebook_version2.model.Post;
import com.sophia.facebook_version2.model.User;
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

    @PostMapping("/post")
    public String makePost(HttpSession httpSession, Model model, Post post) {
        User user = (User)httpSession.getAttribute("user");

        if (post.getMessage().length() == 0) {
            model.addAttribute("emptyPost", "Post can not be empty");
        }
        postService.addPost(post, user);
        return "redirect:/home";
    }
}
