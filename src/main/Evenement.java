package main;

public class Evenement {

    public static void main(String[] args) {
        int tab[][] = new int[10][10];
        parcourBoucle(tab);
    }

    public static void genererUnEvenement() {

    }


    public static void parcourBoucle(int[][] tab) {
        int caseX = 0;


        while(caseX < tab.length) {
            int caseY = 0;
            while(caseY < tab.length) {

                System.out.println(String.format("Valeur [%s][%s]", caseX, caseY));
                caseY++;
            }

            caseX++;
        }
    }
}
