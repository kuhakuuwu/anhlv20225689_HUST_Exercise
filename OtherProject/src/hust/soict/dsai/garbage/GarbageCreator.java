package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            // Read all bytes from the file
            inputBytes = Files.readAllBytes(Paths.get(filename));

            // Start time
            startTime = System.currentTimeMillis();

            // Inefficient string concatenation
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }

            // End time
            endTime = System.currentTimeMillis();

            // Print elapsed time
            System.out.println("Time taken (GarbageCreator): " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
        
    

