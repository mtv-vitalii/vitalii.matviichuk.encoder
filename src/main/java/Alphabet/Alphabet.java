package Alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    //List<Character> alphabetEnglish=new ArrayList<>();
    //List<Character> symbol=new ArrayList<>();

    public List<Character> getAlphabet() {//Create collection with english alphabet
        List<Character> alphabetEnglish =new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l',
                                        'm','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        return alphabetEnglish;
    }

    public List<Character> getSymbol() {//Create collection of special symbol
        List<Character> symbol=new ArrayList<>(Arrays.asList('.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '));
        return symbol;
    }
}
