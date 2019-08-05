package by.epam.training.io.Task5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
            List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/iotraining5.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.indexOf(" ");
                String name = line.substring(0, index);
                String[] grades = line.substring(index + 1).split(" ");
                float total = 0;
                for (String grade : grades) {
                    total = total + Integer.parseInt(grade);
                }
                float average = total / grades.length;

                if (average <= 7.0) {
                    lines.add(line);
                } else {
                    lines.add(line.replace(name, name.toUpperCase()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file");
        } catch (IOException e) {
            System.out.println("Exception occurred while trying to read");
        }

        try (FileWriter writer = new FileWriter("data/iotraining5.txt")) {
            for (String line : lines) {
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while try to write to file");
        }

    }
}
