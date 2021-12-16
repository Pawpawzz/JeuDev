package main;

import main.terrain.AffichageTerrain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Menu.definirScanner(scanner);
		Menu.afficherMenu();
	}

	public static void lancerJeu() {
		//
		int [][] nouveauTerrain = Terrain.genererTerrain(10);

		AffichageTerrain.afficherTerrain(nouveauTerrain);
	}

}
