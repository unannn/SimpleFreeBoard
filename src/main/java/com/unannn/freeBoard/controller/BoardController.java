package com.unannn.freeBoard.controller;

import com.unannn.freeBoard.domain.Post;
import com.unannn.freeBoard.repository.PostRepository;
import com.unannn.freeBoard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    private final PostService postService;

    @Autowired
    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts",posts);
        return "main";
    }

    @GetMapping("/create-post")
    public String createPost(){
        return "write-post";
    }
    @PostMapping("/create-post-process")
    public String createPostProcess(PostForm postForm){

        Post newPost = new Post();

        newPost.setTitle(postForm.getTitle());
        newPost.setWriterId(postForm.getWriterId());
        newPost.setContent(postForm.getContent());

        postService.registerPost(newPost);

        return "redirect:/";
    }
}
