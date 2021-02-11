package com.greenfox.mentorrate.controller;

import com.greenfox.mentorrate.model.ErrorMessage;
import com.greenfox.mentorrate.model.Mentor;
import com.greenfox.mentorrate.model.MentorRequestDto;
import com.greenfox.mentorrate.service.MentorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class MainController {
    private MentorService mentorService;

    public MainController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("mentors", mentorService.findAll());
        model.addAttribute("names", mentorService.getMentorNames());
        model.addAttribute("classes", mentorService.getClassNames());
        return "index";
    }

    @PostMapping("/mentor")
    public String addMentor(@ModelAttribute Mentor mentor) {
        mentorService.addMentor(mentor);
        return "redirect:/mentor" + mentor.getId();
    }

    @GetMapping("/mentor/{id}")
    public String getMentorDetails(@PathVariable Long id,
                                   Model model) {
        try {
            mentorService.findById(id);
        } catch (NoSuchElementException e) {
            ErrorMessage errorMessage = new ErrorMessage("No such mentor with ID: " + id);
            model.addAttribute("error", errorMessage);
        }
        return "mentor";
    }

    @RequestMapping(value = "/api/mentors/{mentorId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<MentorRequestDto> updateMentor(@PathVariable Long mentorId,
                                                         @RequestBody MentorRequestDto mentorRequestDto) {

        List<String> validClassNames = List.of("Roboto", "Tiptop", "Seadog", "Really");

        if (validClassNames.contains(mentorRequestDto.getClassName()) && mentorId != null) {
            try {
                mentorService.updateMentor(mentorId, mentorRequestDto);
                return ResponseEntity.ok(mentorRequestDto);
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/api/mentors/{mentorId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable Long mentorId) {
        if (mentorId != null) {
            try {
                mentorService.delete(mentorId);
                return ResponseEntity.ok().build();
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
