package Alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    public List<Character> AlphabetLetters() {//Create collection with letters of english alphabet and some symbols.
        List<Character> alphabet = new ArrayList<>(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', '.', ',', '«', '»', '"', '\'', ':', '!', ' ', ' '));
        return alphabet;
    }
}
