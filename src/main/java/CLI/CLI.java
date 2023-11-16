package CLI;

import CaesarCipher.CaesarCipher;
import FileService.FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    public static String command;
    public static String path;
    public static int key;
    public void RunProgramWithArguments(String[] args) throws IOException {
                command = args[0];
                path = args[1];
                key = Integer.parseInt(args[2]);
                FileService fileService = new FileService();
                fileService.FileRead(command);
                CaesarCipher caesarCipher = new CaesarCipher();
                caesarCipher.ChoiceOfCommand(command);
                fileService.FileWrite(command, path);
        }

    public void RunProgramFromConsole() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> partsOfInputWords = new ArrayList<>();
        System.out.println("Please insert:");
        System.out.println("command: ENCRYPT/DECRYPT | filePath: path to the file | key ");
        System.out.println("--------------------------------------------------------------");
        String lineFromConsole = scanner.nextLine();
        scanner.close();
        for (String word: lineFromConsole.split(" ")) {
            partsOfInputWords.add(word);
        }
        command=partsOfInputWords.get(0);
        path=partsOfInputWords.get(1);
        key= Integer.parseInt(partsOfInputWords.get(2));
        FileService fileService = new FileService();
        fileService.FileRead(command);
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.ChoiceOfCommand(command);
        fileService.FileWrite(command, path);
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
