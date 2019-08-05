package by.epam.taining.classes;

import by.epam.taining.classes.engines.ElectricalEngine;
import by.epam.taining.classes.engines.Engine;
import by.epam.taining.classes.trains.Locomotive;
import by.epam.taining.classes.trains.Passenger;
import by.epam.taining.classes.trains.PassengerTrain;
import by.epam.taining.classes.types.ElectricalPowerType;
import by.epam.taining.classes.types.PassengerWagonType;
import by.epam.taining.classes.wagons.PassengerWagon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException {
		PassengerTrain train = createPassengerTrain();

		System.out.println("Enter your choice (number):");
		System.out.println("1 - Get passengers count");
		System.out.println("2 - Get baggage count");
		System.out.println("3 - Get wagons sorted by comfort level");
		System.out.println("4 - Get wagons by number of passengers");
		System.out.println("--------------------------------------");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = reader.readLine();
		int choice = Integer.parseInt(userInput);

		switch (choice){
			case 1:
				System.out.println("Passenger number is " + train.getPassengersCount());
				break;
			case 2:
				System.out.println("Baggage count is " + train.getBaggageCount());
				break;
			case 3:
				System.out.println("Wagons sorted by comfort: " + train.getWagonsSortedByComfort());
				break;
			case 4:
				System.out.print("Enter minimum number of passengers: ");
				int minimum = Integer.parseInt(reader.readLine());
				System.out.print("Enter maximum number of passengers: ");
				int maximum = Integer.parseInt(reader.readLine());
				System.out.println("Wagons with this number of passengers are: " + train.getWagonsByNumberOfPassengers(minimum, maximum));
				break;
		}
	}

	private static PassengerTrain createPassengerTrain() {
		Engine engine = new ElectricalEngine(1000, ElectricalPowerType.OVERHEAD_LINES);
		Locomotive locomotive = new Locomotive(engine);
		PassengerTrain train = new PassengerTrain(locomotive);

		train.addWagon(new PassengerWagon(PassengerWagonType.SITTING));
		train.addWagon(new PassengerWagon(PassengerWagonType.SITTING));
		train.addWagon(new PassengerWagon(PassengerWagonType.COUPE));
		train.addWagon(new PassengerWagon(PassengerWagonType.SLEEPING));

		train.addPassenger(1, new Passenger(2));
		train.addPassenger(1, new Passenger(2));
		train.addPassenger(1, new Passenger(3));
		train.addPassenger(1, new Passenger(1));
		train.addPassenger(1, new Passenger(2));
		train.addPassenger(1, new Passenger(0));
		train.addPassenger(1, new Passenger(2));
		train.addPassenger(1, new Passenger(3));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(0));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(1));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(3));
		train.addPassenger(2, new Passenger(2));
		train.addPassenger(3, new Passenger(3));
		train.addPassenger(3, new Passenger(2));
		train.addPassenger(3, new Passenger(3));
		train.addPassenger(3, new Passenger(3));
		train.addPassenger(3, new Passenger(3));
		train.addPassenger(3, new Passenger(3));
		train.addPassenger(3, new Passenger(3));
		train.addPassenger(4, new Passenger(1));
		train.addPassenger(4, new Passenger(2));
		train.addPassenger(4, new Passenger(1));
		train.addPassenger(4, new Passenger(3));
		train.addPassenger(4, new Passenger(1));
		train.addPassenger(4, new Passenger(2));
		train.addPassenger(4, new Passenger(1));
		train.addPassenger(4, new Passenger(2));

		List<Passenger> passengers = Arrays.asList(new Passenger(2), new Passenger(1), new Passenger(4), new Passenger(4), new Passenger(3), new Passenger(3), new Passenger(1), new Passenger(3), new Passenger(3), new Passenger(3), new Passenger(2), new Passenger(3));
		List<PassengerWagon> passengerWagons = Arrays.asList(new PassengerWagon(PassengerWagonType.SITTING), new PassengerWagon(PassengerWagonType.SITTING));
		train.addWaggons(passengerWagons);
		train.addPassengers(5, passengers);

		return train;
	}
}
