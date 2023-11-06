package Alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    public List<Character> getAlphabetSmallLetters() {//Create collection with small letters of english alphabet
        List<Character> getAlphabetSmallLetters = new ArrayList<>(Arrays.asList());
        for (char ch = 'a'; ch <= 'z'; ch++) {
            getAlphabetSmallLetters.add(ch);
        }
        return getAlphabetSmallLetters;
    }
    public List<Character> getAlphabetBigLetters() {//Create collection with big letters of english alphabet
        List<Character> getAlphabetBigLetters =new ArrayList<>(Arrays.asList());
        for (char ch= 'A'; ch<='Z';ch++ ){
            getAlphabetBigLetters.add(ch);
        }
        return getAlphabetBigLetters;
    }

    public List<Character> getSymbol() {//Create collection of special symbol
        List<Character> getSymbol=new ArrayList<>(Arrays.asList('.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','\n'));
        return getSymbol;
    }
}
