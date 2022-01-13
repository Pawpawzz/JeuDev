package main.affichage;

import main.*;
import main.outils.Chemin;

import java.util.Scanner;

import static main.outils.Saisies.deplacementSyntaxeValide;
import static main.outils.Saisies.saisieForcee;

public class Menu {

    public static Scanner scanner;

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
        //Chemin.afficherTableau(Terrain.recupererTerrain());
        int[] positionJoueur = Joueur.positionJoueur();
        char direction;

        switch (saisieForcee("1. Se déplacer\n2. Grappin\n3. Charge\n4. Saut", 1, 4)) {
            case 1:

                String deplacement;
                do {
                    System.out.print("Format : nx (n = {g, d, h, v}, x est un nombre) :");
<<<<<<< HEAD
<<<<<<< Updated upstream
                    deplacement = Saisies.prochaineLigne();
=======
                    deplacement = Saisies.nextLine();
>>>>>>> Stashed changes
=======
                    deplacement = scanner.nextLine();
>>>>>>> parent of 21ff9c2 (PUSH)
                }
                while(!deplacementSyntaxeValide(deplacement));
                Joueur.deplacement(deplacement);

                break;

            case 2:

                System.out.print("Quel direction ? : ");
<<<<<<< HEAD
<<<<<<< Updated upstream
                direction = Saisies.prochaineLigne().charAt(0);
=======
                direction = Saisies.nextLine().charAt(0);
>>>>>>> Stashed changes
=======
                direction = scanner.nextLine().charAt(0);
>>>>>>> parent of 21ff9c2 (PUSH)
                Competences.grappin(direction, positionJoueur);
                //Competences.grappin();
                break;
            case 3:
                System.out.print("Quel direction ? : ");
<<<<<<< HEAD
<<<<<<< Updated upstream
                direction = Saisies.prochaineLigne().charAt(0);
=======
                direction = Saisies.nextLine().charAt(0);
>>>>>>> Stashed changes
=======
                direction = scanner.nextLine().charAt(0);
>>>>>>> parent of 21ff9c2 (PUSH)
                Competences.charge(direction, positionJoueur);
                break;
            case 4:
            	System.out.print("Quel direction ? : ");
<<<<<<< HEAD
<<<<<<< Updated upstream
                direction = Saisies.prochaineLigne().charAt(0);
=======
                direction = Saisies.nextLine().charAt(0);
>>>>>>> Stashed changes
=======
                direction = scanner.nextLine().charAt(0);
>>>>>>> parent of 21ff9c2 (PUSH)
                Competences.saut(direction, positionJoueur);
                break;
        }

    }


}
