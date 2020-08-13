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
import java.util.LinkedList;
import java.util.StringTokenizer;
import uyen.ulti.InputTool;

/**
 *
 * @author nguyen
 */
public class Translator {

    LinkedList<WordInfo> dict = new LinkedList<>();

    public Translator() throws IOException {
        loadFile("EngViet.txt");
    }

    //Function 1: add word
    public boolean addWord() {
        String word = InputTool.getString("Enter an English word: ", "Please input a word!");
        String mean = InputTool.getString("Enter Vietnamese meanings (separated by ,): ", "Please input at least one meaning!");
        StringTokenizer stk = new StringTokenizer(mean, ",");

        LinkedList<String> list = new LinkedList<>();
        while (stk.hasMoreTokens()) {
            list.add(stk.nextToken().trim().toLowerCase());
        }
        boolean check = dict.add(new WordInfo(word, list));
        System.out.println("Add  ed!");
        return check;
    }

    //Function 2: remove word
    public void removeWord() {
        String word = InputTool.getString("Enter an English word: ", "Please input a word!");

        int pos = searchForPosition(word);
        if (pos != -1) {
            dict.remove(pos);
            System.out.println("Removed!");
        } else {
            System.out.println("Word not found!");
        }

    }

    //Function 3: translate word
    public void translate() {
        String word = InputTool.getString("Enter an English word: ", "Please input a word!");
        LinkedList<String> list = searchForDefinitions(word);

        if (list == null) {
            System.out.println("Word not found!");
            return;
        }

        System.out.println("Vietnamese meaning: ");
        for (String s : list) {
            System.out.print(s + ", ");
        }
        System.out.println("");
    }
    
    //searchs for definitions in the list
    private LinkedList searchForDefinitions(String searchWord) {
        if (dict.isEmpty()) {
            return null;
        }
        for (WordInfo x : dict) {
            if (x.getWord().equalsIgnoreCase(searchWord)) {
                return x.getDefinitions();
            }
        }
        return null;
    }

    //search for word position in the list
    private int searchForPosition(String searchWord) {
        if (dict.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < dict.size(); i++) {
            if (dict.get(i).getWord().equalsIgnoreCase(searchWord)) {
                return i;
            }
        }
        return -1;
    }

    //saves file 
    public void saveFile() throws FileNotFoundException {
        saveFile("EngViet.txt");
    }

    //saves file
    private void saveFile(String fileName) throws FileNotFoundException {
        try ( PrintWriter pr = new PrintWriter(fileName)) {
            System.out.println("");
            for (WordInfo w : dict) {
                //adds word
                String s = w.getWord() + ":";
                //adds definition
                for (String d : w.getDefinitions()) {
                    s += d + ",";
                }
                
                //saves to file
                pr.println(s);
            }
        }

    }

    //loads file
    private void loadFile(String fileName) throws FileNotFoundException, IOException {
        try ( BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                //seperates word and definition
                StringTokenizer stk = new StringTokenizer(line, ":");
                String word = stk.nextToken().trim();
                String definitionString = stk.nextToken();

                //adds each definition to data
                LinkedList<String> definition = new LinkedList();
                StringTokenizer stk2 = new StringTokenizer(definitionString, ",");
                while (stk2.hasMoreTokens()) {
                    definition.add(stk2.nextToken().trim());
                }

                //adds to list
                dict.add(new WordInfo(word, definition));
            }
        }
    }
}
