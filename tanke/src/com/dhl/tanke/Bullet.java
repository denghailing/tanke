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
	
	public Bullet(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void paint(Graphics g){
		Color color  = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
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
	}
}
