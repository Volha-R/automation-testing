package by.epam.training.errorexceptions;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    private String fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    public List<Double> extractNumbers() {
        List<Double> numbersFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(",");
                for (String number : numbers) {
                    double parsedNumber = Double.parseDouble(number);
                    if (parsedNumber == Double.POSITIVE_INFINITY || parsedNumber == Double.NEGATIVE_INFINITY) {
                        System.out.println("One of provided elements in file is equal to positive or negative infinity");
                        throw new FileParserException("One of provided elements in file longer than maximum or minimum value");
                    }
                    numbersFromFile.add(parsedNumber);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + fileName);
            throw new FileParserException("Required file was not found", e);
        } catch (IOException e) {
            System.out.println("Unexpected failure");
            throw new FileParserException("Unexpected failure", e);
        } catch (NumberFormatException e) {
            System.out.println("One of provided elements in file can not be parsed");
            throw new FileParserException("Parsing failed", e);
        } catch (OutOfMemoryError e) {
            System.out.println("Not enough memory");
            throw new FileParserException("Not enough memory", e);
        }

        if (numbersFromFile.isEmpty()) {
            System.out.println("There is no data to parse");
            throw new FileParserException(fileName + " is empty");
        }

        return numbersFromFile;
    }

}

