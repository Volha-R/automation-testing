package by.epam.training.io.Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Starter {
    public static void main(String[] args) {
        //Task 1
        File file = new File("data/iotraining1.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Exception occurred while tried to create file");
        }

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("data/iotraining1.txt"))) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                outputStream.writeInt((random.nextInt(101)));
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while tried to write to file");
        }

        List<Integer> numbers = new ArrayList<>();
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream("data/iotraining1.txt"))) {
            int bytesAvailable = inputStream.available();
            for (int i = 0; i < bytesAvailable / 4; i++) {
                numbers.add(inputStream.readInt());
            }

            Collections.sort(numbers);
        } catch (IOException e) {
            System.out.println("Exception occurred while tried to read file");
        }

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("data/iotraining1.txt", false))) {
            for (Integer number : numbers) {
                outputStream.writeInt(number);
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while tried to write to file");
        }
    }
}
