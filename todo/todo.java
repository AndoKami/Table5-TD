package com.todo;

import java.util.Scanner;

public class todo {
    public static void main(String[] args) {

        System.out.print("Menu :");
        System.out.print("1) Add a next todo");
        System.out.print("2) Find a todo");
        System.out.print("3) Show all todo");
        System.out.print("4) Update a todo");
        System.out.print("5) Delete a todo");
        System.out.print("6) Quit");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice");
        int choice;

        do {
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Add a next todo");
                    break;
                case 2:
                    System.out.print("Find a todo");
                    break;
                case 3:
                    System.out.print("Show all todo");
                    break;
                case 4:
                    System.out.print("Update a todo");
                    break;
                case 5:
                    System.out.print("Delete a todo");
                    break;
                case 6:
                    System.out.print("Quit");
                    break;
            }
        }while (choice < 7);
    }
}
