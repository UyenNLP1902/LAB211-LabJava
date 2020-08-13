/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import java.util.ArrayList;
import java.util.Calendar;
import uyen.ulti.InputTool;

/**
 *
 * @author SE140355
 */
public class Validation {

    public static boolean checkYN(String inMsg, String errorMsg) {
        while (true) {
            String result = InputTool.getString(inMsg, errorMsg);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }

    public static int checkMark(double mark) {
        if (mark < 0)
            return -1;
        if (mark > 10)
            return 1;
        return 0;
    }
}
