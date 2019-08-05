package by.epam.taining.classes.wagons;

import by.epam.taining.classes.trains.Passenger;
import by.epam.taining.classes.types.PassengerWagonType;

import java.util.ArrayList;
import java.util.List;

public class PassengerWagon extends Wagon implements Comparable<PassengerWagon> {
    private static final int WAGON_BASE_WEIGHT = 300;

    private List<Passenger> passengers;
    private final PassengerWagonType wagonType;

    public PassengerWagon(PassengerWagonType wagonType) {
        super(WAGON_BASE_WEIGHT);
        this.wagonType = wagonType;
        this.passengers = new ArrayList<>();
    }

    public PassengerWagonType getWagonType() {
        return wagonType;
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() >= wagonType.getMaxPassengerCount()) {
            throw new IllegalStateException("Maximum count of passengers exceeded");
        } else {
            passengers.add(passenger);
        }
    }

    public void addPassengers(List<Passenger> passengers) {
        if (this.passengers.size() + passengers.size() > wagonType.getMaxPassengerCount()) {
            throw new IllegalStateException("Maximum count of passengers exceeded");
        } else {
            this.passengers.addAll(passengers);
        }
    }

    public int getPassengersCount() {
        return passengers.size();
    }

    public int getBaggageCount() {
        int baggageCount = 0;
        for (Passenger passenger : passengers) {
            baggageCount += passenger.getBaggageCount();
        }
        return baggageCount;
    }

    @Override
    public int compareTo(PassengerWagon otherWagon) {
        if (this.wagonType.getComfortLevel() < otherWagon.getWagonType().getComfortLevel()) {
            return -1;
        }
        if (this.wagonType.getComfortLevel() == otherWagon.getWagonType().getComfortLevel()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Wagon type is " + wagonType + ". " +
                "Number of passengers is " + passengers.size();
    }
}
