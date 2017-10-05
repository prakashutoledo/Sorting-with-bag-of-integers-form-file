package sorting;

import java.util.Arrays;
public class InsertionSort {
    //Getting total number of comparison while sorting
    int comparison;
    //Calculating total time take to sort integers through a bag of integers from file
    long startTime, endTime, elapsedTime;

    public void sort(int[] arrayInteger) {
        int tempNum;
        startTime = System.currentTimeMillis();
        
        for (int i = 1; i < arrayInteger.length; i++) {
            tempNum = arrayInteger[i];
            int j = i - 1;
            while (j >= 0 && arrayInteger[j] > tempNum) {
                comparison++;
                arrayInteger[j + 1] = arrayInteger[j];
                j = j - 1;
            }
            arrayInteger[j + 1] = tempNum;
            comparison++;
        }  
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
    }
    //Display a array into nicely formatted string   
    public void display(int[] arr) {
        int[] newArr = new int[30];
        System.arraycopy(arr, 0, newArr, 0, newArr.length);
        System.out.println(Arrays.toString(newArr));

    }
}
