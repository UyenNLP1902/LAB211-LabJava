/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    private static String errorMsg = "Error!";
    private ArrayList<Account> accountList = new ArrayList<>();

    public void addUser() {
        String username, password, name, phone, email, address, dob;
        while (true) {
            System.out.println("------ Add User ------");
            do {
                username = InputTool.getString("Username: ", errorMsg);
                if (isUsernameExist(username)) {
                    System.out.println("Username existed!");
                }
            } while (isUsernameExist(username));

            password = InputTool.getString("Password: ", errorMsg);
            name = InputTool.getString("Name: ", errorMsg);

            do {
                phone = InputTool.getString("Phone: ", "Error!");
                if (!Validation.checkPhone(phone)) {
                    System.out.println("Please enter 10-11 numbers.");
                }

                if (isPhoneExist(phone)) {
                    System.out.println("This phone number is already exist!");
                }
            } while (!Validation.checkPhone(phone) || isPhoneExist(phone));

            do {
                email = InputTool.getString("Email: ", "Error!");
                if (!Validation.checkEmail(email)) {
                    System.out.println("Wrong format!");
                }
                if (isEmailExist(email)) {
                    System.out.println("This email is already exist!");
                }
            } while (!Validation.checkEmail(email) || isEmailExist(email));

            address = InputTool.getString("Address: ", errorMsg);

            do {
                dob = InputTool.getString("DOB: ", errorMsg);
                if (!Validation.checkDate(dob)) {
                    System.out.println("Wrong format (dd/MM/yyyy).");
                }
            } while (!Validation.checkDate(dob));

            accountList.add(new Account(username, password, name, phone, email, address, dob));
            System.out.println("Added!\n");

            if (!Validation.checkYN("Do you want to add more accounts? (Y/N): ", errorMsg)) {
                break;
            }
        }
    }

    public void login() {
        String username, password;
        Account account;

        if (accountList.isEmpty()) {
            System.out.println("There's no account in the database.");
            return;
        }

        System.out.println("------ Login ------");

        username = InputTool.getString("Username: ", errorMsg);
        password = InputTool.getString("Password: ", errorMsg);

        account = searchAccountObjectByUsername(username, password);

        if (account == null) {
            System.out.println("Invalid username or password.");
        } else {

            System.out.println("\n------ Welcome ------");
            System.out.println("Hi " + account.getName() + "!");
            if (Validation.checkYN("Do you want to change password now? (Y/N): ", errorMsg)) {
                changePassword(account);
            } else {
                System.out.println("Okay.");
            }

        }

    }

    //--------------------------------------------------------------------------
    private boolean isUsernameExist(String username) {
        if (accountList.isEmpty()) {
            return false;
        }

        for (Account account : accountList) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPhoneExist(String phone) {
        if (accountList.isEmpty()) {
            return false;
        }

        for (Account account : accountList) {
            if (account.getPhone().equalsIgnoreCase(phone)) {
                return true;
            }
        }

        return false;
    }

    private boolean isEmailExist(String email) {
        if (accountList.isEmpty()) {
            return false;
        }

        for (Account account : accountList) {
            if (account.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    private Account searchAccountObjectByUsername(String username, String password) {
        if (accountList.isEmpty()) {
            return null;
        }

        for (Account account : accountList) {
            if (account.getUsername().equalsIgnoreCase(username)
                    && account.getPassword().equals(getEncryption(password))) {
                return account;
            }
        }

        return null;
    }

    private String getEncryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] msgDigest = md.digest(password.getBytes());
            BigInteger bigInt = new BigInteger(1, msgDigest);
            String hashText = bigInt.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }

            return hashText;

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private boolean checkPasswordCorrect(String firstPw, String secondPw) {
        return firstPw.equals(secondPw);
    }

    private void changePassword(Account account) {
        String oldPassword, newPassword, renewPassword;

        do {
            oldPassword = InputTool.getString("Old password: ", errorMsg);
            if (!checkPasswordCorrect(getEncryption(oldPassword), account.getPassword())) {
                System.out.println("Old password is incorrect.");
            }
        } while (!checkPasswordCorrect(getEncryption(oldPassword), account.getPassword()));

        do {
            newPassword = InputTool.getString("New password: ", errorMsg);
            renewPassword = InputTool.getString("Renew password: ", errorMsg);
            if (!checkPasswordCorrect(newPassword, renewPassword)) {
                System.out.println("New password and renew password are not the same.");
            }
        } while (!checkPasswordCorrect(newPassword, renewPassword));

        account.setPassword(getEncryption(newPassword));
        System.out.println("Changed successfully!");
    }
}
