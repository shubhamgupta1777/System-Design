package com.parkinglot;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Step 1: Create Parking Spots
        ParkingSpot spot1 = new ParkingSpot("B1", SpotType.BIKE);
        ParkingSpot spot2 = new ParkingSpot("C1", SpotType.CAR);
        ParkingSpot spot3 = new ParkingSpot("T1", SpotType.TRUCK);
        ParkingSpot spot4 = new ParkingSpot("C2", SpotType.CAR);

        List<ParkingSpot> spots = List.of(spot1, spot2, spot3, spot4);

        // Step 2: Create a Parking Floor
        ParkingFloor floor1 = new ParkingFloor(Level.FIRST, spots);

        // Step 3: Initialize Singleton ParkingLot
        ParkingLot parkingLot = ParkingLot.getInstance(List.of(floor1));

        // Step 4: Create Vehicles
        Vehicle bike = VehicleFactory.createVehicle(VehicleType.BIKE, "BIKE-123");
        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "CAR-456");
        Vehicle truck = VehicleFactory.createVehicle(VehicleType.TRUCK, "TRUCK-789");
        Vehicle car2 = VehicleFactory.createVehicle(VehicleType.CAR, "CAR-999");
        Vehicle extraCar = VehicleFactory.createVehicle(VehicleType.CAR, "CAR-EXTRA");
        // Step 5: Try Parking Vehicles
        parkingLot.parkVehicle(bike);   // Should go to B1
        parkingLot.parkVehicle(car);    // Should go to C1
        parkingLot.parkVehicle(truck);  // Should go to T1
        parkingLot.parkVehicle(car2);   // Should go to C2
        parkingLot.parkVehicle(extraCar); // Should fail, no more car spots

        // Step 6: Unpark one vehicle
        parkingLot.unparkVehicle(spot2); // Unpark car from C1

        // Step 7: Try again
        parkingLot.parkVehicle(extraCar); // Should succeed now
    }
}
