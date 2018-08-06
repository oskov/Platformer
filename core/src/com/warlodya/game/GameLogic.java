package com.warlodya.game;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.warlodya.entity.Entity;
import com.warlodya.entity.GameEntity;
import com.warlodya.entity.Player;
import com.warlodya.entity.Projectile;
import com.warlodya.game.util.Const;
import com.warlodya.game.util.MapGenerator;

public class GameLogic {
	private int[][] gameMap;
	private int score;
	private LinkedList<GameEntity> mobList;
	private LinkedList<Projectile> projectileList;

	private Player player;

	public GameLogic() {
		mobList = new LinkedList<GameEntity>();
		projectileList = new LinkedList<Projectile>();
		gameMap = MapGenerator.generateMap();
		player = new Player(100, 100, 16, 16);
		mobList.add(player);
	}

	public void update() {
		mobUpdate();
		moveProjectiles();
	}

	private void mobUpdate() {
		for (GameEntity m : mobList) {
			moveMobs(m);
		}
	}

	private void moveMobs(GameEntity m) {
		if (m.getVectorX() != 0) {
			moveX(m);
		}

		if (m.getVectorY() != 0) {

			moveY(m);
		} else {
			checkFalling(m);

		}

	}

	private void moveX(GameEntity m) {
		float boundposition = m.getX();
		float resultposition = 0;
		if (m.getVectorX() == 1) {
			boundposition += m.getWidth();
		}
		float endPos = boundposition + m.getSpeed() * m.getVectorX();
		int endX = findTileX(endPos);
		int posX = findTileX(boundposition);
		int posYbot = findTileY(m.getY());
		int posYup = findTileY(m.getY() + m.getHeight() * 0.9f);
		int x;
		if (m.getVectorX() == 1) {
			for (x = posX; x <= endX; x++) {
				if (x==gameMap.length||gameMap[posYbot][x] == 1 || gameMap[posYup][x] == 1)
					break;
			}
			resultposition = Math.min(endPos, x * Const.BLOCK_SIZE) - m.getWidth();
		} else if (m.getVectorX() == -1) {
			for (x = posX; x >= endX; x--) {
				if (gameMap[posYbot][x] == 1 || gameMap[posYup][x] == 1) {
					break;
				}
			}
			resultposition = Math.max(endPos, (x + 1) * Const.BLOCK_SIZE);
		}

		m.setX(resultposition);
		if (m.getSpeed() <= m.getMaxSpeed())
			m.setSpeed(m.getSpeed() + m.getAcceleration());else m.setSpeed(m.getMaxSpeed());

	}

	private void checkFalling(GameEntity m) {
		int borderX1 = findTileX(m.getX() + m.getWidth() * 0.1f);
		int borderX2 = findTileX(m.getX() + m.getWidth() * 0.9f);
		int borderY = findTileY(m.getY());
		if (borderY - 1 >= 0 && gameMap[borderY - 1][borderX1] == 0 && gameMap[borderY - 1][borderX2] == 0) {
			m.setVectorY(-1);
			m.setCanJump(false);
			m.setJumped(false);
			m.setTimeInJump(1);
		}

	}

	private void moveY(GameEntity m) {
		float boundposition = m.getY();
		float resultposition = 0;
		float velocity = -m.getTimeInJump() * Const.GRAVITY;
		if (m.isJumped())
			velocity += m.getJumpPower();

		m.setVectorY(velocity > 0 ? 1 : -1);
		if (m.getVectorY() == 1) {
			boundposition += m.getHeight();
		}

		float endPos = boundposition + velocity;
		int endY = findTileY(endPos);
		int posY = findTileY(boundposition);
		int posXleft = findTileX(m.getX() + m.getWidth() * 0.1f);
		int posXright = findTileX(m.getX() + m.getWidth() * 0.9f);
		int y;
		if (m.getVectorY() == 1) {

			for (y = posY; y <= endY; y++) {
				if (y==gameMap.length||gameMap[y][posXleft] == 1 || gameMap[y][posXright] == 1)
					break;
			}
			if (y * Const.BLOCK_SIZE < endPos) {
				m.setVectorY(-1);
				m.setJumped(false);
				m.setTimeInJump(1);
				resultposition = y * Const.BLOCK_SIZE;
			} else {
				resultposition = endPos;
			}
			resultposition -= m.getHeight();

		} else {
			for (y = posY; y >= endY; y--) {
				if (gameMap[y][posXleft] != 0 || gameMap[y][posXright] != 0) {
					m.setVectorY(0);
					m.setCanJump(true);
					m.setJumped(false);
					break;
				}
			}

			resultposition = Math.max(endPos, (y + 1) * Const.BLOCK_SIZE);
		}
		System.out.println("Velocity: " + velocity + "  dY= " + (m.getY() - resultposition) + " Y= " + resultposition);
		m.setY(resultposition);
		m.setTimeInJump(m.getTimeInJump() + 1);

	}

	private void moveProjectiles() {
		// TODO

	}
	
	public void addProjectile(Projectile p) {
		projectileList.add(p);
	}
	

	private Point findTile(Entity e) {

		int x = (int) (e.getX() / Const.BLOCK_SIZE);
		int y = (int) (e.getY() / Const.BLOCK_SIZE);

		Point tile = new Point(x, y);
		return tile;
	}

	private int findTileX(float x) {

		return (int) (x / Const.BLOCK_SIZE);

	}

	private int findTileY(float y) {

		return (int) (y / Const.BLOCK_SIZE);
	}

	public int[][] getGameMap() {
		return gameMap;
	}

	public int getScore() {
		return score;
	}

	public LinkedList<GameEntity> getmobList() {
		LinkedList<GameEntity> entityList = new LinkedList<GameEntity>(mobList);
		return entityList;
	}

	public LinkedList<Projectile> getProjectileList() {
		return new LinkedList<Projectile>(projectileList);
	}

	public Player getPlayer() {
		return player;
	}

	private static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

}
