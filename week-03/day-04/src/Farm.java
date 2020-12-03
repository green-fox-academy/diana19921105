import java.util.ArrayList;
import java.util.List;

public class Farm {
    int slot;
    List<Animal> animals;

    public Farm() {
        this.animals = new ArrayList<>();
        this.slot = 10;
    }

    public List<Animal> breed() {
        if (this.slot != 0) {
            Animal animal = new Animal();
            animals.add(animal);
        }
        return animals;
    }

    public List<Animal> slaughter() {
        int minHunger = animals.get(0).hunger;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).hunger < minHunger) {
                minHunger = animals.get(i).hunger;
                animals.remove(animals.get(i));
            }
        }
        return animals;
    }
}
