package View;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    private static Scanner input = new Scanner(System.in);
    public static int firstChoice(){
        IView.divider();

        System.out.println("Choose the key attribute to sort the list: ");
        System.out.println("1 - First name (String)");
        System.out.println("2 - Last name (String)");
        System.out.println("3 - Email (String)");
        System.out.println("4 - Product ID (int)");
        System.out.println("5 - Quantity (int)");
        System.out.println("6 - Amount (double)");
        System.out.println("7 - Invoice Date (String)");
        System.out.println("8 - Address (String)");
        System.out.println("9 - City (String)");
        System.out.println("10 - Stock Code (int)");
        System.out.println("11 - Job (String)");

        return MenuView.getChoice(1, 11);
    }
    public static int secondChoice(ArrayList<String> names){
        IView.divider();

        System.out.println("Choose the sorter: ");

        int i = 1;
        for (String name : names) {
            System.out.println(i + " - " + name);
            i++;
        }

        return MenuView.getChoice(1, names.size());
    }
    public static int thirdChoice(){
        IView.divider();

        System.out.println("Choose the key attribute to sort the list: ");
        System.out.println("1 - Asc");
        System.out.println("2 - Desc");

        return MenuView.getChoice(1, 2);
    }

    private static int getChoice(int min, int max){
        int choice;
        while (true) {
            System.out.printf("::  ");
            try {
                choice = input.nextInt();
                if ( choice >= min && choice <= max) break;
                else { System.out.printf("Choose a number between %d and %d. Please try again.\n", min, max); }
            } catch (Exception e) {
                System.out.println("Error reading user input. Please try again.");
                input.nextLine();
            }
        }

        return choice;
    }
}
