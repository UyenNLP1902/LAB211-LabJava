/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccisequence;

import java.util.Scanner;

/**
 *
 * @author SE140355
 */
public class FibonacciSequence {
    
    private static Scanner sc = new Scanner(System.in);

    private static int calcFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return calcFibonacci(n - 2) + calcFibonacci(n - 1);
    }

    public static void main(String[] args) {
        int maxN = 45;
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("The 45 sequence fibonacci:");
            for (int i = 0; i < maxN; i++) {
                System.out.print(calcFibonacci(i) + " ");
            }
            
            System.out.println("\nPress (Y) if you want to exit: ");
            String s = sc.nextLine().trim().toUpperCase();
            if (s.equalsIgnoreCase("Y")) {
                break;
            } 
        }
        System.out.println("Goodbye!");
    }
}
