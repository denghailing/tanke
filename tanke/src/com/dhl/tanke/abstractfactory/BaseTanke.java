/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.abstractfactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.dhl.tanke.Group;

/**
 * 
 * @author DHL
 * @version 2020年6月9日
 */
public abstract class BaseTanke {
	public Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	public abstract void paint(Graphics g);
	public Group getGroup(){
		return this.group;
	}
	public abstract boolean isLiving();
	public abstract void die();
	public abstract int getX();
	public abstract int getY();
}
