package CaesarCipher;

import Alphabet.Alphabet;
import CLI.CLI;
import FileService.FileService;

import java.io.IOException;
import java.util.List;

public class CaesarCipher {
    private static final int ALPHABET_SIZE = 61;
    private CLI cli = new CLI();
    private int key = cli.getKey();

    public String choiceOfCommand(String command) throws IOException {
        if (command.equalsIgnoreCase("encrypt")) command = encodingText();
        else if (command.equalsIgnoreCase("decrypt")) command = decodingText();
        else System.out.println("You insert something wrong");
        return command;
    }

    public String encodingText() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Alphabet alphabet = new Alphabet();
        FileService fileService = new FileService();
        List<Character> textOfInput = fileService.fileRead(cli.getCommand());
        for (int i = 0; i < textOfInput.size(); i++) {
            int index = alphabet.alphabetLetters().indexOf(textOfInput.get(i));
            if (index != -1) {
                index = (index + key) % ALPHABET_SIZE;
                if (index < 0) {
                    index += ALPHABET_SIZE;
                }
                stringBuilder.append(alphabet.alphabetLetters().get(index));
                if (index == ALPHABET_SIZE) {
                    stringBuilder.append(alphabet.alphabetLetters().get(key - 1));
                }
            } else stringBuilder.append((textOfInput.get(i)));
        }
        return stringBuilder.toString();
    }

    public String decodingText() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Alphabet alphabet = new Alphabet();
        FileService fileService = new FileService();
        List<Character> textOfInput = fileService.fileRead(cli.getCommand());
        for (int i = 0; i < textOfInput.size(); i++) {
            int index = alphabet.alphabetLetters().indexOf(textOfInput.get(i));
            if (index != -1) {
                index = (index - key) % ALPHABET_SIZE;
                if (index < 0) {
                    index += ALPHABET_SIZE;
                }
                stringBuilder.append(alphabet.alphabetLetters().get(index));
            } else stringBuilder.append((textOfInput.get(i)));
        }
        return stringBuilder.toString();
    }
}



