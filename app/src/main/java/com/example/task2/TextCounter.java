package com.example.task2;
public class TextCounter {

    public int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("[ ,.]+");
        return words.length;
    }

    public int countCharacters(String text) {
        return text != null ? text.length() : 0;
    }
}