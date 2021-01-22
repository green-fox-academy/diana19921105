package com.greenfox.reddit.service;

import com.greenfox.reddit.model.Post;
import com.greenfox.reddit.model.User;
import com.greenfox.reddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RedditService {
    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    public RedditService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> findAll() {
        List<Post> all = postRepository.findAll();
        return all;
    }

    public void findById(Long id) {
        postRepository.findById(id);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post upVote(Long id) {
        Optional<Post> toUpVote = postRepository.findById(id);
        if (toUpVote.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Post toSave = toUpVote.get();
        toSave.setScore(toSave.getScore() + 1);
        return toSave;
    }

    public Post downVote(Long id) {
        Optional<Post> toDownVote = postRepository.findById(id);
        if (toDownVote.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Post savable = toDownVote.get();
        if (savable.getScore() > 0) {
            savable.setScore(savable.getScore() - 1);
        }
        return savable;
    }

    public Page<Post> findByScore(int page, int size) {
        return postRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "score")));
    }

    public void submitNewPost(Long userId, Post post) {
        User user = userService.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("No such User!"));
        post.setUser(user);
        List<Post> postList = user.getPost();
        postList.add(post);
        this.save(post);
    }
}
