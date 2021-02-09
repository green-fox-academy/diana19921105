package com.greenfox.resttests.repository;

import com.greenfox.resttests.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findByAuthor(String author);
    List<Song> findByYear(Integer year);
    List<Song> findByRating(Integer rating);
}
