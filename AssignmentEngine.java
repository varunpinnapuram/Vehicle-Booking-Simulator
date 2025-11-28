package com.vehicle;

import java.util.List;
import java.util.Comparator;
import java.util.Optional;

public class AssignmentEngine {
    private final List<Vehicle> fleet;

    public AssignmentEngine(List<Vehicle> fleet) {
        this.fleet = fleet;
    }

    public Optional<Vehicle> assign(Booking booking) {
        return fleet.stream()
            .filter(v -> v.isAvailable() && v.canAccept(booking))
            .min(Comparator.comparingDouble(v -> v.getLocation().distanceTo(booking.getPickup())))
            .map(v -> { v.assignTo(booking); return v; });
    }

    public void completeBooking(Booking booking) {
        Vehicle v = booking.getAssignedVehicle();
        if (v != null) {
            v.completeTrip(booking);
        }
    }

    public void printFleetStatus() {
        System.out.println("Fleet status:");
        for (Vehicle v : fleet) {
            System.out.println("  " + v);
        }
    }
}
