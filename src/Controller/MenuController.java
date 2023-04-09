package Controller;

import Service.SorterService;
import View.MenuView;

public class MenuController {
    public static int attributeChosen = -1;
    public static int sorterChosen = -1;
    public static int orderByChosen = -1;

    public static void show(){
        MenuController.attributeChosen = MenuView.firstChoice();

        MenuController.sorterChosen = MenuView.secondChoice(SorterService.getNameSorters());

        MenuController.orderByChosen = MenuView.thirdChoice();
    }
}