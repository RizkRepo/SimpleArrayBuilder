/**
 * This is the main method for array builder
 * Student Name: Fadi
 * Student Number: Rizk
 * Course: CST8130 302 - Data Structures
 * CET-CS-Level 3
 * Professor James Mwangi PhD.
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("===========Welcome To Array Builder===========");
        Numbers numbers = new Numbers();
        try (Scanner sc = new Scanner(System.in)) {
            boolean willing=true;
            while (willing) {
                displayMenu();

                int choice=0;
                try{
                    choice = sc.nextInt();
                }catch(InputMismatchException e){
                    sc.nextLine();
                }
                switch (choice) {
                    case 1:
                        numbers = new Numbers();
                        System.out.println("Default Array Created");
                        break;
                    case 2:
                        int size = 0;
                        while(size<1) {
                            System.out.println("Enter a size for your array: ");
                            try {
                                size = sc.nextInt();
                                if (size < 1) {System.out.println("Enter positive integer! ");}
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter an integer above zero ");
                                sc.nextLine();
                            }
                        }
                        numbers = new Numbers(size);
                        System.out.println("Array Initialized with size "+size);
                        break;
                    case 3:
                        System.out.println("Enter a positive float");
                        float value = -1;
                        while(value < 0){
                            try {
                                value = sc.nextFloat();
                                if (value < 0) {System.out.println("Enter a positive float! ");}
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a positive float");
                                sc.nextLine();
                            }
                        }
                        numbers.addValue(value);
                        break;
                    case 4:
                        System.out.println(numbers.toString());
                        break;
                    case 5:
                        float avg = numbers.calcAverage();
                        float[] MaxMinMod = numbers.findMaxMin();
                        int factorialMax = numbers.getFactorialMax();
                        System.out.printf("Average: %.2f\n",avg);
                        if (MaxMinMod[2]==-1){
                            System.out.printf("Maximum: %.2f\nMinimum: %.2f\nModulo: Undefined\n",MaxMinMod[0],MaxMinMod[1]);
                        }else {
                            System.out.printf("Maximum: %.2f\nMinimum: %.2f\nModulo: %.2f\n", MaxMinMod[0], MaxMinMod[1], MaxMinMod[2]);
                        }
                        System.out.println("Factorial of Max: "+factorialMax +".00");
                        break;
                    case 6:
                        System.out.println("Bye Bye!");
                        willing=false;
                        break;
                    default:
                        System.out.println("Invalid input, Try again");
                        break;
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Try Again");
        }
    }

    /**
     *A method that displays the menu
     */
    public static void displayMenu(){
        System.out.println("Please Select one of the following options:");
        System.out.println("1. Initialize a default array");
        System.out.println("2. Specify the max size of the array");
        System.out.println("3. Add value to the array");
        System.out.println("4. Display values in the array");
        System.out.println("5. Display average of the values, minimum value, maximum value, max mod min, factorialMax");
        System.out.println("6. Exit");
    }
}