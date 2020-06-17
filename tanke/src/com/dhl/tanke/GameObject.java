/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Graphics;

/**
 * 
 * @author DHL
 * @version 2020年6月14日
 */
public abstract class GameObject {
	public int x,y,w,h;
	public Group group;
	public abstract void paint(Graphics g);
}
