/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SE140355
 */
public class SelectionSort {

    private static Scanner sc = new Scanner(System.in);

    private static int getAnInteger(String inMsg, String errorMsg) {
        int n = 0;
        do {
            try {
                System.out.print(inMsg);
                n = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (n < 1);
        return n;
    }

    private static String getString(String inMsg, String errorMsg) {
        String n;
        while (true) {
            System.out.print(inMsg);
            n = sc.nextLine().trim();
            if (n.length() == 0 || n.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return n;
            }
        }
    }

    private static int getArraySize() {
        int n;
        do {
            n = getAnInteger("Input array size: ", "Input again.");
        } while (n < 0);

        return n;
    }

    private static int[] getArrayElement(int size) {
        Random rand = new Random();
        int arr[] = new int[size];
        //random from 0 to 9
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10);
        }
        return arr;
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void sortArrayBySelectionSort(int[] arr) {
        int min_pos;
        for (int i = 0; i < arr.length - 1; i++) {
            min_pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_pos]) {
                    min_pos = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min_pos];
            arr[min_pos] = tmp;
        }

    }

    private static boolean checkYN() {
        while (true) {
            String result = getString("\nDo you want to continue (Y/N)?: ", "Please input again: ");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            int size = getArraySize();
            int[] arr = getArrayElement(size);

            System.out.println("Unsorted array:");
            print(arr);

            System.out.println("\nSorted array:");
            sortArrayBySelectionSort(arr);
            print(arr);

            System.out.println();

            if (checkYN() == false) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("-----------------------------");
            }
        }
    }

}
