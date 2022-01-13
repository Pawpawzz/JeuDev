package main;

import main.outils.Caracteres;
import main.affichage.Menu;
import main.outils.Saisies;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		Saisies.definirScanner(scanner);
		Caracteres.chargerCaracteres();


		Menu.afficherMenuPrincipal();

	}

}
