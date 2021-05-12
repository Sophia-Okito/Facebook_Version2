package com.sophia.facebook_version2.controller;

import com.sophia.facebook_version2.model.Comment;
import com.sophia.facebook_version2.model.User;
import com.sophia.facebook_version2.service.CommentService;
import com.sophia.facebook_version2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

//    @GetMapping("/comment/{postId}")
//    public String getCommentPage(@PathVariable("postId") Long postId, Model model, HttpSession httpSession) {
//        Post post = postService.findPost(postId);
//        User user = (User)httpSession.getAttribute("user");
//        model.addAttribute("post", post);
//        model.addAttribute("user", user);
//        model.addAttribute("newComment", new Comment());
//        model.addAttribute("allComment", commentService.findAll());
//        return "comment";
//    }
    @PostMapping("/comment/{id}")
    public String newCommentIndex(@PathVariable("id") Long id, HttpSession session,  String comment) {
        Comment comment1 = new Comment();

        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        comment1.setComment(comment);
        comment1.setPost(postService.getPostById(id));
        comment1.setUser((User) userObj);
        commentService.addComment(comment1);
        return "redirect:/home";
    }

//    @PostMapping("/comment")
//    public String makeComment(HttpSession httpSession, Model model, Comment comment) {
//        User user = (User) httpSession.getAttribute("user");
//
//        if (comment.getComment().length() == 0) {
//            model.addAttribute("emptyPost", "Post can not be empty");
//            return "redirect:/comment/{postId}";
//        }
//
//        commentService.addComment(comment, user);
//        return "redirect:/comment/{postId}";
//    }
}
