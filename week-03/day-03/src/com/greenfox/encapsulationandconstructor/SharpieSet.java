package com.greenfox.encapsulationandconstructor;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    List<Sharpie> sharpies;

    public SharpieSet() {
        this.sharpies = new ArrayList<>();
    }

    public int countUsable() {
        int useAble = 0;
        for (Sharpie sharpie : this.sharpies) {
            if (sharpie.inkAmount != 0) {
                useAble++;
            }
        }
        return useAble;
    }

    public List<Sharpie> removeTrash() {
        for (int i = 0; i < this.sharpies.size(); i++) {
            if (sharpies.get(i).inkAmount == 0) {
                this.sharpies.remove(this.sharpies.get(i));
            }
        }
        return this.sharpies;
    }
}
