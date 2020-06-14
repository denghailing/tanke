/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
import com.dhl.tanke.abstractfactory.BaseBullet;
import com.dhl.tanke.abstractfactory.BaseExplode;

/**
 * 
 * @author DHL
 * @version 2020年5月25日
 */
public class Explode extends GameObject {
	public static int WIDTH = ResourceMg.explodes[0].getWidth();
	public static int HEIGHT =  ResourceMg.explodes[0].getHeight();
	private int x,y;
	private int step = 0;
	GameModel gm = null;
	
	public Explode(int x, int y,GameModel gm) {
		this.x = x;
		this.y = y;
		this.gm = gm;
	}
	@Override
	public void paint(Graphics g){
		
		if(step >= ResourceMg.explodes.length){
			gm.remove(this);
			//tf.INSTANCE.explodes.remove(this);
			System.out.println("step = " + step);
		}else{
			g.drawImage(ResourceMg.explodes[step++],x,y,null);
		}	
	}
}
