package com.greenfox.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    private String title;

    @Type(type = "text")
    private String content;

    @Column(nullable = false)
    private Integer score = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timestamp;

    public Integer upVote() {
         return score++;
    }

    public Integer downVote() {
        return score--;
    }
}
