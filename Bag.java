package sorting;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bag {

    public int size;
    public final int[] intBag;
    public int count = 0;

    public Bag(int number) {
        size = number;
        intBag = new int[size];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addInteger(int number) {
        if (count == size) {
            System.out.println("Bag is full.");
        } else {
            intBag[count] = number;
            count++;
        }
    }

    public void printToFile(String File) {
        try {
            PrintStream p;
            p = new PrintStream(File);
            for (int i = 0; i <= size - 1; i++) {
                p.println(intBag[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sorting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
