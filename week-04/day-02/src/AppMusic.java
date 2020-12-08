import com.greenfox.music.*;

public class AppMusic {
    public static void main(String[] args) {
        System.out.println("Test 1, create Electric Guitar, Bass Guitar and Violin with default strings.");

        ElectricGuitar electricGuitar = new ElectricGuitar();
        BassGuitar bassGuitar = new BassGuitar();
        Violin violin = new Violin();

        System.out.println("Test 1 Play");
        electricGuitar.play();
        bassGuitar.play();
        violin.play();

        System.out.println("Test 2, create Electric Guitar, Bass Guitar with 7 and 5 strings .");
        ElectricGuitar electricGuitar1 = new ElectricGuitar("Electric guitar", 7);
        BassGuitar bassGuitar1 = new BassGuitar("Bass Guitar", 5);

        System.out.println("Test 2 Play");
        bassGuitar1.play();
        electricGuitar1.play();
    }
}
