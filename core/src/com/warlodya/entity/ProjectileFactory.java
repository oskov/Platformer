package com.warlodya.entity;

import com.warlodya.ability.Ability;
import com.warlodya.game.GameLogic;

public class ProjectileFactory {
	private static GameLogic game;
	
	public ProjectileFactory(GameLogic g) {
		game=g;
		
	}
	
	public static void CreateProjectile(Projectile p) {
		game.addProjectile(p);
		
	}
	
}
