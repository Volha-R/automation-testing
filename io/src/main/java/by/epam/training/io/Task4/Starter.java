package by.epam.training.io.Task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        List<String> allLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/iotraining4.java"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                char[] currentLine = line.toCharArray();
                int count = 0;
                for (int i = 0; i < currentLine.length; i++) {
                    if (!Character.isWhitespace(currentLine[i])) {
                        count++;
                    } else {
                        if (count > 2) {
                            for (int j = i - count; j < i; j++) {
                                currentLine[j] = Character.toUpperCase(currentLine[j]);
                            }
                        }
                        count = 0;
                    }
                }
                if (count > 2) {
                    for (int j = currentLine.length - count; j < currentLine.length; j++) {
                        currentLine[j] = Character.toUpperCase(currentLine[j]);
                    }
                }
                allLines.add(new String(currentLine));
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while tried to read file");
        }

        try (FileWriter writer = new FileWriter("data/iotraining4.java")) {
            for (String currentLine : allLines) {
                writer.write(currentLine);
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while tried to write to file");
        }
    }

}
