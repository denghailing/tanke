/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * 
 * @author DHL
 * @version 2020年5月25日
 */
public class Bullet {
	private static final int BULSPED= 10;
	public static int WIDTH = ResourceMg.bulletd.getWidth();
	public static int HEIGHT =  ResourceMg.bulletd.getHeight();
	private int x,y;
	private Dir dir;
	private boolean living = true;
	TankeFrame tf = null;
	private Group group = Group.BAD;
	
	public Bullet(int x, int y, Dir dir,Group group,TankeFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void collideWith(Tanke tanke) {
		if(this.group == tanke.getGroup()) return;
		//用一个rect来记录子弹的位置
		Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rectangle2 = new Rectangle(tanke.getX() ,tanke.getY(),tanke.WIDTH,tanke.HEIGHT);
		if(rectangle1.intersects(rectangle2)){
			tanke.die();
			this.die();
			tf.explodes.add(new Explode(x, y, tf));
			new Thread(()-> new Audio("audio/explode.wav").play()).start();
		}
	}

	private void die() {
		this.living = false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void move() {
		switch(dir){
		case LEFT:
			x -= BULSPED;
			break;
		case RIGHT:
			x += BULSPED;
			break;
		case UP:
			y -= BULSPED;
			break;
		case DOWN:
			y += BULSPED;
			break;
		}
		if(x<0||y<0||x>TankeFrame.GAME_WIDTH||y > TankeFrame.GAME_HEIGHT) living = false;
	}
	
	public void paint(Graphics g){
		if(!living){
			tf.bullets.remove(this);
		}
		switch(dir){
		case LEFT:
			g.drawImage(ResourceMg.bulletl, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMg.bulletr, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMg.bulletu, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMg.bulletd, x, y, null);
			break;
		default:
			break;
		}
		move();
	}
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
