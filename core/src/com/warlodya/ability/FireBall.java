package com.warlodya.ability;

import com.warlodya.entity.GameEntity;
import com.warlodya.entity.Projectile;
import com.warlodya.entity.ProjectileFactory;

public class FireBall extends Ability {

	FireBall(GameEntity owner) {
		super(owner);
		this.projectile=new Projectile(owner.getX(), owner.getY(), 16f, 16f);
		this.projectile.setDmg(10);
		this.projectile.setLiveTime(5);
		this.projectile.setTimeToDeath(this.projectile.getLiveTime());
		this.projectile.setTextureName("Hp");
	}

	@Override
	protected void cast() {
		ProjectileFactory.CreateProjectile(this.projectile);

	}

}
