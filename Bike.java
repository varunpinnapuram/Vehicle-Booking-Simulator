package com.vehicle;

public class Bike extends Vehicle {
    public Bike(String id, Location location) {
        super(id, location);
    }

    @Override
    public String getType() { return "Bike"; }

    @Override
    public boolean canAccept(Booking booking) {
        return booking.getPassengers() <= 1 && !booking.isRequiresCargo();
    }
}
