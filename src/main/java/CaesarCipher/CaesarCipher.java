package CaesarCipher;

import Alphabet.Alphabet;
import CLI.CLI;
import FileService.FileService;

import java.io.IOException;
import java.util.List;

public class CaesarCipher {
    public static final int ALPHABET_SIZE = 61;
    CLI cli = new CLI();
    int key = cli.getKey();

    public String ChoiceOfCommand(String command) throws IOException {
        //CLI cli = new CLI();
        if (command.equalsIgnoreCase("encrypt")) command = EncodingText();
        else if (command.equalsIgnoreCase("decrypt")) command = DecodingText();
        else System.out.println("You insert something wrong");
        return command;
    }

    public String EncodingText() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Alphabet alphabet = new Alphabet();
        FileService fileService = new FileService();
        List<Character> textOfInput = fileService.FileRead(cli.getCommand());
        for (int i = 0; i < textOfInput.size(); i++) {
            int index = alphabet.AlphabetLetters().indexOf(textOfInput.get(i));
            if (index != -1) {
                index = (index + key) % ALPHABET_SIZE;
                if (index < 0) {
                    index += ALPHABET_SIZE;
                }
                stringBuilder.append(alphabet.AlphabetLetters().get(index));
                if (index == ALPHABET_SIZE) {
                    stringBuilder.append(alphabet.AlphabetLetters().get(key - 1));
                }
            } else stringBuilder.append((textOfInput.get(i)));
        }
        return stringBuilder.toString();
    }

    public String DecodingText() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Alphabet alphabet = new Alphabet();
        FileService fileService = new FileService();
        List<Character> textOfInput = fileService.FileRead(cli.getCommand());
        for (int i = 0; i < textOfInput.size(); i++) {
            int index = alphabet.AlphabetLetters().indexOf(textOfInput.get(i));
            if (index != -1) {
                index = (index - key) % ALPHABET_SIZE;
                if (index < 0) {
                    index += ALPHABET_SIZE;
                }
                stringBuilder.append(alphabet.AlphabetLetters().get(index));
            } else stringBuilder.append((textOfInput.get(i)));
        }
        return stringBuilder.toString();
    }
}



