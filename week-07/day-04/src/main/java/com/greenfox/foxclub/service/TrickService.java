package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.model.Trick;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrickService {

    public void addTricks(Trick trick, Fox fox) {
        fox.addTricks(trick);
    }

    public List<Trick> getTricks(Fox fox) {
        return fox.getTricks().stream()
                .findAny()
                .stream().collect(Collectors.toList());
    }
}
