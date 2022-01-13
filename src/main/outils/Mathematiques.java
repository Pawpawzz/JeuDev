package main.outils;

public class Mathematiques {
    public static boolean estUnNombre(String nombre) {
        for(int chiffre = 0; chiffre < nombre.length(); chiffre++) {
            if(nombre.charAt(chiffre) < 48 || nombre.charAt(chiffre) > 57)
                return false;
        }
        return true;
    }
}
