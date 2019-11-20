package com.warlodya.game.util;

import java.util.Random;

public class MapGenerator {

    public static int[][] generateMap(int g, int c) {

        int[][] out = new int[50][50];
        Random r = new Random();
        for (int a = 0; a < out.length; a++) {
            for (int b = 0; b < out.length; b++) {
                int rand = r.nextInt(100);
                int res = 0;
                if (rand > g) {
                    if (rand > c) res = 2;
                    else res = 1;
                }
                out[a][b] = res;
            }

        }
        for (int a = 0; a < out.length; a++) {

            out[0][a] = 1;
        }
        return out;
    }
}
