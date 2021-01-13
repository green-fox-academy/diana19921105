package com.greenfox.dependency.service;

import com.greenfox.dependency.service.MyColor;
import org.springframework.stereotype.Service;

@Service
public class Red implements MyColor {

    @Override
    public String printColor() {
        return "It is red in color";
    }
}
