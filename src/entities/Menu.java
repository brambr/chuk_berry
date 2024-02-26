package entities;

public class Menu {

    public enum menuItem{
        menuItem0 ("0 - Выйти из программы",0),
        menuItem1("1 - Зашифровать текст по ключу", 1),
        menuItem2("2 - Расшифровать текст по ключу", 2),
        menuItem3("3 - Расшифровать текст путем подбора", 3),
        menuItem4("4 - Расшифровать текст аналитическим путем", 4);
        public String getMenuItemName(){
            return menuItemName;

        }
        public int getMenuItemNumber() {
            return menuItemNumber;
        }

        private String menuItemName;
        private int  menuItemNumber;

        menuItem (String menuItemName, int menuItemNumber){
            this.menuItemName= menuItemName;
            this.menuItemNumber= menuItemNumber;
        }

    }

}

