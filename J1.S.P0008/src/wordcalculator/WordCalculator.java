/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcalculator;

import java.util.ArrayList;
import java.util.StringTokenizer;
import uyen.ulti.InputTool;
import data.Word;

/**
 *
 * @author SE140355
 */
public class WordCalculator {

    public static boolean checkYN(String inMsg) {
        while (true) {
            String result = InputTool.getString(inMsg, "Error!");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }

    private static boolean isExist(String searchWord, ArrayList<Word> list) {
        if (list.isEmpty()) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWord().equalsIgnoreCase(searchWord)) {
                return true;
            }
        }

        return false;
    }

    private static Word searchWordObject(String searchWord, ArrayList<Word> list) {
        if (list.isEmpty()) {
            return null;
        }

        for (Word word : list) {
            if (word.getWord().equalsIgnoreCase(searchWord)) {
                return word;
            }
        }

        return null;
    }

    private static ArrayList<Word> calcWords(String content) {
        ArrayList<Word> list = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(content);
        Word tmpWord;
        String word;

        while (stk.hasMoreTokens()) {
            word = stk.nextToken().trim();
            if (isExist(word, list)) {
                tmpWord = searchWordObject(word, list);
                tmpWord.updateCount();
            } else {
                tmpWord = new Word(word);
                list.add(tmpWord);
            }
        }
        return list;
    }

    private static ArrayList<Word> calcLetters(String content) {
        ArrayList<Word> list = new ArrayList<>();
        Word tmpWord;

        for (char c : content.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                continue;
            }
            String word = Character.toString(c);
            if (isExist(word, list)) {
                tmpWord = searchWordObject(word, list);
                tmpWord.updateCount();
            } else {
                tmpWord = new Word(word);
                list.add(tmpWord);
            }
        }

        return list;
    }

    private static void printList(ArrayList<Word> list) {
        System.out.print("{");
        for (Word word : list) {
            System.out.print(word.getWord().toLowerCase() + "=" + word.getCount() + ", ");
        }
        System.out.print("}");
    }

    public static void main(String[] args) {
        String content;
        ArrayList<Word> list;
        while (true) {
            System.out.println("--------------------------------");
            content = InputTool.getString("Enter your content: ", "Error!");
            StringTokenizer tokens = new StringTokenizer(content);
            System.out.println(tokens.countTokens());
            list = calcWords(content);
            printList(list);

            System.out.println();
            list.clear();

            list = calcLetters(content);
            printList(list);

            if (!checkYN("\nDo you want to continue calculating? (Y/N): ")) {
                break;
            }

        }
        System.out.println("Goodbye!");
    }
}
