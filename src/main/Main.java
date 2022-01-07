package main;

import main.affichage.AffichagePersonnage;
import main.affichage.AffichageTerrain;
import main.affichage.Caracteres;
import main.affichage.Menu;
import main.outils.Convertisseur;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		Menu.definirScanner(scanner);
		Caracteres.chargerCaracteres();


		Menu.afficherMenuPrincipal();

	}

}
