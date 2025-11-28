package com.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Vehicle Booking Simulator - demonstrates OOP (inheritance & polymorphism),
 * Java Collections (ArrayList), and an in-memory nearest-available assignment algorithm.
 *
 * Run: javac -d bin src/com/vehicle/*.java && java -cp bin com.vehicle.Simulator
 */
public class Simulator {
    public static void main(String[] args) throws InterruptedException {
        List<Vehicle> fleet = new ArrayList<>();
        Random rnd = new Random(42);

        for (int i = 1; i <= 3; i++) fleet.add(new Car("CAR-"+i, randomLocation(rnd), 4));
        for (int i = 1; i <= 3; i++) fleet.add(new Bike("BIKE-"+i, randomLocation(rnd)));
        for (int i = 1; i <= 2; i++) fleet.add(new Van("VAN-"+i, randomLocation(rnd), 8));

        AssignmentEngine engine = new AssignmentEngine(fleet);

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(randomLocation(rnd), randomLocation(rnd), 1, false));
        bookings.add(new Booking(randomLocation(rnd), randomLocation(rnd), 3, false));
        bookings.add(new Booking(randomLocation(rnd), randomLocation(rnd), 6, true));
        bookings.add(new Booking(randomLocation(rnd), randomLocation(rnd), 2, false));
        bookings.add(new Booking(randomLocation(rnd), randomLocation(rnd), 1, false));

        System.out.println("Initial fleet:"); engine.printFleetStatus();
        System.out.println("\nProcessing bookings...\n");

        for (Booking b : bookings) {
            System.out.println("Attempting to assign " + b);
            Optional<Vehicle> assigned = engine.assign(b);
            if (assigned.isPresent()) {
                System.out.println("  Assigned vehicle: " + assigned.get().getId() + " (" + assigned.get().getType() + ")");
            } else {
                System.out.println("  No available vehicle found for booking " + b.getId());
            }

            engine.completeBooking(b);
            System.out.println();
            Thread.sleep(200);
        }

        System.out.println("Final fleet:"); engine.printFleetStatus();
    }

    private static Location randomLocation(Random rnd) {
        return new Location(rnd.nextDouble() * 10, rnd.nextDouble() * 10);
    }
}
