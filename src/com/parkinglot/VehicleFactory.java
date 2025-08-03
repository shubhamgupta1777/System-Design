package com.parkinglot;
public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String numberPlate) {
        switch (type) {
            case CAR:
                return new Car(type, numberPlate);
            case BIKE:
                return new Bike(type, numberPlate);
            case TRUCK:
                return new Truck(type, numberPlate);
            default:
                throw new IllegalArgumentException("Unsupported Vehicle Type: " + type);
        }
    }
}
