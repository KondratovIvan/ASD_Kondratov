import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lab8 {
    static ArrayList<Integer> A = new ArrayList<Integer>();
    static ArrayList<Integer> B = new ArrayList<Integer>();
    static ArrayList<Integer> onlyA = new ArrayList<Integer>();
    static ArrayList<Integer> onlyB = new ArrayList<Integer>();


    public static void main(String[] args) {
        createArrays();

        Collections.sort(A);
        Collections.sort(B);

        Integer[] arrayA = new Integer[A.size()];
        Integer[] arrayB = new Integer[B.size()];

        arrayA = A.toArray(arrayA);
        arrayB = B.toArray(arrayB);

        //Searching only in A
        for (int number : arrayA) {
            if (Arrays.binarySearch(arrayB, number) < 0) {
                onlyA.add(number);
            }

        }



        //Searching only in B
        for (int number : arrayB) {
            if (Arrays.binarySearch(arrayA, number) < 0) {
                onlyB.add(number);
            }
        }

        //Showing results
        System.out.println("Елементи тільки в А: ");
        onlyA.forEach(number ->
                System.out.println(number));

        System.out.println("Елементи тільки в B: ");
        onlyB.forEach(number ->
                System.out.println(number));
    }

    static void createArrays() {
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(12);
        A.add(8);
        A.add(7);
        A.add(15);
        A.add(14);
        A.add(9);

        B.add(10);
        B.add(9);
        B.add(3);
        B.add(14);
        B.add(6);
        B.add(4);
        B.add(1);
        B.add(8);
        B.add(2);
    }
}