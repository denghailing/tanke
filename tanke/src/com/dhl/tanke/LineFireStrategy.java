/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.time.format.TextStyle;

/**
 * 
 * @author DHL
 * @version 2020年6月3日
 */
public class LineFireStrategy implements FireStrategy{
	@Override
	public void fire(Tanke t) {
		switch (t.dir) {
		case UP:
		case DOWN:
			for(int bx = 1;bx<PropertyMgr.getInt("gamewidth");bx++)
				t.tFrame.bullets.add(new Bullet(bx, t.by, t.dir, t.group, t.tFrame));
			if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
			break;
		case LEFT:
		case RIGHT:
			for(int by = 1;by<PropertyMgr.getInt("gamewidth");by++)
				t.tFrame.bullets.add(new Bullet(t.bx, by, t.dir, t.group, t.tFrame));
			if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		default:
			break;
		}


	}
}
