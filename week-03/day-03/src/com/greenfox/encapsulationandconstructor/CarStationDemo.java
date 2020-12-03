package com.greenfox.encapsulationandconstructor;

public class CarStationDemo {
    public static void main(String[] args) {
        Car car = new Car();
        Station station = new Station(500);

        station.refill(car);

        System.out.println(station.gasAmount);
        System.out.println(car.gasAmount);
    }
}
