/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billcalculator;

import java.util.Scanner;

/**
 *
 * @author SE140355
 */
public class BillCalculator {

    private static Scanner sc = new Scanner(System.in);

    private static int getNumberOfBill(String inMsg, String errMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    private static double getMoney(String inMsg, String errMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errMsg);
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

    private static double calcTotal(double[] bills) {
        double total = 0;
        for (int i = 0; i < bills.length; i++) {
            total += bills[i];
        }
        return total;
    }

    private static boolean payMoney(double total, double wallet) {
        return wallet >= total;
    }

    public static void main(String[] args) {
        int size;
        double[] arr;
        double wallet, totalBill;
        String check;

        while (true) {
            System.out.println("\n========= Shopping program =========");
            //get info
            do {
                size = getNumberOfBill("Input number of bill: ", "Error!");
                if (size <= 0) {
                    System.out.println("Please input a positive integer.");
                }
            } while (size <= 0);

            arr = new double[size];

            for (int i = 0; i < arr.length; i++) {
                do {
                    arr[i] = getMoney("Input value of bill " + (i + 1) + ": ", "Error!");
                } while (arr[i] <= 0);
            }

            wallet = getMoney("Input value of wallet: ", "Error!");

            //calculate
            totalBill = calcTotal(arr);
            System.out.println("\nThis is total of bill: " + totalBill);

            if (payMoney(totalBill, wallet)) {
                System.out.println("You can buy it.\n");
            } else {
                System.out.println("You can't buy it.\n");
            }

            if (!checkYN("Do you want to continue calculating? (Y/N): ")) {
                break;
            }
        }

        System.out.println("Goodbye!");
    }
}
