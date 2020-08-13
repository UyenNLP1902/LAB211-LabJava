/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {
    
    private ArrayList<User> userList = new ArrayList<>();
    
    public Manager() throws IOException {
        loadFile("user.dat");
    }
    
    public void addAccount() {
        String username, password;
        
        while (true) {
            do {
                username = InputTool.getString("Username: ", "Error!");
                if (!Validation.checkUsername(username)) {
                    System.out.println("You must enter at least 5 characters, and no space!");
                }
                if (isUsernameExist(username)) {
                    System.out.println("This username is already existed.");
                }
            } while (!Validation.checkUsername(username) || isUsernameExist(username));
            
            do {
                password = InputTool.getString("Password: ", "Error!");
                if (!Validation.checkPassword(password)) {
                    System.out.println("You must enter at least 6 characters, and no space!");
                }
            } while (!Validation.checkPassword(password));
            
            userList.add(new User(username, password));
            
            if (!Validation.checkYN("Do you want to add more account? (Y/N): ", "Error!")) {
                break;
            }
        }
    }
    
    public void login() {
        String username, password;
        User user;
        
        if (userList.isEmpty()) {
            System.out.println("There's no account in the database.");
            return;
        }
        while (true) {            
            System.out.println("------ Login ------");
            
            username = InputTool.getString("Username: ", "Error!");
            password = InputTool.getString("Password: ", "Error!");
            
            user = searchAccountObjectByUsername(username, password);
            
            if (user == null) {
                System.out.println("Invalid username or password.");
            } else {
                
                System.out.println("Login successfully!");
                if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                    break;
                }                
            }
        }        
    }
    
    public void saveFile() throws FileNotFoundException {
        saveFile("user.dat");
    }

    //--------------------------------------------------------------------------
    private void loadFile(String filename) throws FileNotFoundException, IOException {
        StringTokenizer stk;
        String line, username, password;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.readLine() != null) {
                line = br.readLine();
                stk = new StringTokenizer(line, ";");
                username = stk.nextToken();
                password = stk.nextToken();
                if (stk.hasMoreTokens()) {
                    password += stk.nextToken();
                }
                
                userList.add(new User(username, password));
            }
        }
    }
    
    private void saveFile(String filename) throws FileNotFoundException {
        try ( PrintWriter pw = new PrintWriter(filename)) {
            for (User user : userList) {
                String s = user.getUsername() + ";" + user.getPassword();
                pw.println(s);
            }
        }
    }
    
    private boolean isUsernameExist(String username) {
        if (userList.isEmpty()) {
            return false;
        }
        
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }
    
    private User searchAccountObjectByUsername(String username, String password) {
        if (userList.isEmpty()) {
            return null;
        }
        
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        
        return null;
    }
}
