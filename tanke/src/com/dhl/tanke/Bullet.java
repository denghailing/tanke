/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
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
public class Bullet {
	private static final int BULSPED= 10;
	private static int WIDTH = 30,HEIGHT = 30;
	private int x,y;
	private Dir dir;
	private boolean live = true;
	TankeFrame tf = null;
	
	public Bullet(int x, int y, Dir dir,TankeFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g){
		if(!live){
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
		if(x<0||y<0||x>TankeFrame.GAME_WIDTH||y > TankeFrame.GAME_HEIGHT) live = false;
	}
}
