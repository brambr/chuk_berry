package services.serviceManagers;

import java.util.Scanner;

public class ConsoleManager {
    private String consoleStringValue;
    private int consoleDigitValue;

    public String getConsoleStringValue() {
        readStringFromConsole();
        return consoleStringValue;
    }

    public int getConsoleDigitValue() {
        readDigitFromConsole();
        return consoleDigitValue;
        }

    private void readDigitFromConsole() {
        Scanner consoleScanner = new Scanner(System.in);
        consoleDigitValue = consoleScanner.nextInt();
    }
    private void readStringFromConsole() {
        Scanner consoleScanner = new Scanner(System.in);
        consoleStringValue = consoleScanner.nextLine();
    }
}

