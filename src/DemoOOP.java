abstract class Vehicle {
    private String model;
    private int year;

    // Constructor for Vehicle (encapsulation)
    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // Getters and setters (encapsulation)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Abstract method for starting the vehicle (abstraction)
    public abstract void start();

    // Private method for generic engine starting logic (abstraction)
    protected void engineStart() {
        System.out.println("Engine humming...");
    }
}

class Car extends Vehicle {
    private int engineType;

    // Constructor for Car (inheritance)
    public Car(String model, int year, int engineType) {
        super(model, year); // Calling the parent constructor (inheritance)
        this.engineType = engineType;
    }

    // Overridden start method (polymorphism)
    @Override
    public void start() {
        engineStart(); // Using private method for common behavior (abstraction)
        System.out.println("Car rolling forward...");
    }
}

class ElectricCar extends Vehicle {
    private int batteryLevel;

    // Constructor for ElectricCar (inheritance)
    public ElectricCar(String model, int year, int batteryLevel) {
        super(model, year); // Calling the parent constructor (inheritance)
        this.batteryLevel = batteryLevel;
    }

    // Overridden start method (polymorphism)
    @Override
    public void start() {
        if (batteryLevel > 20) {
            System.out.println("Electric motor whirring...");
        } else {
            System.out.println("Recharge required before starting");
        }
    }

    public void chargeBattery() {
        System.out.println("Charging battery...");
        // Implement battery charging logic
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}

public class DemoOOP {
    public static void main(String[] args) {
        // Creating objects of Car and ElectricCar classes (classes and objects)
        Vehicle car1 = new Car("Toyota Camry", 2020, 4);
        Vehicle car2 = new ElectricCar("Tesla Model S", 2023, 85);

        // Accessing object properties (encapsulation)
        System.out.println("Car 1 model: " + car1.getModel());
        car1.setYear(2024);
        System.out.println("Car 2 battery level: " + ((ElectricCar) car2).getBatteryLevel()); // Type casting

        // Calling methods on objects (polymorphism)
        car1.start();
        car2.start(); // Different behavior based on object type
        ((ElectricCar) car2).chargeBattery(); // Calling specific method of ElectricCar
    }
}
