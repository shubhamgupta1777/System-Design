package com.parkinglot;
import java.util.*;

public class ParkingFloor {
    private final Level level;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(Level level, List<ParkingSpot> spots) {
        this.level = level;
        this.parkingSpots = spots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .findFirst();
    }

    public Level getFloor() {
        return level;
    }
}