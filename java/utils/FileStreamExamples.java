/**
 * Note to self on how to read data from/write data to file.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Mike Lowe
 */
public final class FileStreamExamples {

    public static void readFromFile() throws IOException {
        // using old java.io classes
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        // using java.nio classes
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        // using convenience method
        List<String> lines = Files.readAllLines(Paths.get("file.txt"));
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void writeToFile() throws IOException {
        String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // using old java.io classes
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))) {
            writer.write(data);
        }

        // using java.nio classes
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("file.txt"))) {
            writer.write(data);
        }

        // using convenience method
        Files.write(Paths.get("file.txt"), data.getBytes());
    }

}
