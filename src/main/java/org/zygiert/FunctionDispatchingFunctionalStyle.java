package org.zygiert;

public class FunctionDispatchingFunctionalStyle {

    static void main() {
        var vehicles = initVehicleArray(3);
        IO.println("My fantastic full price is: " + compute(vehicles));
    }

    static int compute(Vehicle[] vehicles) {
        var sum = 0;
        for (Vehicle vehicle : vehicles) {
            sum += getPrice(vehicle);
        }
        return sum;
    }

    private static int getPrice(Vehicle vehicle) {
        return switch (vehicle) {
            case Bike _ -> 10;
            case Car _ -> 20;
            case Truck _ -> 30;
            case Bus _ -> 40;
            case Train _ -> 50;
        };
    }

    static Vehicle[] initVehicleArray(int variousVehicles) {
        Vehicle[] types = switch (variousVehicles) {
            case 1 -> new Vehicle[]{new Bike()};
            case 2 -> new Vehicle[]{new Bike(), new Car()};
            case 3 -> new Vehicle[]{new Bike(), new Car(), new Truck()};
            case 4 -> new Vehicle[]{new Bike(), new Car(), new Truck(), new Bus()};
            case 5 -> new Vehicle[]{new Bike(), new Car(), new Truck(), new Bus(), new Train()};
            default -> throw new IllegalArgumentException("Unsupported number of vehicle types: " + variousVehicles);
        };

        Vehicle[] vehicles = new Vehicle[1_000_000];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = types[i % types.length];
        }
        return vehicles;
    }

    sealed interface Vehicle permits Bike, Car, Truck, Bus, Train {
    }

    record Bike() implements Vehicle {
    }

    record Car() implements Vehicle {
    }

    record Truck() implements Vehicle {
    }

    record Bus() implements Vehicle {
    }

    record Train() implements Vehicle {
    }

}
