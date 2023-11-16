package FileService;

import CLI.CLI;
import CaesarCipher.CaesarCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileService {

    public ArrayList<Character> FileRead(String command) throws IOException {
        CLI cli = new CLI();
        String path= cli.getPath();
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        ArrayList<Character> textOfInput = new ArrayList<>();
        char[] buf = new char[1024];
        int numRead = reader.read(buf);
        while ((numRead != -1)) {
            textOfInput.add(buf[numRead]);
            numRead--;
        }
        reader.close();
        return textOfInput;
    }

    public void FileWrite(String command, String path) throws IOException {
        CLI cli = new CLI();
        CaesarCipher caesarCipher = new CaesarCipher();
        Path fileOut = Files.createFile(Path.of(cli.getPath() + "[" + command + "]"));
        Files.writeString(fileOut, caesarCipher.ChoiceOfCommand(command), StandardOpenOption.APPEND);
    }
}




