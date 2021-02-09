package com.greenfox.resttests.controller;

import com.greenfox.resttests.model.Food;
import com.greenfox.resttests.model.FoodRequest;
import com.greenfox.resttests.model.GrootError;
import com.greenfox.resttests.model.GrootResult;
import com.greenfox.resttests.model.Rocket;
import com.greenfox.resttests.model.RocketError;
import com.greenfox.resttests.model.RocketResult;
import com.greenfox.resttests.model.Song;
import com.greenfox.resttests.model.SongRequest;
import com.greenfox.resttests.model.SongResponseDto;
import com.greenfox.resttests.model.YonduError;
import com.greenfox.resttests.model.YonduResult;
import com.greenfox.resttests.service.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class GuardianController {

    private GuardianService guardianService;


    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @GetMapping("/groot")
    public ResponseEntity<?> groot(@RequestParam(required = false) String message) {
        GrootError error = new GrootError("I am Groot!");

        if (message != null) {
            return ResponseEntity.ok(new GrootResult(message));
        } else {
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/yondu")
    public ResponseEntity<?> yondu(@RequestParam(required = false) Double distance,
                                   @RequestParam(required = false) Double time) {
        YonduError error = new YonduError("Something went wrong!");

        if (distance != null && time != null) {
            return ResponseEntity.ok(new YonduResult(distance, time));
        } else {
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/rocket")
    public ResponseEntity<?> rocket() {
        Rocket rocket = new Rocket();
        return ResponseEntity.ok(rocket);
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<?> fillRocket(@RequestParam(required = false) String caliber,
                                        @RequestParam(required = false) Integer amount) {
        RocketError error = new RocketError("Task failed successfully!");

        if (caliber != null && amount != null) {
            return ResponseEntity.ok(new RocketResult(caliber, amount));
        } else {
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/drax")
    public ResponseEntity<?> getAllFood() {
        return ResponseEntity.ok(guardianService.findAllFoods());
    }

    @PostMapping("/drax")
    public ResponseEntity<?> addFood(@RequestBody(required = false) Food food) {
        if (food != null) {
            return new ResponseEntity<>(guardianService.addFood(food), HttpStatus.CREATED);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/drax")
    public ResponseEntity<?> deleteFood(@RequestBody Long id) {
        if (id != null) {
            try {
                guardianService.deleteFood(id);

            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/drax/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> changeFoodAmount(@PathVariable Long id,
                                              @RequestBody FoodRequest foodRequest) {
        if (id != null && foodRequest.getAmount() > 0) {
            try {
                Food food = guardianService.changeAmount(id, foodRequest);
                return ResponseEntity.ok(food);
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/awesome")
    public ResponseEntity<?> getAllSongs() {
        return ResponseEntity.ok(guardianService.findAllSongs());
    }

    @PostMapping("/addSong")
    public ResponseEntity<?> addSong(@RequestBody(required = false) Song song) {
        if (song != null) {
            return new ResponseEntity<>(guardianService.addSong(song), HttpStatus.CREATED);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSongById(@PathVariable Long id) {
        if (id != null) {
            try {
                guardianService.deleteSongById(id);
                return ResponseEntity.accepted().build();
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/change-rating/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> changeRatingById(@PathVariable Long id,
                                              @RequestBody SongRequest songRequest) {

        if (id != null && songRequest.getRating() != null) {
            try {
                Song song = guardianService.changeRating(id, songRequest);
                return ResponseEntity.ok(song);
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findBy")
    public ResponseEntity<List<SongResponseDto>> findByParam(@RequestParam(required = false) String author,
                                                             @RequestParam(required = false) Integer year,
                                                             @RequestParam(required = false) Integer rating) {
        if (author != null) {
            List<SongResponseDto> filterByAuthor = guardianService.filterByAuthor(author);
            return ResponseEntity.ok(filterByAuthor);
        } else if (year != null) {
            List<SongResponseDto> filterByYear = guardianService.filterByYear(year);
            return ResponseEntity.ok(filterByYear);
        } else if (rating != null) {
            List<SongResponseDto> filterByRating = guardianService.filterByRating(rating);
            return ResponseEntity.ok(filterByRating);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/favorite")
    public ResponseEntity<List<SongResponseDto>> favoriteSongs(@RequestParam Integer limit) {
        List<SongResponseDto> favoriteSongs = guardianService.favoriteSongs(limit);
        return ResponseEntity.ok(favoriteSongs);
    }
}

