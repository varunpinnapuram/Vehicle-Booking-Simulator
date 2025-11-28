package com.vehicle;

public abstract class Vehicle {
    protected String id;
    protected Location location;
    protected boolean available;

    public Vehicle(String id, Location location) {
        this.id = id;
        this.location = location;
        this.available = true;
    }

    public String getId() { return id; }
    public Location getLocation() { return location; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract String getType();
    public abstract boolean canAccept(Booking booking);

    public void assignTo(Booking booking) {
        this.available = false;
        booking.assignVehicle(this);
    }

    public void completeTrip(Booking booking) {
        this.location = booking.getDropoff();
        this.available = true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%s, loc=%s, available=%s]", getType(), id, location, available);
    }
}
