package main.outils;

public class OutilsEntites {

    public static int distanceEntreDeux(int x1, int y1, int x2, int y2) {
        int distance1 = x1 + y1;
        int distance2 = x2 + y2;

        int distanceFinal = distance1 - distance2;

        if(distanceFinal < 0)
            return -distanceFinal;
        else
            return distanceFinal;
    }
}
