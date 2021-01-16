package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.model.Trick;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrickService {

    private List<Trick> trickList;

    public TrickService() {
        trickList = new ArrayList<>();
        trickList.addAll(Arrays.asList(Trick.values()));
    }

    public List<Trick> getTrickList() {
        return trickList;
    }

    public List<Trick> getFilteredTricks(Fox fox) {
        return trickList.stream()
                .filter(t -> !fox.getTricks().contains(t))
                .collect(Collectors.toList());
    }
}
