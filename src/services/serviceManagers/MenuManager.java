package services.serviceManagers;

import entities.Menu;
import services.cryptoServices.*;


import java.io.FileNotFoundException;


public class MenuManager{

    public void menuPrint(){
        System.out.println("Наберите цифру соответствующую запросу:");
        for(Menu.menuItem menu : Menu.menuItem.values())
            System.out.println(menu.getMenuItemName());
    }
    public int menuItemSelection(){
        int selectedMenuItemNumber;

        ConsoleManager currentConsoleManager=new ConsoleManager();
        do {

            selectedMenuItemNumber = currentConsoleManager.getConsoleDigitValue();
            if (!menuItemNumberCheck(selectedMenuItemNumber)) System.out.println("Вы ввели некорректное число");
        }
        while (!menuItemNumberCheck(selectedMenuItemNumber));

        return selectedMenuItemNumber;
    }

    public void menuItemRun(int menuItemNumber) throws FileNotFoundException {
        for(Menu.menuItem menu : Menu.menuItem.values()){
            if (menuItemNumber == menu.ordinal()){
                switch (menu){
                    case  menuItem0-> exitFromApp();
                    case  menuItem1-> encryptByKeyRun();
                    case  menuItem2-> decryptByKeyRun();
                    case  menuItem3-> decryptByBruteForceRun();
                    case  menuItem4-> decryptByCalcRun();
                }

            }

        }

    }


    private void encryptByKeyRun() throws FileNotFoundException {
        EncryptByKey encryptByKey = new EncryptByKey();
        encryptByKey.run();
    }
    private void decryptByKeyRun() throws FileNotFoundException {
        DecryptByKey decryptByKey = new DecryptByKey();
        decryptByKey.run();
    }

    private void decryptByBruteForceRun() throws FileNotFoundException {
        DecryptByBruteForce decryptByBruteForce = new DecryptByBruteForce();
        decryptByBruteForce.run();
    }
    private void decryptByCalcRun() throws FileNotFoundException {
        DecryptByCalc decryptByCalc = new DecryptByCalc();
        decryptByCalc.run();
    }
    private void exitFromApp(){
        System.out.println("Выход");

    }
    private boolean menuItemNumberCheck(int selectedMenuItemNumber){
            boolean result=false;
        for(Menu.menuItem menu : Menu.menuItem.values()){
            if (selectedMenuItemNumber == menu.getMenuItemNumber()) {
                result = true;
                break;
            }
        }

        return result;
    }


}
