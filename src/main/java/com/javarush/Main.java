package com.javarush;

import CLI.CLI;


public class Main {
    public static void main(String[] args) throws Throwable {
        CLI cli = new CLI();
        if ((args.length) != 0) {
            String[] args1 = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                args1[i] = args[i];
            }
            cli.runProgramWithArguments(args1);
        } else cli.runProgramFromConsole();
    }
}
