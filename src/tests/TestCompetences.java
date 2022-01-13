package tests;

import static main.Constantes.VALEUR_JOUEUR;
import static main.Constantes.VALEUR_OBSTACLE;
import static main.Constantes.VALEUR_PIEGE;
import static main.Constantes.VALEUR_MIN_ENNEMI;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Competences;
import main.Terrain;
import main.outils.Caracteres;
import main.affichage.AffichageTerrain;

public class TestCompetences {
    @Test
    public void TestSaut() {
    	Terrain.genererTerrain(5, true);
		
		int[][] terrain = Terrain.recupererTerrain();
		Caracteres.chargerCaracteres();
		
		terrain[0][0] = VALEUR_JOUEUR;
		terrain[4][4] = VALEUR_JOUEUR;
		terrain[0][4] = VALEUR_JOUEUR;
		terrain[4][0] = VALEUR_JOUEUR;
		terrain[1][0] = VALEUR_OBSTACLE;
		int[] posJoueur1 = {0, 0};
		int[] posJoueur2 = {0, 4};
		int[] posJoueur3 = {4, 4};
		int[] posJoueur4 = {4, 0};
		
		Competences.saut('g', posJoueur1);
		assertEquals(VALEUR_JOUEUR, terrain[0][0]);
		
		Competences.saut('h', posJoueur1);
		assertEquals(VALEUR_JOUEUR, terrain[0][0]);
		
		Competences.saut('d', posJoueur2);
		assertEquals(VALEUR_JOUEUR, terrain[0][4]);
		
		Competences.saut('b', posJoueur3);
		assertEquals(VALEUR_JOUEUR, terrain[4][4]);
		
		Competences.saut('d', posJoueur4);
		assertEquals(VALEUR_JOUEUR, terrain[4][2]);
		
		Competences.saut('h', posJoueur3);
		assertEquals(VALEUR_JOUEUR, terrain[2][4]);
		
		Competences.saut('g', posJoueur2);
		assertEquals(VALEUR_JOUEUR, terrain[0][2]);
		
		Competences.saut('b', posJoueur1);
		assertEquals(VALEUR_JOUEUR, terrain[2][0]);
    }

    @Test
    public void TestGrappin() {
    	Terrain.genererTerrain(5, true);

		int[][] terrain = Terrain.recupererTerrain();
		
		terrain[2][2] = VALEUR_JOUEUR;
		terrain[2][3] = VALEUR_OBSTACLE;
		terrain[3][2] = VALEUR_PIEGE;
		
		terrain[1][2] = VALEUR_MIN_ENNEMI; //en haut
		terrain[0][2] = VALEUR_MIN_ENNEMI;
		
		terrain[2][4] = VALEUR_MIN_ENNEMI; //à droite
		
		terrain[4][2] = VALEUR_MIN_ENNEMI; //en bas
		
		terrain[2][0] = VALEUR_MIN_ENNEMI; //à gauche
		
		int[] posJoueur = {2, 2};
		
		Competences.grappin('h', posJoueur);
		assertEquals(VALEUR_MIN_ENNEMI, terrain[1][2]);
		assertEquals(VALEUR_MIN_ENNEMI, terrain[0][2]);
		
		Competences.grappin('d', posJoueur);
		assertEquals(VALEUR_MIN_ENNEMI, terrain[2][4]);
		
		Competences.grappin('b', posJoueur);
		assertEquals(0, terrain[4][2]);
		
		Competences.grappin('g', posJoueur);
		assertEquals(VALEUR_MIN_ENNEMI, terrain[2][1]);
		assertEquals(0, terrain[2][0]);
    }

    @Test
    public void TestCharge() {
    	Terrain.genererTerrain(5, true);
		
		int[][] terrain = Terrain.recupererTerrain();
		
		terrain[2][2] = VALEUR_JOUEUR;
		
		terrain[1][2] = VALEUR_MIN_ENNEMI; //en haut
		
		terrain[2][3] = VALEUR_MIN_ENNEMI; //à droite
		terrain[2][4] = VALEUR_OBSTACLE;
		
		
		terrain[3][2] = VALEUR_MIN_ENNEMI; //en bas
		terrain[4][2] = VALEUR_PIEGE;
		
		int[] posJoueur = {2, 2};
		
		Competences.charge('h', posJoueur);
		assertEquals(VALEUR_MIN_ENNEMI, terrain[0][2]);
		
		Competences.charge('d', posJoueur);
		assertEquals(VALEUR_MIN_ENNEMI, terrain[2][3]);
		
		Competences.charge('b', posJoueur);
		assertEquals(0, terrain[3][2]);
		
    }
}
