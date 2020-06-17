/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.decorator;

import java.awt.Graphics;

import com.dhl.tanke.GameObject;

/**
 * 
 * @author DHL
 * @version 2020年6月17日
 */
public abstract class GoDecorator extends GameObject {
	GameObject go;
	public GoDecorator(GameObject go){
		this.go = go;
	}
	@Override
	public abstract void paint(Graphics g);
}
