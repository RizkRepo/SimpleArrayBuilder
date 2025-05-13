/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Fadi
 * Student Number: Rizk
 * Course: CST8130 302 - Data Structures
 * CET-CS-Level 3
 * Professor James Mwangi PhD.
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 */

public class Numbers {
    /**
     * Stores Float values.
     */
    private Float[] numbers;
    /**
     * Store the number of items currently in the array.
     */
    private int stored=0;
    /**
     * Default Constructor
     */
    Numbers() {
        numbers = new Float[4];
        stored=0;
    }
    /**
     * Constructor that initializes the numbers array.
     * @param size - Max size of the numbers array
     */

    Numbers(int size) {
        numbers = new Float[size];
        stored=0;
    }
    /**
     * Adds a value in the array
     * @param value - value to add to array
     */
    void addValue(float value){
        if(stored<numbers.length) {
            numbers[stored] = value;
            stored++;
            System.out.println("Value Added!");
        }else {
            System.out.println("Array is full, value not added");
        }
    }
    /**
     * Calculates the average of all the values in the numbers array.
     * @return float value that represents the average
     */
    float calcAverage() {
        if (stored != 0) {
            float sum = 0;
            for (int i = 0; i < stored; i++) {
                sum += numbers[i];
            }
            return sum / stored;
        }else return 0;
    }

    /**
     * Finds the Max, Min, and Modulus of the Max and Min, of the numbers array
     * @return float array that contains the Max, Min and Modulus
     */
    float[] findMaxMin(){
        float max= Float.NEGATIVE_INFINITY;
        float min= Float.POSITIVE_INFINITY;
        float modulo =-1;
        for(int i = 0; i<stored; i++){
            if (numbers[i]>max){
                max = numbers[i];
            }
            if (numbers[i]<min){
                min = numbers[i];
            }
        }
        if (max==Float.NEGATIVE_INFINITY){max=0;}
        if (min==Float.POSITIVE_INFINITY){min=0;}
        if(min !=0){modulo = Math.abs(max % min);}else{}
        return new float[]{max, min, modulo};
    }

    /**
     * Finds the Factorial of the Max
     * @return int that contains the factorial of the max of the numbers array
     */
    int getFactorialMax(){
        float[] MaxMinMod = findMaxMin();
        int max = (int) (MaxMinMod[0]);
        int factorialMax=max;
        for(int i = 1; i < max; i++){
            factorialMax = factorialMax*i;
        }
        return factorialMax;
    }

    /**
     * Builds a string of the array
     * @return String containing the contents of the array
     */
    public String toString() {
        StringBuilder values = new StringBuilder("Values:\n");
        for(int i = 0; i<stored; i++){
            values.append(numbers[i]).append("0\n");
        }
        return values.toString();
    }
}
