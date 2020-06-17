/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.dhl.tanke.GameModel;
import com.dhl.tanke.GameObject;

/**
 * 
 * @author DHL
 * @version 2020年6月17日
 */
public class TallDecorator extends GoDecorator {

	public TallDecorator(GameObject go) {
		super(go);
		this.w = go.w;
		this.h = go.h;
		//GameModel.getInstance().add(this);
	}

	@Override
	public void paint(Graphics g) {
		this.x = go.x;
		this.y = go.y;
		go.paint(g);
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawLine(super.go.x, super.go.y,super.go.x+super.go.w,super.go.y+super.go.h);
		g.setColor(color);
	}
}
