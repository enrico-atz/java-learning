package oop.arrayofobjects;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Mustang","Rosso");
        Car car2 = new Car("Panda","Nero");
        Car car3 = new Car("Urus","Bianco");

        Car[] cars = {car1, car2, car3, new Car("Polo", "Blu")};

        // traditional for loop

        for(int i = 0; i < cars.length; i++) {
            cars[i].drive();
        }

        System.out.println("\n");

        // enhanced for loop

        for(Car car : cars) {
            car.drive();
        }

        System.out.println("\n");

    }
}
