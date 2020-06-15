/**
 * Copyright (c) 2013-Now http://denghailing//tanke.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.dhl.tanke.strategy.FireStrategy;

/**
 * 
 * @author DHL
 * @version 2020年5月25日
 */
public class Tanke extends GameObject {
	private static final int SPEED = 5;
	public static int WIDTH = ResourceMg.goodtanku.getWidth();
	public static int HEIGHT = ResourceMg.goodtanku.getHeight();
	private int x, y;
	public Dir dir = Dir.DOWN;
	private boolean MOVING = true;
	Rectangle rect = new Rectangle();
	public int ax;
	public int ay;
	public int bx;
	public int by;
	private boolean living = true;
	private Random random = new Random();
	public FireStrategy fs;
	public GameModel gModel;
	public Tanke(int x, int y, Dir dir, Group group, GameModel gm) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.gModel = gm;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		if (this.group == Group.GOOD) {
			String goodfire = PropertyMgr.getString("goodfs");
			System.out.println("goodfire =" + goodfire);
			try {
				this.fs = (FireStrategy) Class.forName(goodfire).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			String badfire = PropertyMgr.getString("badfs");
			try {
				this.fs = (FireStrategy) Class.forName(badfire).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void BoundsCheck() {
		if (this.x < 2)
			x = 2;
		if (this.y < 28)
			y = 28;
		if (this.x > TankeFrame.GAME_WIDTH - Tanke.WIDTH - 2)
			x = TankeFrame.GAME_WIDTH - Tanke.WIDTH - 2;
		if (this.y > TankeFrame.GAME_HEIGHT - Tanke.HEIGHT - 2)
			y = TankeFrame.GAME_HEIGHT - Tanke.HEIGHT - 2;
	}

	public void die() {
		this.living = false;
	}

	public void fire() {
		fs.BulletType(this);
		//		Dir[] dirs = Dir.values();
		//		for(Dir dir:dirs){
		//			this.tFrame.bullets.add(this.tFrame.gf.creatBullet(this.bx, this.by, dir, this.group, this.tFrame));
		//		}
		//		if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}

	public Dir getDir() {
		return dir;
	}

	public Group getGroup() {
		return group;
	}

	public Rectangle getRect() {
		return rect;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isLiving() {
		return this.living;
	}

	public boolean isMOVING() {
		return MOVING;
	}

	private void move() {
		if (!MOVING)
			return;
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		//randomDir();
		if (this.group == Group.BAD && random.nextInt(100) > 95)
			this.fire();
		if (this.group == Group.BAD && random.nextInt(100) > 95)
			randomDir();
		BoundsCheck();
		//update rect
		rect.x = this.x;
		rect.y = this.y;
		ax = this.x;
		ay = this.y;
	}

	@Override
	public void paint(Graphics g) {
		if (!living)
			gModel.remove(this);
		switch (dir) {
		case LEFT:
			bx = this.x + Tanke.WIDTH / 2 - Bullet.WIDTH / 2 - 40;
			by = this.y + Tanke.HEIGHT / 2 - Bullet.HEIGHT / 2;
			g.drawImage(this.group == Group.GOOD ? ResourceMg.goodtankl : ResourceMg.badtankl, x, y, null);
			break;
		case RIGHT:
			bx = this.x + Tanke.WIDTH / 2 + 25;
			by = this.y + Tanke.HEIGHT / 2 - Bullet.HEIGHT / 2;
			g.drawImage(this.group == Group.GOOD ? ResourceMg.goodtankr : ResourceMg.badtankr, x, y, null);
			break;
		case UP:
			bx = this.x + Tanke.WIDTH / 2 - Bullet.WIDTH / 2;
			by = this.y + Tanke.HEIGHT / 2 - Bullet.HEIGHT / 2 - 34;
			g.drawImage(this.group == Group.GOOD ? ResourceMg.goodtanku : ResourceMg.badtanku, x, y, null);
			break;
		case DOWN:
			bx = this.x + Tanke.WIDTH / 2 - Bullet.WIDTH / 2;
			by = this.y + Tanke.HEIGHT / 2 + 20;
			g.drawImage(this.group == Group.GOOD ? ResourceMg.goodtankd : ResourceMg.badtankd, x, y, null);
			break;
		default:
			break;
		}
		move();
	}

	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setMOVING(boolean mOVING) {
		MOVING = mOVING;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void afterPosition(){
		this.bx = ax;
		this.by = ay;
	}
}
