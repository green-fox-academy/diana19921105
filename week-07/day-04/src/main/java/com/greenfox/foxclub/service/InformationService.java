package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.Fox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationService {

    private List<Fox> foxList;

    public InformationService() {
        foxList = new ArrayList<>();
    }

    public void add(Fox fox) {
        foxList.add(fox);
    }

    public Fox findFox(String name) {
        Fox createNew = foxList.stream()
                .filter(f -> f.getName().equals(name))
                .findAny()
                .orElse(new Fox(name));
        return createNew;
    }

}
