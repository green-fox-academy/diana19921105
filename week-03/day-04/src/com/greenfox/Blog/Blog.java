package com.greenfox.Blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    List<BlogPost> posts = new ArrayList<>();

    public void add(BlogPost post) {
        posts.add(post);

    }

    public List<BlogPost> delete(int i) {
        for (int j = 0; j < posts.size(); j++) {
            if (i == j) {
                posts.remove(j);
            }
        }

        return posts;
    }

    public List<BlogPost> update(int i, BlogPost blogPost) {
        for (int j = 0; j < posts.size(); j++) {
            posts.set(i, blogPost);
        }
        return posts;
    }


}

