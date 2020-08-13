/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import java.util.Scanner;

/**
 *
 * @author SE140355
 */
public class InputTool {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inMsg, String errorMsg, int lower, int upper) {
        int n;
        if (lower > upper) {
            int tmp = lower;
            lower = upper;
            upper = tmp;
        }
        while (true) {
            try {
                System.out.print(inMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lower || n > upper) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static String getCode(String inMsg, String errorMsg) {
        String n;
        while (true) {
            System.out.print(inMsg);
            n = sc.nextLine().trim().toUpperCase();
            if (n.length() == 0 || n.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return n;
            }
        }
    }

    public static String getString(String inMsg, String errorMsg) {
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
}
