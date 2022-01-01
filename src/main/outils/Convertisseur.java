package main.outils;

public class Convertisseur {
    final static int MIN_VALUE = 48;
    public static int recupererValeurNumerique(String intString) {
        int resultat = 0;

        for(int car = 0; car < intString.length(); car++) {
            resultat *= 10;
            resultat += intString.charAt(car) - 48;

        }

        return resultat;
    }
}
