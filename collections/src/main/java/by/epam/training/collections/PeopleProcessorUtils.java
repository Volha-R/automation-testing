package by.epam.training.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class PeopleProcessorUtils {
    public static Integer deleteEverySecondTillOneLeft(ArrayList<Integer> list) {
        int i = 0;
        Integer currentNumber = 0;
        while (i < list.size()) {
            currentNumber = list.get(i);
            list.add(currentNumber);
            i = i + 2;
        }
        return currentNumber;
    }

    public static Integer deleteEverySecondTillOneLeft(LinkedList<Integer> list) {
        while (list.size() > 1) {
            Integer head = list.poll();
            list.addLast(head);
            list.removeFirst();
        }
        return list.getLast();
    }
}
