package com.example.parking;
public abstract class Vehicle {
    private final VehicleType type;
    private final String numberPlate;

    // Constructor to initialize immutable fields
    protected Vehicle(VehicleType type, String numberPlate) {
        this.type = type;
        this.numberPlate = numberPlate;
    }

    // Getter methods for immutable fields (already initialized in constructor)
    public VehicleType getType() {
        return type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

}