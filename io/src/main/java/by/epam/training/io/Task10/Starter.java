package by.epam.training.io.Task10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/iotraining10.txt"))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                int lastIndexOfLastWord = 0;
                int firstIndexOfLastWord = 0;
                int i = line.length() - 1;
                while (Character.isWhitespace(line.charAt(i))) {
                    i--;
                }
                lastIndexOfLastWord = i;

                while (!Character.isWhitespace(line.charAt(i))) {
                    i--;
                }
                firstIndexOfLastWord = i + 1;
                stringBuilder.append(line, firstIndexOfLastWord, lastIndexOfLastWord + 1);

                int j = 0;
                int firstIndexOfFirstWord = 0;
                int lastIndexOfFirstWord = 0;
                while (Character.isWhitespace(line.charAt(j))) {
                    j++;
                }
                firstIndexOfFirstWord = j;

                while (!Character.isWhitespace(line.charAt(j))) {
                    j++;
                }
                lastIndexOfFirstWord = j - 1;
                stringBuilder.append(line, lastIndexOfFirstWord + 1, firstIndexOfLastWord);
                stringBuilder.append(line, firstIndexOfFirstWord, lastIndexOfFirstWord + 1);
                lines.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file");
        } catch (IOException e) {
            System.out.println("Exception occurred while trying to read");
        }

        try (FileWriter fileWriter = new FileWriter("data/iotraining10.txt")) {
            for (String line : lines) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while trying to write to file");
        }

    }
}
