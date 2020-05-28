/**
 * Copyright (c) 2013-Now http://denghailing//tanke.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
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
	public static int WIDTH = ResourceMg.tankd.getWidth();
	public static int HEIGHT =  ResourceMg.tankd.getHeight();
	private TankeFrame tFrame;
	private int bx;
	private int by;
	private boolean living = true;
	private Random random = new Random();
	private Group group = Group.BAD;
	
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
			bx = this.x+Tanke.WIDTH/2 - Bullet.WIDTH/2-17;
			by = this.y+Tanke.HEIGHT/2 - Bullet.HEIGHT/2 +3;
			g.drawImage(ResourceMg.tankl, x, y, null);
			break;
		case RIGHT:
			bx = this.x+Tanke.WIDTH/2 +13;
			by = this.y+Tanke.HEIGHT/2 - Bullet.HEIGHT/2+4 ;
			g.drawImage(ResourceMg.tankr, x, y, null);
			break;
		case UP:
			bx = this.x+Tanke.WIDTH/2 - Bullet.WIDTH/2+1;
			by = this.y+Tanke.HEIGHT/2 - Bullet.HEIGHT/2 -15;
			g.drawImage(ResourceMg.tanku, x, y, null);
			break;
		case DOWN:
			bx = this.x+Tanke.WIDTH/2 - Bullet.WIDTH/2-2;
			by = this.y+Tanke.HEIGHT/2 + 13;
			g.drawImage(ResourceMg.tankd, x, y, null);
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
		if(random.nextInt() > 8) this.fire();
	}

	private void randomDir() {
		// TODO Auto-generated method stub
		
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
}
