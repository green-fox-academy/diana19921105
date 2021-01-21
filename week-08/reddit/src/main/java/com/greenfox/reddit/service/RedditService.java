package com.greenfox.reddit.service;

import com.greenfox.reddit.model.Post;
import com.greenfox.reddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedditService {
    private PostRepository postRepository;

    @Autowired
    public RedditService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        List<Post> all = (List<Post>) postRepository.findAll();
        return all;
    }

    public void findById(Long id) {
        postRepository.findById(id);
    }

    public void add(Post post) {
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
}
