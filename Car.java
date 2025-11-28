package com.vehicle;

public class Car extends Vehicle {
    private int capacity;

    public Car(String id, Location location, int capacity) {
        super(id, location);
        this.capacity = capacity;
    }

    @Override
    public String getType() { return "Car"; }

    @Override
    public boolean canAccept(Booking booking) {
        return booking.getPassengers() <= capacity;
    }
}
