package main;

import java.io.IOException;

public class Console {
    public static void afficherLentement(String texte, int delai) {
        try {
            for (int i = 0; i < texte.length(); i++) {
                System.out.print(texte.charAt(i));
                Thread.sleep(delai);
            }
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static void nettoyerConsole() {
        try {
            String systemeExploitation = System.getProperty("os.name");

            if(systemeExploitation.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process nouveauProcessus = pb.inheritIO().start();
                nouveauProcessus.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process nouveauProcessus = pb.inheritIO().start();
                nouveauProcessus.waitFor();
            }
            //Runtime.getRuntime().exec("cls");

        } catch(IOException | InterruptedException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }*/

    public static void afficherTableauChar(char[] t) {
        for(int i = 0; i < t.length; i++) {
            System.out.print('\b');
        }

        for(int i = 0; i < t.length; i++) {

            System.out.print(t[i]);
        }


    }

    public static void afficherBarreChargement() {

        char[] barreChargement = {'░', '░', '░', '░', '░', '░', '░', '░', '░', '░'};
        try {
            for(int i = 0; i < barreChargement.length; i++) {
                barreChargement[i] = '█';

                afficherTableauChar(barreChargement);

                Thread.sleep(30);

            }

        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}
