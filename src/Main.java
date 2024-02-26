import services.serviceManagers.MenuManager;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int menuItemNumber;

        MenuManager menuManager = new MenuManager();
        do {
            menuManager.menuPrint();
            menuItemNumber = menuManager.menuItemSelection();
            menuManager.menuItemRun(menuItemNumber);  //файловый сервис для чтения имен файлов и исключений + проверкка на ошибки
        }
            while (menuItemNumber!=0);


    }


}