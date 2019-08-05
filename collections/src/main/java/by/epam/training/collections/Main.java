package by.epam.training.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        //Collections by.epam.training.collections.Main Task #1

        System.out.println("Set the number of people:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        int peopleCount = Integer.parseInt(userInput);

        ArrayList<Integer> peopleArrayList = new ArrayList<>(peopleCount);
        for (int i = 0; i < peopleCount; i++){
            peopleArrayList.add(i + 1);
        }

        LinkedList<Integer> peopleLinkedList = new LinkedList<>();
        for (int i = 0; i < peopleCount; i++){
            peopleLinkedList.add(i + 1);
        }

        System.out.println(PeopleProcessorUtils.deleteEverySecondTillOneLeft(peopleArrayList));

        System.out.println(PeopleProcessorUtils.deleteEverySecondTillOneLeft(peopleLinkedList));

        //Collections by.epam.training.collections.Main Task #2

        System.out.println("Set list size");
        userInput = reader.readLine();
        int listSize = Integer.parseInt(userInput);
        System.out.println("Set Y");
        userInput = reader.readLine();
        int numberY = Integer.parseInt(userInput);

        List<Integer> numbers = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++){
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            numbers.add(randomNumber);
        }
        ListUtils.sortByGivenNumber(numberY, numbers);
        System.out.println(numbers);

        //Collections by.epam.training.collections.Main Task #3

        Parking parking = new Parking(6);

        System.out.println(parking.findParkingLot(1));
        System.out.println(parking.findParkingLot(5));
        System.out.println(parking.findParkingLot(6));
        System.out.println(parking.findParkingLot(1));
        System.out.println(parking.findParkingLot(2));
        System.out.println(parking.findParkingLot(4));
        parking.freeParkingLot(4);
        System.out.println(parking.getParkingLots());


    }
}
