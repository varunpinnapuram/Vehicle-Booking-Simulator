package com.vehicle;

public class Van extends Vehicle {
    private int capacity;

    public Van(String id, Location location, int capacity) {
        super(id, location);
        this.capacity = capacity;
    }

    @Override
    public String getType() { return "Van"; }

    @Override
    public boolean canAccept(Booking booking) {
        return booking.getPassengers() <= capacity || booking.isRequiresCargo();
    }
}
