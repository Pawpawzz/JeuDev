package main.affichage;

import main.Constantes;
import main.Terrain;

public class Caracteres {
    final static int CARACTERES_A_CODER = 255;
    static String[] tableauCaracteres = new String[CARACTERES_A_CODER];
    static boolean[] tableauTailleCaracteres = new boolean[CARACTERES_A_CODER];

    public static void chargerCaracteres() {

        //Enregistrement des obstacles et des pieges
        Caracteres.enregistrerCaractere(0, " ");

        Caracteres.enregistrerCaractere(Constantes.VALEUR_OBSTACLE, "◻️", true);
        Caracteres.enregistrerCaractere(Constantes.VALEUR_PIEGE, "🕸️", true);
        //Caracteres.enregistrerCaractere(2, "P");

        Caracteres.enregistrerCaractere(5, "P");

        //Ennemis situé entre 10 et 20
        Caracteres.enregistrerCaractere(10, "\uD83D\uDC2E", true);
        Caracteres.enregistrerCaractere(11, "\uD83C\uDFF9", true);

        Caracteres.enregistrerCaractere(42, "X");
        Caracteres.enregistrerCaractere(200, "x");
        Caracteres.enregistrerCaractere(200, "m");


    }

    public static void enregistrerCaractere(int valeur, String caractere) {
        if(tableauCaracteres[valeur] == null) {
            tableauCaracteres[valeur] = caractere;
            tableauTailleCaracteres[valeur] = false;
        } else {
            System.out.println("[ATTENTION] Impossible d'enregistrer le caractère '" + caractere + "' la place " + valeur + " est déjà prise par '" + tableauCaracteres[valeur] + "'");
        }
    }

    public static void enregistrerCaractere(int valeur, String caractere, boolean surDeuxCaracteres) {
        enregistrerCaractere(valeur, caractere);
        tableauTailleCaracteres[valeur] = surDeuxCaracteres;

    }

    public static String recupererCaractere(int valeur){
        return tableauCaracteres[valeur];
    }

    public static boolean estSurDeuxPlaces(int valeur) {
        return tableauTailleCaracteres[valeur];
    }
}
