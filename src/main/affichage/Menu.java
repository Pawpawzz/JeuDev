package main.affichage;

import main.ControlleurCombat;
import main.Joueur;
import main.Main;
import main.Terrain;

import java.util.Scanner;

public class Menu {

    public static Scanner scanner;

    public static void definirScanner(Scanner sc) {
        scanner = sc;
    }

    private static int saisieForcee(String textAffche, int min, int max) {
        //-2 pour signifie que le choix est incorrecte par défaut
        int choix =-2;
        do {
            System.out.println(textAffche);

            String chaineCarChoix = scanner.nextLine();

            //Permet d'empêcher de saisir des lettres ou toute autre caractère n'étant pas un nombre
            if(estUnNombre(chaineCarChoix)) {
                choix = Integer.parseInt(chaineCarChoix);
            }


        } while(choix > max || choix < min);

        return choix;
    }

    public static boolean estUnNombre(String nombre) {
        for(int chiffre = 0; chiffre < nombre.length(); chiffre++) {
            if(nombre.charAt(chiffre) < 48 || nombre.charAt(chiffre) > 57)
                return false;
        }

        return true;
    }

    public static boolean deplacementSyntaxeValide(String deplacement) {
        char directionDeplacement = deplacement.charAt(0);



        if(directionDeplacement == 'h' || directionDeplacement == 'b' || directionDeplacement == 'g' || directionDeplacement == 'd')
            if (estUnNombre(deplacement.substring(1)))
                return true;
            else
                return false;
        else
            return false;
    }

    public static void afficherMenuPrincipal() {
        System.out.println("Bienvenue dans RodgeLike");


        switch(saisieForcee("1. Jouer\n2. Boutique\n3. Tutoriel\n4. Quitter", 1, 4)) {
            case 1:
                System.out.print("Lancement du jeu");
                System.out.println("\uD83D\uDD2B");
                //Console.afficherBarreChargement();

                ControlleurCombat.lancerCombat();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                switch (saisieForcee("Êtes-vous sûr(e) de vouloir quitter ? \n1. Oui\n2. Non", 1, 2)) {
                    case 1:
                        System.out.println("Désolé nous vous rembourserons :(");
                        return;
                    case 2:
                        afficherMenuPrincipal();
                    default:
                        break;
                }

        }
    }

    public static void afficherActionsJoueur() {
        AffichagePersonnage.afficherNombreVie();
        AffichageTerrain.afficher();
        switch (saisieForcee("1. Se déplacer", 1, 3)) {
            case 1:

                String deplacement;
                do {
                    System.out.print("Format : nx (n = {g, d, h, v}, x est un nombre) :");
                    deplacement = scanner.nextLine();
                }
                while(!deplacementSyntaxeValide(deplacement));
                Joueur.deplacement(deplacement);



        }

    }


}
