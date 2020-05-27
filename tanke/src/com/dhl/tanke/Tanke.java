/**
 * Copyright (c) 2013-Now http://denghailing//tanke.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;

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
	private boolean MOVING = false;
	private TankeFrame tFrame;
	
	public Tanke(int x, int y, Dir dir,TankeFrame tFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tFrame = tFrame;
	}
	
	public void paint(Graphics g){
		switch(dir){
		case LEFT:
			g.drawImage(ResourceMg.tankl, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMg.tankr, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMg.tanku, x, y, null);
			break;
		case DOWN:
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
		tFrame.bullets.add(new Bullet(this.x, this.y, this.dir,this.tFrame));
	}
}
