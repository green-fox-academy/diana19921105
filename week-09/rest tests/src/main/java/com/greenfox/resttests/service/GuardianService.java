package com.greenfox.resttests.service;

import com.greenfox.resttests.model.Food;
import com.greenfox.resttests.model.FoodRequest;
import com.greenfox.resttests.model.Song;
import com.greenfox.resttests.model.SongRequest;
import com.greenfox.resttests.model.SongResponseDto;
import com.greenfox.resttests.repository.FoodRepository;
import com.greenfox.resttests.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class GuardianService {

    private FoodRepository foodRepository;
    private SongRepository songRepository;

    @Autowired
    public GuardianService(FoodRepository foodRepository, SongRepository songRepository) {
        this.foodRepository = foodRepository;
        this.songRepository = songRepository;
    }

    public List<Food> findAllFoods() {
        return (List<Food>) foodRepository.findAll();
    }

    public ResponseEntity<?> addFood(Food food) {
        return ResponseEntity.ok(foodRepository.save(food));
    }

    public void deleteFood(Long id) {
        foodRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        foodRepository.deleteById(id);
    }

    public Food changeAmount(Long id, FoodRequest foodRequest) {
        Food food = foodRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        food.setAmount(food.getAmount() + foodRequest.getAmount());
        return foodRepository.save(food);
    }

    public List<Song> findAllSongs() {
        return (List<Song>) songRepository.findAll();
    }

    public ResponseEntity<?> addSong(Song song) {
        return ResponseEntity.ok(songRepository.save(song));
    }

    public void deleteSongById(Long id) {
        songRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        songRepository.deleteById(id);
    }

    public Song changeRating(Long id, SongRequest songRequest) {
        Song song = songRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        song.setRating(songRequest.getRating());
        return songRepository.save(song);
    }

    public List<SongResponseDto> filterByAuthor(String author) {
        List<Song> byAuthor = songRepository.findByAuthor(author);
        return mapToDto(byAuthor);
    }

    public List<SongResponseDto> filterByYear(Integer year) {
        List<Song> byYear = songRepository.findByYear(year);
        return mapToDto(byYear);
    }

    public List<SongResponseDto> filterByRating(Integer rating) {
        List<Song> byRating = songRepository.findByRating(rating);
        return mapToDto(byRating);
    }

    public List<SongResponseDto> favoriteSongs(Integer limit) {
        List<Song> all = (List<Song>) songRepository.findAll();

        return all.stream()
                .sorted(Comparator.comparing(Song::getRating).reversed())
                .limit(limit)
                .map(s -> new SongResponseDto(s.getTitle(), s.getAuthor(), s.getRating(), s.getYear()))
                .collect(Collectors.toList());
    }

    private List<SongResponseDto> mapToDto(List<Song> filtered) {
        return filtered.stream()
                .map(s -> new SongResponseDto(s.getTitle(), s.getAuthor(), s.getRating(), s.getYear()))
                .collect(Collectors.toList());
    }
}
