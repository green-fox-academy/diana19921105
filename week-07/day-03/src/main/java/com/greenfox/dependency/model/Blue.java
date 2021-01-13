package com.greenfox.dependency.model;

import com.greenfox.dependency.service.MyColor;
import org.springframework.stereotype.Service;

//@Service
public class Blue implements MyColor {
    @Override
    public String printColor() {
        return "It is blue in color";
    }
}
