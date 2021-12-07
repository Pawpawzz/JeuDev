package main;

import java.util.Scanner;

public class Main {
<<<<<<< Updated upstream

//	public static void lancerJeu() {
//		//
//		Terrain.GenererTerrain(2);
//	}
=======
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Menu.definirScanner(scanner);
		Menu.afficherMenu();
	}

	public static void lancerJeu() {
		//
		Terrain.GenererTerrain(2);
	}
>>>>>>> Stashed changes

}
