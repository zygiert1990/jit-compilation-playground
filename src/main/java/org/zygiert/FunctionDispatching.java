package org.zygiert;

public class FunctionDispatching {

    static void main() {
        var vehicles = initVehicleArray(3);
        IO.println("My fantastic full price is: " + compute(vehicles));
    }

    static int compute(Vehicle[] vehicles) {
        var sum = 0;
        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getPrice();
        }
        return sum;
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
        int getPrice();
    }

    record Bike() implements Vehicle {
        @Override
        public int getPrice() {
            return 10;
        }
    }

    record Car() implements Vehicle {
        @Override
        public int getPrice() {
            return 20;
        }
    }

    record Truck() implements Vehicle {
        @Override
        public int getPrice() {
            return 30;
        }
    }

    record Bus() implements Vehicle {
        @Override
        public int getPrice() {
            return 40;
        }
    }

    record Train() implements Vehicle {
        @Override
        public int getPrice() {
            return 50;
        }
    }

}
