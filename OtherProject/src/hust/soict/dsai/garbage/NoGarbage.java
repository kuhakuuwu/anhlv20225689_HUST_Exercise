package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.txt"; // Replace with the actual file path
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            // Read all bytes from the file
            inputBytes = Files.readAllBytes(Paths.get(filename));

            // Start time
            startTime = System.currentTimeMillis();

            // Efficient string concatenation using StringBuilder
            StringBuilder outputString = new StringBuilder();
            for (byte b : inputBytes) {
                outputString.append((char) b);
            }

            // Convert StringBuilder to String
            String finalOutput = outputString.toString();

            // End time
            endTime = System.currentTimeMillis();

            // Print elapsed time
            System.out.println("Time taken (NoGarbage): " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

