package com.greenfox.reddit.controller;

import com.greenfox.reddit.model.Post;
import com.greenfox.reddit.model.User;
import com.greenfox.reddit.repository.PostRepository;
import com.greenfox.reddit.service.RedditService;
import com.greenfox.reddit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class RedditController {
    private RedditService redditService;
    private PostRepository postRepository;
    private UserService userService;


    @Autowired
    public RedditController(RedditService redditService, PostRepository postRepository, UserService userService) {
        this.redditService = redditService;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(@RequestParam(required = false) Integer page,
                           @RequestParam(required = false) Integer size,
                           @RequestParam(required = false) String userName,
                           Model model) {
        page = page == null ? 0 : page;
        size = size == null ? 10 : size;
        Page<Post> posts = redditService.findByScore(page, size);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("size", size);
        model.addAttribute("page", posts);
        model.addAttribute("userName", userName);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(@RequestParam String name,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  Model model) {
        Optional<User> user = userService.findByUserName(name);
        if (!name.contains("\\W") && email.contains("@") && email.contains(".") && user.isEmpty()) {
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "redirect:/?name=" + name;
        }
        return "rejectedRegistration";
    }

    @PostMapping("/login")
    public String logMeIn(@RequestParam String userName,
                          Model model) {
        if (!userName.contains("\\W")) {
            userService.addNewUser(User.builder().name(userName).build());
            model.addAttribute("userName", userName);
            return "redirect:/?name=" + userName;
        } else {
            return "rejectedLogin";
        }
    }

    @GetMapping("/read/{id}")
    public String readContent(@PathVariable Long id) {
        redditService.findById(id);
        return "content";
    }


    @GetMapping("/submit")
    public String submitNewPost() {
        return "submit";
    }

    @PostMapping("/submit")
    public String submitPost(@RequestParam String title,
                             @RequestParam String url,
                             @RequestParam Long userId,
                             @ModelAttribute Post post,
                             Model model) {

        redditService.submitNewPost(userId, post);
        model.addAttribute("title", title);
        model.addAttribute("url", url);
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
