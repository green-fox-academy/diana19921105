package com.greenfox.mentorrate.service;

import com.greenfox.mentorrate.model.Class;
import com.greenfox.mentorrate.model.Mentor;
import com.greenfox.mentorrate.model.MentorRequestDto;
import com.greenfox.mentorrate.repository.ClassRepository;
import com.greenfox.mentorrate.repository.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MentorService {
    private MentorRepository mentorRepository;
    private ClassRepository classRepository;

    public MentorService(MentorRepository mentorRepository, ClassRepository classRepository) {
        this.mentorRepository = mentorRepository;
        this.classRepository = classRepository;
    }

    public List<Mentor> findAll() {
        return (List<Mentor>) mentorRepository.findAll();
    }

    public List<String> getMentorNames() {
        List<Mentor> mentors = findAll();

        return mentors.stream()
                .map(Mentor::getName)
                .collect(Collectors.toList());
    }

    public List<String> getClassNames() {
        List<Class> classes = (List<Class>) classRepository.findAll();

        return classes.stream()
                .map(Class::getName)
                .collect(Collectors.toList());
    }

    public void addMentor(Mentor mentor) {
        mentorRepository.save(mentor);
    }

    public Mentor findById(Long id) {
        return mentorRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public Mentor updateMentor(Long id, MentorRequestDto mentorRequestDto) {
        Mentor mentor = findById(id);
        Class className = classRepository.findByName(mentorRequestDto.getClassName())
                .orElseThrow(NoSuchElementException::new);

        mentor.setName(mentorRequestDto.getName());
        mentor.setClasses(className);
        return mentorRepository.save(mentor);
    }

    public void delete(Long id) {
        mentorRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        mentorRepository.deleteById(id);

    }
}
