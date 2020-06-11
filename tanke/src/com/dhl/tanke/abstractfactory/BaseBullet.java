/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.abstractfactory;

import java.awt.Graphics;

import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月9日
 */
public abstract class  BaseBullet {
	public abstract void paint(Graphics g);
	public abstract void collideWith(BaseTanke baseTanke);
}
