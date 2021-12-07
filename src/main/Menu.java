package main;

import java.util.Scanner;

public class Menu {

    public static Scanner scanner;

    public static void definirScanner(Scanner sc) {
        scanner = sc;
    }


    public static void afficherMenu() {
        int choice;
        System.out.println("Bienvenue dans RodgeLike");

        Console.nettoyerConsole();
        do {

            System.out.println("1. Jouer\n2. Boutique\n3. Règles\n4. Quitter");

            choice = Integer.parseInt(scanner.next());

        } while(choice < 1 || choice > 4);

        switch(choice) {
            case 1:
                System.out.print("Lancement du jeu");
                System.out.println("\uD83D\uDD2B");
                Console.afficherBarreChargement();
                System.out.println();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }

    }


}
