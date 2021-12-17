package main.affichage;

public class Caracteres {
    final static int CARACTERES_A_CODER = 255;
    static String[] tableauCaracteres = new String[CARACTERES_A_CODER];


    public static void chargerCaracteres() {
        Caracteres.enregistrerCaractere(0, " ");
        Caracteres.enregistrerCaractere(1, "*");
        Caracteres.enregistrerCaractere(2, "P");
        Caracteres.enregistrerCaractere(200, "x");
    }

    public static void enregistrerCaractere(int valeur, String caractere) {
        tableauCaracteres[valeur] = caractere;
    }

    public static String recupererCaractere(int valeur){
        return tableauCaracteres[valeur];
    }
}
