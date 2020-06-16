/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author DHL
 * @version 2020年6月16日
 */
public class Wall extends GameObject{
	int w,h;
	public Rectangle rect;
	public Wall(int x,int y,int w, int h) {
		super();
		this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
		this.rect = new Rectangle(x,y,w,h);
	}
	@Override
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, w, h);
		g.setColor(color);
	}
}
