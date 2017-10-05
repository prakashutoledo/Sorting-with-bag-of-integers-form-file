package sorting;
// Writtenn by: Prakash Khadka
// Rocket No: R01406041
/* Allow user to create 3 different name text file one with integers from 1 to
   50000 and its reverse order, and one with  50000 random integers betweeen(1
   to 50000) and print the elapsed time to do insertion sort of the arrays. */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sorting {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        final String firstFile, secondFile, thirdFile;
        int[] arrayInt, reverseArrayInt, randomArrayInt;
        InsertionSort ascendingOrder1, ascendingOrder2, ascendingOrder3;
        Random randNumber;

        Bag bag1 = new Bag(50000);
        Bag bag2 = new Bag(50000);
        Bag bag3 = new Bag(50000);

        firstFile = "file1.txt";
        secondFile = "file2.txt";
        thirdFile = "file3.txt";

        for (int i = 0; i < bag1.size; i++) {
            bag1.addInteger(i + 1);
        }
        bag1.printToFile(firstFile);

        for (int j = bag2.size; j > 0; j--) {
            bag2.addInteger(j);
        }
        bag2.printToFile(secondFile);

        randNumber = new Random();
        for (int k = 0; k < bag3.size; k++) {
            bag3.addInteger(randNumber.nextInt(50000) + 1);
        }
        bag3.printToFile(thirdFile);

        ascendingOrder1 = new InsertionSort();
        arrayInt = readFromFile(firstFile);
        ascendingOrder1.sort(arrayInt);
        System.out.println("Total time to sort integers in " + firstFile
                + " is " + ascendingOrder1.elapsedTime + " milli seconds");
        toStandardTime(ascendingOrder1.elapsedTime);
        System.out.println("Total number of  comparison for sort is "
                + ascendingOrder1.comparison);
        System.out.println("The first 30 sorted numbers from " + firstFile 
                + " are ");
        display(arrayInt);
        System.out.println();

        ascendingOrder2 = new InsertionSort();
        reverseArrayInt = readFromFile(secondFile);
        ascendingOrder2.sort(reverseArrayInt);
        System.out.println("Total time to sort integers in " + secondFile
                + " is " + ascendingOrder2.elapsedTime + " milli seconds.");
        toStandardTime(ascendingOrder2.elapsedTime);
        System.out.println("Total number of comparison for sort is "
                + ascendingOrder2.comparison + ".");
        System.out.println("The first 30 sorted numbers from " + secondFile
                + " are ");
        display(reverseArrayInt);
        System.out.println();

        ascendingOrder3 = new InsertionSort();
        randomArrayInt = readFromFile(thirdFile);
        ascendingOrder3.sort(randomArrayInt);
        System.out.println("Total time to sort integers in " + thirdFile
                + " is " + ascendingOrder3.elapsedTime + " milli seconds.");
        toStandardTime(ascendingOrder3.elapsedTime);
        System.out.println("Total number of comparison for sort is "
                + ascendingOrder3.comparison + ".");
        System.out.println("The first 30 sorted numbers from " + thirdFile
                + " are ");
        display(randomArrayInt);
        System.out.println();
    }

    public static int[] readFromFile(String file) {
        int[] arr;
        int i;
        arr = new int[50000];
        try {
            File newFile = new File(file);
            Scanner reader = new Scanner(newFile);
            i = 0;
            while (reader.hasNextInt()) {
                arr[i] = reader.nextInt();
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sorting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public static int[] display(int[] arrayNum) {
        int[] newArr = new int[30];
        System.arraycopy(arrayNum, 0, newArr, 0, newArr.length);
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    public static void toStandardTime(long millis) {
        long second, milliSeconds, minute;
        second = millis / 100;
        milliSeconds = millis % 100;
        minute = second / 60;
        second = second % 60;
        System.out.println("Minute: " + minute + ", Second: " + second
                + ", Millisecond: " + milliSeconds);
    }

}
