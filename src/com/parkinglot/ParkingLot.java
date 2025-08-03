package com.parkinglot;
import java.util.*;

public class ParkingLot {
    private final List<ParkingFloor> floors;
    private static volatile ParkingLot instance; // Singleton instance (thread-safe)

    private ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public static ParkingLot getInstance(List<ParkingFloor> floors) {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot(floors);
                }
            }
        }
        return instance;
    }

    public static ParkingLot getInstance() {
        if (instance == null)
            throw new IllegalStateException("ParkingLot is not initialized yet.");

        return instance;
    }

    public Optional<ParkingSpot> parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.getAvailableSpot(vehicle);
            if (spot.isPresent()) {
                spot.get().assignVehicle(vehicle);
                System.out.println("Parked " + vehicle.getNumberPlate() + " at spot " + spot.get().getSpotId());
                return spot;
            }
        }
        System.out.println("No available spot for " + vehicle.getNumberPlate());
        return Optional.empty();
    }

    public void unparkVehicle(ParkingSpot spot) {
        if (!spot.isAvailable()) {
            System.out.println("Vehicle " + spot.getVehicle().getNumberPlate() + " left from spot " + spot.getSpotId());
            spot.removeVehicle();
        }
    }
}
