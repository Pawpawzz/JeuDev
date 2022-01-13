package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import main.Personnages;
import main.Terrain;
import main.affichage.AffichageTerrain;
import main.outils.Caracteres;
import static main.Constantes.VALEUR_JOUEUR;
import static main.Constantes.VALEUR_OBSTACLE;
import static main.Constantes.VALEUR_PIEGE;
import static main.Constantes.VALEUR_MIN_ENNEMI;

public class TestPersonnages {
	
	@Test
	public void testDeplacementPossible() {
		Terrain.genererTerrain(5, true);
		
		int[][] terrain = Terrain.recupererTerrain();
		Caracteres.chargerCaracteres();
		
		terrain[2][0] = VALEUR_JOUEUR;
		terrain[1][0] = VALEUR_OBSTACLE;
		terrain[2][1] = VALEUR_PIEGE;
		int[] posJoueur = {2, 0};
		
		AffichageTerrain.afficher();

		assertEquals(false, Personnages.deplacementPossible('g', posJoueur));
		assertEquals(false, Personnages.deplacementPossible('d', posJoueur));
		assertEquals(false, Personnages.deplacementPossible('h', posJoueur));
		assertEquals(true, Personnages.deplacementPossible('b', posJoueur));
		
		terrain[3][0] = VALEUR_MIN_ENNEMI;
		
		assertEquals(false, Personnages.deplacementPossible('b', posJoueur));
	}
}
