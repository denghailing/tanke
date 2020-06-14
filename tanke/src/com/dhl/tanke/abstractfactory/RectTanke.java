/**
 * Copyright (c) 2013-Now http://denghailing//tanke.com All rights reserved.
 */
package com.dhl.tanke.abstractfactory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.dhl.tanke.Audio;
import com.dhl.tanke.Bullet;
import com.dhl.tanke.Dir;
import com.dhl.tanke.GameModel;
import com.dhl.tanke.Group;
import com.dhl.tanke.PropertyMgr;
import com.dhl.tanke.ResourceMg;
import com.dhl.tanke.TankeFrame;
import com.dhl.tanke.abstractfactory.BaseTanke;

/**
 * 
 * @author DHL
 * @version 2020年5月25日
 */
public class RectTanke extends BaseTanke {
	private int x,y;
	public Dir dir = Dir.DOWN;	
	private static final int SPEED = 5;
	private boolean MOVING = true;
	public static int WIDTH = ResourceMg.goodtanku.getWidth();
	public static int HEIGHT =  ResourceMg.goodtanku.getHeight();
	public GameModel gm;
	public int bx;
	public int by;
	private boolean living = true;
	private Random random = new Random();
	public Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	public FireStrategy fs;
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public RectTanke(int x, int y, Dir dir,Group group,GameModel gm) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.gm = gm;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		if(this.group == Group.GOOD){
			String goodfire = PropertyMgr.getString("goodfs");
			try {
				this.fs = (FireStrategy)Class.forName(goodfire).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else{
			String badfire = PropertyMgr.getString("badfs");
			try {
				this.fs = (FireStrategy)Class.forName(badfire).newInstance();
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
	@Override
	public void paint(Graphics g){
		if(!living) gm.enemyTank.remove(this);
		switch(dir){
		case LEFT:
			bx = this.x+RectTanke.WIDTH/2 - Bullet.WIDTH/2-40;
			by = this.y+RectTanke.HEIGHT/2 - Bullet.HEIGHT/2;
			//g.drawImage(this.group == Group.GOOD? ResourceMg.goodtankl:ResourceMg.badtankl, x, y, null);
			break;
		case RIGHT:
			bx = this.x+RectTanke.WIDTH/2 +25;
			by = this.y+RectTanke.HEIGHT/2 - Bullet.HEIGHT/2;
			//g.drawImage(this.group == Group.GOOD? ResourceMg.goodtankr:ResourceMg.badtankr, x, y, null);
			break;
		case UP:
			bx = this.x+RectTanke.WIDTH/2 - Bullet.WIDTH/2;
			by = this.y+RectTanke.HEIGHT/2 - Bullet.HEIGHT/2 -34;
			//g.drawImage(this.group == Group.GOOD? ResourceMg.goodtanku:ResourceMg.badtanku, x, y, null);
			break;
		case DOWN:
			bx = this.x+RectTanke.WIDTH/2 - Bullet.WIDTH/2;
			by = this.y+RectTanke.HEIGHT/2 + 20;
			//g.drawImage(this.group == Group.GOOD? ResourceMg.goodtankd:ResourceMg.badtankd, x, y, null);
			break;
		default:
			break;
		}
		Color color = g.getColor();
		if(this.group == Group.BAD)
			g.setColor(Color.RED);
		else if(this.group == Group.GOOD)
			g.setColor(Color.BLUE);
		g.fillRect(x, y, 40, 40);
		g.setColor(color); 
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
		if(this.x > TankeFrame.GAME_WIDTH - RectTanke.WIDTH - 2) x = TankeFrame.GAME_WIDTH- RectTanke.WIDTH - 2;
		if(this.y > TankeFrame.GAME_HEIGHT - RectTanke.HEIGHT - 2) y = TankeFrame.GAME_HEIGHT - RectTanke.HEIGHT - 2;	
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
		//fs.BulletType(this);
		Dir[] dirs = Dir.values();
		for(Dir dir:dirs){
			//this.gm.bullets.add(this.gm.gf.creatBullet(this.bx, this.by, dir, this.group, this.gm));
			this.gm.bullets.add(new Bullet(this.bx, this.by, dir, this.group, this.gm));
		}
		if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}

	public void die() {
		this.living = false;
	}
	public boolean isLiving() {
		return this.living;
	}
}
