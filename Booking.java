package com.vehicle;

public class Booking {
    private static int COUNTER = 1;
    private final int id;
    private final Location pickup;
    private final Location dropoff;
    private final int passengers;
    private final boolean requiresCargo;

    private Vehicle assignedVehicle = null;

    public Booking(Location pickup, Location dropoff, int passengers, boolean requiresCargo) {
        this.id = COUNTER++;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.passengers = passengers;
        this.requiresCargo = requiresCargo;
    }

    public int getId() { return id; }
    public Location getPickup() { return pickup; }
    public Location getDropoff() { return dropoff; }
    public int getPassengers() { return passengers; }
    public boolean isRequiresCargo() { return requiresCargo; }

    public void assignVehicle(Vehicle v) { this.assignedVehicle = v; }
    public Vehicle getAssignedVehicle() { return assignedVehicle; }

    @Override
    public String toString() {
        return String.format("Booking#%d[pickup=%s, dropoff=%s, pax=%d, cargo=%s, vehicle=%s]",
            id, pickup, dropoff, passengers, requiresCargo, (assignedVehicle == null ? "(unassigned)" : assignedVehicle.getId()));
    }
}
