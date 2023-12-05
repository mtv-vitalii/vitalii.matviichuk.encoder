package CLI;

import CaesarCipher.CaesarCipher;
import FileService.FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CLI {
    private static String command;
    private static String path;
    private static int key;

    public void runProgramWithArguments(String[] args) throws IOException {
        command = args[0];
        path = args[1];
        key = Integer.parseInt(args[2]);
        FileService fileService = new FileService();
        fileService.fileRead(command);
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.choiceOfCommand(command);
        fileService.fileWrite(command);
    }

    public void runProgramFromConsole() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> partsOfInputWords = new ArrayList<>();
        System.out.println("Please insert:");
        System.out.println("command: ENCRYPT/DECRYPT | filePath: path to the file | key ");
        System.out.println("--------------------------------------------------------------");
        String lineFromConsole = scanner.nextLine();
        scanner.close();
        Collections.addAll(partsOfInputWords, lineFromConsole.split(" "));
        command = partsOfInputWords.get(0);
        path = partsOfInputWords.get(1);
        key = Integer.parseInt(partsOfInputWords.get(2));
        FileService fileService = new FileService();
        fileService.fileRead(command);
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.choiceOfCommand(command);
        fileService.fileWrite(command);
    }

    public String getCommand() {
        return this.command;
    }

    public String getPath() {
        return this.path;
    }

    public int getKey() {
        return this.key;
    }
}
