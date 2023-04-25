package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    private static Scanner input = new Scanner(System.in);

    public static void divider(){
        System.out.println("\n----------------------\n");
    }

    public static int attributeChoice(){
        divider();

        System.out.println("Choose the key attribute to sort the list: ");
        System.out.println("1 - index (int)");
        System.out.println("2 - invoiceNo (String)");
        System.out.println("3 - stockCode (String)");
        System.out.println("4 - description (String)");
        System.out.println("5 - quantity (int)");
        System.out.println("6 - invoiceDate (String)");
        System.out.println("7 - unitPrice (double)");
        System.out.println("8 - customerID (int)");
        System.out.println("9 - country (String)");

        return MenuView.getChoice(1, 11);
    }
    public static int sorterChoice(){
        divider();

        System.out.println("Choose the sorter: ");
        System.out.println("1 - SelectSort");

        return MenuView.getChoice(1, 1);
    }
    public static int orderChoice(){
        divider();

        System.out.println("Choose the key attribute to sort the list: ");
        System.out.println("1 - Asc");
        System.out.println("2 - Desc");

        int choice = MenuView.getChoice(1, 2) == 2 ? -1 : 1 ;

        return choice;
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
