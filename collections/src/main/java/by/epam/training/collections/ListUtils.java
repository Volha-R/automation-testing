package by.epam.training.collections;

import java.util.List;

public class ListUtils {
    public static void sortByGivenNumber(Integer number, List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            while (i < j && list.get(i) < number) {
                i++;
            }
            while (j > i && list.get(j) > number) {
                j--;
            }
            if (i < j) {
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

    }
}
