package com.todo.dao;

import com.todo.dao.dao;

import java.util.Scanner;

public class Main {

    public static void showMenu() {
        System.out.println("\n----------------");
        System.out.println("Menu :");
        System.out.println("1) Add a next todo");
        System.out.println("2) Find a todo");
        System.out.println("3) Show all todo");
        System.out.println("4) Update a todo");
        System.out.println("5) Delete a todo");
        System.out.println("6) Quit");
        System.out.println("----------------");
        System.out.print("Enter your choice : ");
    }
    public static void main(String[] args) {
        dao crud  = new dao();

        int choice;

        do {
            showMenu();
            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1 -> System.out.println(crud.insertTodo(
                        new Scanner(System.in).nextLine(),
                        new Scanner(System.in).nextLine(),
                        new Scanner(System.in).nextInt(),
                        new Scanner(System.in).nextBoolean(),
                        new Scanner(System.in).nextLine()
                ));
                case 2 -> System.out.println(crud.showSpecificTodo(new Scanner(System.in).nextInt()));
                case 3 -> System.out.println(crud.showAllTodo());
                case 4 -> System.out.println(crud.updateTodo(
                        new Scanner(System.in).nextInt(),
                        new Scanner(System.in).nextLine(),
                        new Scanner(System.in).nextLine(),
                        new Scanner(System.in).nextInt(),
                        new Scanner(System.in).nextBoolean(),
                        new Scanner(System.in).nextLine()
                ));
                case 5 -> System.out.println(crud.deleteTodo(new Scanner(System.in).nextInt()));
                case 6 -> System.out.print("Quitting ...");
            }
        } while (choice < 6);
    }
}