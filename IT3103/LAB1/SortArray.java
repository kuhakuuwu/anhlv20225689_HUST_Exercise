import java.util.Scanner;
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;

        System.out.println("Enter the number of elements of the array:");
        size = input.nextInt();
        double[] numbers = new double[size];
        
        int i;
        for (i = 0; i < size; i++) {
            System.out.println("Enter the " + (i + 1) + " element of the array: ");
            numbers[i] = input.nextDouble();
        }

        System.out.print("The input array: " + Arrays.toString(numbers) + "\n");
        Arrays.sort(numbers);
        System.out.print("The sorted array: " + Arrays.toString(numbers) + "\n");

        double sum = 0;
        //For each element in the array
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / size;

        System.out.println("The sum of all elements in array: " + sum);
        System.out.println("The average of all elements in array: " + average);

        input.close();
    }   
}
