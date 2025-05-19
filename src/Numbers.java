import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Fadi Rizk
 * Student Number: 041174349
 * Course: CST8130 302 - Data Structures
 * CET-CS-Level 3
 * Professor James Mwangi PhD.
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 */

public class Numbers {
    /**
     * Stores Float values.
     */
    private final Float[] numbers;
    /**
     * Store the number of items currently in the array.
     */
    private int stored = 0;

    /**
     * Default Constructor - creates array of size 4
     */
    public Numbers() {
        numbers = new Float[4];
        stored = 0;
    }

    /**
     * Constructor that initializes the "numbers" array.
     *
     * @param size - Max size of the "numbers" array
     */
    public Numbers(int size) {
        numbers = new Float[size];
        stored = 0;
    }

    /**
     * Adds a value in the array, doubling it first
     *
     * @param value - value to add to array
     */
    public void addValue(float value) {
        if (stored < numbers.length) {
            numbers[stored] = value * 2; // Double the value before storing
            stored++;
            System.out.println("Value Added!");
        } else {
            System.out.println("Array is full, value not added");
        }
    }

    /**
     * Adds multiple float values to the array
     *
     * @param amount - number of values to add
     * @param sc     - Scanner object to read input
     */
    public void addValues(int amount, Scanner sc) {
        if ((amount <= numbers.length) && (amount <= (numbers.length - stored))) {
            for (int i = 0; i < amount; i++) {
                System.out.println("Enter a positive float");
                float value = -1;
                while (value < 0) { // Keep asking until valid positive number entered
                    try {
                        value = sc.nextFloat();
                        if (value < 0) {
                            System.out.println("Enter a positive float! ");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a positive float");
                        sc.nextLine(); // Clear invalid input
                    }
                }
                addValue(value);
            }
        } else {
            System.out.println("Too Many Values for Array");
        }
    }

    /**
     * Calculates the average of all the values in the numbers array.
     *
     * @return float value that represents the average, 0 if array is empty
     */
    public float calcAverage() {
        if (stored != 0) {
            float sum = 0;
            for (int i = 0; i < stored; i++) {
                sum += numbers[i];
            }
            return sum / stored;
        } else return 0;
    }

    /**
     * Finds the Max, Min, and Modulus of the Max and Min, of the numbers array
     *
     * @return float array containing [max, min, modulo]
     */
    public float[] findMaxMin() {
        float max = Float.NEGATIVE_INFINITY;
        float min = Float.POSITIVE_INFINITY;
        float modulo = -1;
        for (int i = 0; i < stored; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        if (max == Float.NEGATIVE_INFINITY) {
            max = 0;
        } // Handle empty array case
        if (min == Float.POSITIVE_INFINITY) {
            min = 0;
        } // Handle empty array case
        if (min != 0) {
            modulo = Math.abs(Math.round(max) % Math.round(min));
        } else {
        } // Calculate modulo if min != 0
        return new float[]{max, min, modulo};
    }

    /**
     * Finds the Factorial of the Max value in array
     *
     * @return int factorial of max value, 0 if array empty
     */
    public int getFactorialMax() {
        float[] MaxMinMod = findMaxMin();
        int max = (int) (MaxMinMod[0]);
        int factorialMax = max;
        for (int i = 1; i < max; i++) { // Calculate factorial
            factorialMax = factorialMax * i;
        }
        return factorialMax;
    }

    /**
     * Builds a string representation of the array contents
     *
     * @return String containing the contents of the array
     */
    public String toString() {
        StringBuilder values = new StringBuilder("Values:\n");
        for (int i = 0; i < stored; i++) {
            values.append(numbers[i]).append("0\n"); // Format each number
        }
        return values.toString();
    }

    /**
     * Reads float values from a file into the array
     * First line contains count of values
     *
     * @param file - name of the file to read from
     */
    public void readFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (line != null) {
                try {
                    int fCheck = Integer.parseInt(line.trim());
                    if (fCheck <= ((numbers.length) - stored)) {
                        while (((line = br.readLine()) != null) && (fCheck != 0)) {
                            numbers[stored] = Float.parseFloat((line.trim())); // Read and store each value
                            stored++;
                            fCheck--;
                        }
                    } else {
                        System.out.println("Array has insufficient space.");
                    }
                    System.out.println("****File read successfully****");
                } catch (InputMismatchException e) {
                    System.out.println("File is improperly formatted");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n======File not found=====\n");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    /**
     * Writes array contents to a file
     * First line contains count of values
     *
     * @param file - name of the file to write to
     */
    public void writeFile(String file) {
        if (stored != 0) {
            System.out.println("Values Printed to File");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(String.valueOf(stored)); // Write count of values
                bw.newLine();
                for (int i = 0; i < stored; i++) {
                    bw.write(String.valueOf(numbers[i])); // Write each value
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error writing file");
            }
        } else {
            System.out.println("No values to write, No file created!");
        }
    }
}