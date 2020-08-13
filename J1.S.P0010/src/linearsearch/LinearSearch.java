/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SE140355
 */
public class LinearSearch {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int searchValue, size;
        int[] arr;
        while (true) {
            System.out.println("-----------------------------------------");            
            size = getArraySize();
            arr = getRandomArrayElement(size);

            System.out.println("The array: ");
            printArray(arr);

            while (true) {
                searchValue = getAnInteger("\nEnter search value: ");
                searchElement(searchValue, arr);
                
                
                if (!checkYN("Do you want to continue searching? (Y/N): "))
                    break;
            }
            
            if(!checkYN("Do you want to random another array? (Y/N): "))
                break;
        }
        System.out.println("Goodbye!");
    }

    private static int getAnInteger(String inMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
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
            System.out.print(inMsg);
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }

    private static int[] getRandomArrayElement(int size) {
        Random rand = new Random();
        int arr[] = new int[size];
        //random from 0 to 9
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10);
        }
        return arr;
    }

    private static int getArraySize() {
        int n;
        do {
            n = getAnInteger("Input array size: ");
        } while (n < 0);

        return n;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void searchElement(int seachNumber, int[] arr) {
        boolean found = false;
        System.out.print("Found " + seachNumber + " at index: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == seachNumber) { 
                found = true;
                System.out.print(i + ", ");
            }
        }
        
        System.out.println();
        
        if(found == false)
            System.out.println("Cannot find this value.");
    }

}
