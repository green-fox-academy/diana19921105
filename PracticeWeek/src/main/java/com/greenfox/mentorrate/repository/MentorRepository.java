package com.greenfox.mentorrate.repository;

import com.greenfox.mentorrate.model.Mentor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Long> {
}
