package main;

import main.affichage.AffichagePersonnage;
import main.affichage.AffichageTerrain;
import main.affichage.Caracteres;
import main.affichage.Menu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Menu.definirScanner(scanner);
		Menu.afficherMenuPrincipal();
	}

	public static void lancerJeu() {
		//
		Caracteres.chargerCaracteres();
		int [][] nouveauTerrain = Terrain.genererTerrain(4);

		AffichagePersonnage.afficherNombreVie(1, 3);
		AffichageTerrain.afficher(nouveauTerrain);
		Menu.afficherActionsJoueur();
	}

}
