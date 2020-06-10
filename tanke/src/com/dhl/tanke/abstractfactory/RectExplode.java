/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.abstractfactory;

import java.awt.Color;
import java.awt.Graphics;

import com.dhl.tanke.ResourceMg;
import com.dhl.tanke.TankeFrame;

/**
 * 
 * @author DHL
 * @version 2020年6月9日
 */
public class RectExplode extends BaseExplode {
	public static int WIDTH = ResourceMg.explodes[0].getWidth();
	public static int HEIGHT =  ResourceMg.explodes[0].getHeight();
	private int x,y;
	private int step = 0;
	TankeFrame tf = null;
	
	public RectExplode(int x, int y,TankeFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	@Override
	public void paint(Graphics g){
		
		if(step >= ResourceMg.explodes.length){
			tf.explodes.remove(this);
			//tf.INSTANCE.explodes.remove(this);
			System.out.println("step = " + step);
		}else{
			//g.drawImage(ResourceMg.explodes[step++],x,y,null);
			Color color = g.getColor();
			g.setColor(Color.RED);
			g.fillRect(x, y, 10*step, 10*step);
			step++;
			g.setColor(color);
		}	
	}
}
