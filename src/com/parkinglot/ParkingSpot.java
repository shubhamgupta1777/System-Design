package com.parkinglot;

public class ParkingSpot {
    private final String spotId;
    private final SpotType type;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType type) {
        this.spotId = spotId;
        this.type = type;
        this.occupied = false;
    }

    public boolean isAvailable() {
        return !occupied;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return (vehicle.getType() == VehicleType.BIKE && type == SpotType.BIKE) ||
                (vehicle.getType() == VehicleType.CAR && type == SpotType.CAR) ||
                (vehicle.getType() == VehicleType.TRUCK && type == SpotType.TRUCK);
    }

    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.occupied = false;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getType() {
        return type;
    }

    public Vehicle getVehicle() {
        return parkedVehicle;
    }
}