/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SE140355
 */
public class BinarySearch {

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

    private static boolean checkYN(String inMsg) {
        while (true) {
            String result = getString(inMsg, "Error!");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
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

    private static void sortArrayByBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private static int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        while (true) {
            int size = getArraySize();
            int[] arr = getArrayElement(size);
            print(arr);
            System.out.println("The array: ");
            sortArrayByBubbleSort(arr);
            print(arr);

            System.out.println();

            while (true) {
                int searchValue = getAnInteger("\nEnter search value: ", "Error!");
                int foundPos = binarySearch(arr, searchValue, 0, size - 1);

                if (foundPos != -1) {
                    System.out.println("Found " + searchValue + " at index: " + foundPos);
                } else {
                    System.out.println("Can't find " + searchValue);
                }

                if (!checkYN("Do you want to continue searching? ")) {
                    break;
                }
            }

            if (checkYN("Do you want to creeate another array? ") == false) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("-----------------------------");
            }
        }
    }
}
