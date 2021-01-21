package com.greenfox.reddit.controller;

import com.greenfox.reddit.model.Post;
import com.greenfox.reddit.repository.PostRepository;
import com.greenfox.reddit.service.RedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedditController {
    private RedditService redditService;
    private PostRepository postRepository;

    @Autowired
    public RedditController(RedditService redditService, PostRepository postRepository) {
        this.redditService = redditService;
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("posts", redditService.findAll());
        return "index";
    }

    @GetMapping("/submit")
    public String submitNewPost() {
        return "submit";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String title,
                         @RequestParam String url,
                         @ModelAttribute Post post,
                         Model model) {
        model.addAttribute("title", title);
        model.addAttribute("url", url);
        redditService.add(post);
        return "redirect:/";
    }

    @GetMapping("upVote/{id}")
    public String upVote(@PathVariable Long id) {
        Post post = redditService.upVote(id);
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("downVote/{id}")
    public String downVote(@PathVariable Long id) {
        Post post = redditService.downVote(id);
        postRepository.save(post);
        return "redirect:/";
    }
}
