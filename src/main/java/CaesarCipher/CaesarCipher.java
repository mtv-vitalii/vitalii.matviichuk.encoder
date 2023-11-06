package CaesarCipher;

import Alphabet.Alphabet;
import FileService.FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CaesarCipher {
    public static final int ALPHABET_SIZE = 26;
    Alphabet alphabet = new Alphabet();
    FileService fileService = new FileService();

    List<Character> alphabetEnglishSmallLetters = alphabet.getAlphabetSmallLetters();
    List<Character> alphabetEnglishBigLetters = alphabet.getAlphabetBigLetters();
    List<Character> Symbols = alphabet.getSymbol();
    List<Character> textOfInput = new ArrayList<>();
    List<String> textCoder = new ArrayList<>();
    int key = 3;
    int code;

    public List<String> getTextFromFile() throws IOException {
        List<String> list = fileService.FileRead("C:\\Users\\matvv\\IdeaProjects\\vitalii.matviichuk.decoder\\src\\test\\test.txt");
        return list;
    }

    public List<Character> convertStringtoCharacter() throws IOException {
        List<Character> result = getTextFromFile().stream()
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        return result;
    }
    public List<String> codingText() throws IOException {
        textOfInput = convertStringtoCharacter();
        for (int j = 0; j < textOfInput.size(); j++) {
            if (alphabetEnglishBigLetters.contains(textOfInput.get(j)))
                textCoder.add(String.valueOf(codingBiglLeters((char) j)));
            else if (alphabetEnglishSmallLetters.contains(textOfInput.get(j)))
                textCoder.add(String.valueOf(codingSmallLeters((char) j)));
            else if (Symbols.contains(textOfInput.get(j)))
                textCoder.add(String.valueOf(textOfInput.get((char) j)));
            else textCoder.add(String.valueOf(textOfInput.get((char) j)));
        }
        return textCoder;
    }

    public Character codingSmallLeters(Character smallLetter){
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            code = i + key;
            if (smallLetter.equals(alphabetEnglishSmallLetters.get(i))) {
                if (code >= ALPHABET_SIZE)
                    smallLetter = alphabetEnglishSmallLetters.get((1 - i - key) % (1 - ALPHABET_SIZE));
                else if ((code >= 0) && (code < ALPHABET_SIZE))
                    smallLetter = alphabetEnglishSmallLetters.get(code);
                else if (code < 0)
                    smallLetter = alphabetEnglishSmallLetters.get(Math.abs(code % ALPHABET_SIZE));
            }
        }
        return smallLetter;
    }

    public Character codingBiglLeters(Character bigLetter){
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            code = i + key;
            if (bigLetter.equals(alphabetEnglishBigLetters.get(i))) {
                if (code >= ALPHABET_SIZE)
                    bigLetter = alphabetEnglishBigLetters.get((1 - i - key) % (1 - ALPHABET_SIZE));
                else if ((code >= 0) && (code < ALPHABET_SIZE))
                    bigLetter = alphabetEnglishBigLetters.get(code);
                else if (code < 0)
                    bigLetter = alphabetEnglishBigLetters.get(Math.abs(code % ALPHABET_SIZE));
            }
        }
        return bigLetter;
    }
}


