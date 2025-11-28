# Vehicle Booking Simulator (Java, OOP)

This project demonstrates object-oriented principles (Inheritance & Polymorphism) and an in-memory
assignment algorithm using Java Collections (ArrayList). It models different vehicle types (Car, Bike, Van)
and assigns the nearest available vehicle that satisfies booking constraints.

## Files
- `src/com/vehicle/Vehicle.java` (abstract base)
- `src/com/vehicle/Car.java`
- `src/com/vehicle/Bike.java`
- `src/com/vehicle/Van.java`
- `src/com/vehicle/Location.java`
- `src/com/vehicle/Booking.java`
- `src/com/vehicle/AssignmentEngine.java`
- `src/com/vehicle/Simulator.java` (main demo)
- `README.md` (this file)

## How to build & run
From the project root directory:
```bash
# compile
javac -d bin src/com/vehicle/*.java

# run
java -cp bin com.vehicle.Simulator
```

The simulator will print fleet status, attempt to assign vehicles to bookings using a nearest-available policy,
and display final fleet state. The example uses immediate trip completion for demonstration; in a real simulator,
you would model trip durations and asynchronous availability updates.

## Key concepts demonstrated
- Inheritance and polymorphism (Vehicle subclasses override canAccept)
- Constraint-based assignment logic (capacity, cargo requirements)
- Use of Java Collections (ArrayList) and streaming APIs
- Simple spatial logic (Euclidean distance) for nearest-vehicle selection
