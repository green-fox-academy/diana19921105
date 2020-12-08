package Interface;

public class InterfaceDemo {
    public static void main(String[] args) {
        Interface.Bird bird = new Interface.Bird("Parrot");
        Interface.Helicopter helicopter = new Interface.Helicopter("black", "helicopter", 2);

        bird.takeoff();
        bird.fly();
        bird.land();

        helicopter.takeoff();
        helicopter.fly();
        helicopter.land();
    }
}
