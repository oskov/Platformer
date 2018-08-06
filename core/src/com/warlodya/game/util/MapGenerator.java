package com.warlodya.game.util;

import java.util.Random;

public class MapGenerator {

	public static int[][] generateMap(){
		int[][] out=new int [50][50];
		Random r = new Random();
		for(int a=0;a<out.length;a++) {
			for(int b=0;b<out.length;b++) {
				if(r.nextInt(10)>8)out[a][b]=1;
				if(r.nextInt(5)>4)out[a][b]=2;
				
			}
			
		}
		for(int a=0;a<out.length;a++) {
			
			out[0][a]=1;
		}
		return out;
	}
}
