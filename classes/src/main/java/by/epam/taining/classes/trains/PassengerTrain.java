package by.epam.taining.classes.trains;

import by.epam.taining.classes.wagons.PassengerWagon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PassengerTrain extends Train {
    private List<PassengerWagon> wagons;

    public PassengerTrain(Locomotive locomotive) {
        super(locomotive);
        this.wagons = new ArrayList<>();
    }

    public void addWagon(PassengerWagon wagon) {
        this.wagons.add(wagon);
    }

    public void addWaggons(List<PassengerWagon> wagons) {
        this.wagons.addAll(wagons);
    }

    public void addPassenger(int wagonNumber, Passenger passenger) {
        if (wagonNumber > wagons.size()) {
            throw new IllegalStateException("There is no wagon number " + wagonNumber + " in this train");
        }
        this.wagons.get(wagonNumber - 1).addPassenger(passenger);
    }

    public void addPassengers(int wagonNumber, List<Passenger> passengers){
        if (wagonNumber > wagons.size()) {
            throw new IllegalStateException("There is no wagon number " + wagonNumber + " in this train");
        }
        this.wagons.get(wagonNumber - 1).addPassengers(passengers);
    }

    public int getPassengersCount() {
        int passengersCount = 0;
        for (PassengerWagon wagon : wagons) {
            passengersCount += wagon.getPassengersCount();
        }
        return passengersCount;
    }

    public int getBaggageCount() {
        int baggageCount = 0;
        for (PassengerWagon wagon : wagons) {
            baggageCount += wagon.getBaggageCount();
        }
        return baggageCount;
    }

    public List<PassengerWagon> getWagonsSortedByComfort() {
        List<PassengerWagon> wagonsSortedByComfort = new ArrayList<>();
        for (PassengerWagon wagon : wagons) {
            wagonsSortedByComfort.add(wagon);
        }
        Collections.sort(wagonsSortedByComfort);
        return wagonsSortedByComfort;
    }

    public List<PassengerWagon> getWagonsByNumberOfPassengers(int passengerMinNumber, int passengerMaxNumber) {
        List<PassengerWagon> wagonsByPassengerNumber = new ArrayList<>();
        for (int i = 0; i < wagons.size(); i++) {
            int passengerCount = wagons.get(i).getPassengersCount();
            if (passengerMinNumber <= passengerCount && passengerCount <= passengerMaxNumber) {
                wagonsByPassengerNumber.add(wagons.get(i));
            }
        }
        return wagonsByPassengerNumber;
    }

    @Override
    public String toString() {
        return "Passenger Train includes " + wagons.size() + " wagons";
    }
}
