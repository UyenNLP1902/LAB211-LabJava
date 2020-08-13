/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author SE140355
 */
public class WordInfo {
    private String word;
    private LinkedList<String> definitions;

    public WordInfo (String word, LinkedList<String> definitions) {
        this.word = word;
        this.definitions = definitions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public LinkedList<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(LinkedList<String> definitions) {
        this.definitions = definitions;
    }
    
    
}
