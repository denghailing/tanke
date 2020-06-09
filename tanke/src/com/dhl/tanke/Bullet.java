/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.dhl.tanke.abstractfactory.BaseBullet;

/**
 * 
 * @author DHL
 * @version 2020年5月25日
 */
public class Bullet extends BaseBullet {
	private static final int BULSPED= 10;
	public static int WIDTH = ResourceMg.bulletd.getWidth();
	public static int HEIGHT =  ResourceMg.bulletd.getHeight();
	public Rectangle rect = new Rectangle();
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
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
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
		//Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		//Rectangle rectangle2 = new Rectangle(tanke.getX() ,tanke.getY(),tanke.WIDTH,tanke.HEIGHT);
		if(this.living && tanke.isLiving() && this.rect.intersects(tanke.rect)){
			tanke.die();
			this.die();
			int ex = tanke.getX()+tanke.WIDTH/2 - Explode.WIDTH/2;
			int ey = tanke.getY()+Tanke.HEIGHT/2 - Explode.HEIGHT/2;
			tf.explodes.add(tf.gf.creatExplode(ex, ey, tf));
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
		//update rect
		rect.x = this.x;
		rect.y = this.y;
		if(x<0||y<0||x>TankeFrame.GAME_WIDTH||y > TankeFrame.GAME_HEIGHT) living = false;
	}
	@Override
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
