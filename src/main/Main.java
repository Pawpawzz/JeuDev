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
		Terrain.genererTerrain(6);

		AffichagePersonnage.afficherNombreVie(Personnages.recupererVie(), Personnages.recuperMaxVie());
		AffichageTerrain.afficher(Terrain.recupererTerrain());
		Menu.afficherActionsJoueur();
	}

}
