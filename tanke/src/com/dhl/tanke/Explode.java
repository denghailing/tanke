/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * 
 * @author DHL
 * @version 2020年5月25日
 */
public class Explode {
	public static int WIDTH = ResourceMg.explodes[0].getWidth();
	public static int HEIGHT =  ResourceMg.explodes[0].getHeight();
	private int x,y;
	private int step = 0;
	TankeFrame tf = null;
	
	public Explode(int x, int y,TankeFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	public void paint(Graphics g){
		
		if(step >= ResourceMg.explodes.length){
			tf.explodes.remove(this);
			//tf.INSTANCE.explodes.remove(this);
			System.out.println("step = " + step);
		}else{
			g.drawImage(ResourceMg.explodes[step++],x,y,null);
		}	
	}
}
