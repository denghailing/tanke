/**
 * Copyright (c) 2013-Now http://denghailing//tanke.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * 
 * @author DHL
 * @version 2020年5月25日
 */
public class Tanke {
	private int x,y;
	private Dir dir = Dir.DOWN;	
	private static final int SPEED = 5;
	private boolean MOVING = true;
	public static int WIDTH = ResourceMg.goodtanku.getWidth();
	public static int HEIGHT =  ResourceMg.goodtanku.getHeight();
	private TankeFrame tFrame;
	private int bx;
	private int by;
	private boolean living = true;
	private Random random = new Random();
	private Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Tanke(int x, int y, Dir dir,Group group,TankeFrame tFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tFrame = tFrame;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void paint(Graphics g){
		if(!living) tFrame.enemyTank.remove(this);
		switch(dir){
		case LEFT:
			bx = this.x+Tanke.WIDTH/2 - Bullet.WIDTH/2-40;
			by = this.y+Tanke.HEIGHT/2 - Bullet.HEIGHT/2;
			g.drawImage(this.group == Group.GOOD? ResourceMg.goodtankl:ResourceMg.badtankl, x, y, null);
			break;
		case RIGHT:
			bx = this.x+Tanke.WIDTH/2 +25;
			by = this.y+Tanke.HEIGHT/2 - Bullet.HEIGHT/2;
			g.drawImage(this.group == Group.GOOD? ResourceMg.goodtankr:ResourceMg.badtankr, x, y, null);
			break;
		case UP:
			bx = this.x+Tanke.WIDTH/2 - Bullet.WIDTH/2;
			by = this.y+Tanke.HEIGHT/2 - Bullet.HEIGHT/2 -34;
			g.drawImage(this.group == Group.GOOD? ResourceMg.goodtanku:ResourceMg.badtanku, x, y, null);
			break;
		case DOWN:
			bx = this.x+Tanke.WIDTH/2 - Bullet.WIDTH/2;
			by = this.y+Tanke.HEIGHT/2 + 20;
			g.drawImage(this.group == Group.GOOD? ResourceMg.goodtankd:ResourceMg.badtankd, x, y, null);
			break;
		default:
			break;
		}
		move();
	}

	private void move() {
		if(!MOVING) return;
		switch(dir){
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
		if(this.group == Group.BAD && random.nextInt(100) > 95) this.fire();
		if(this.group == Group.BAD && random.nextInt(100) > 95) randomDir();
		BoundsCheck();
		//update rect
		rect.x = this.x;
		rect.y = this.y;
	}

	private void BoundsCheck() {
		if(this.x < 2) x = 2;
		if(this.y < 28) y =28;
		if(this.x > TankeFrame.GAME_WIDTH - Tanke.WIDTH - 2) x = TankeFrame.GAME_WIDTH- Tanke.WIDTH - 2;
		if(this.y > TankeFrame.GAME_HEIGHT - Tanke.HEIGHT - 2) y = TankeFrame.GAME_HEIGHT - Tanke.HEIGHT - 2;	
	}
	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	public Dir getDir() {
		return dir;
	}

	public boolean isMOVING() {
		return MOVING;
	}

	public void setMOVING(boolean mOVING) {
		MOVING = mOVING;
	}

	public void fire() {
		tFrame.bullets.add(new Bullet(this.bx, this.by, this.dir,this.group,this.tFrame));
	}

	public void die() {
		this.living = false;
	}
	public boolean isLiving() {
		return this.living;
	}
}
