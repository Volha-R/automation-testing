package by.epam.training.collections;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private Integer capacity;
    private List<Boolean> parkingLots;

    public Parking(Integer parkingCapacity) {
        this.capacity = parkingCapacity;
        this.parkingLots = new ArrayList<>(parkingCapacity);
        for (int i = 0; i < capacity; i++){
            parkingLots.add(false);
        }
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<Boolean> getParkingLots() {
        return parkingLots;
    }

    public int findParkingLot(Integer desiredLot) {
        if (desiredLot <= 0 || desiredLot > parkingLots.size()) {
            throw new IllegalArgumentException("by.epam.training.collections.Parking lot with given number does not exists");
        }

        int i = desiredLot - 1;
        while (i < parkingLots.size() && parkingLots.get(i)) {
            i++;
        }
        if (i == parkingLots.size()) {
            i = 0;
            while (i < desiredLot - 1 && parkingLots.get(i)) {
                i++;
            }
        }
        if (!parkingLots.get(i)) {
            parkingLots.set(i, true);
            return i + 1;
        } else {
            throw new IllegalStateException("Free lot for parking not found");
        }
    }

    public void freeParkingLot(Integer lotNumber) {
        if (lotNumber <= 0 || lotNumber > parkingLots.size()) {
            throw new IllegalArgumentException("by.epam.training.collections.Parking lot with given number does not exists");
        }

        parkingLots.set(lotNumber - 1, false);
    }
}
