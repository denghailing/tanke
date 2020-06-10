/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.strategy;

import java.time.format.TextStyle;

import com.dhl.tanke.Audio;
import com.dhl.tanke.Bullet;
import com.dhl.tanke.Dir;
import com.dhl.tanke.Group;
import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月3日
 */
public class FourDirFireStrategy implements FireStrategy{
	@Override
	public void fire(Tanke t) {
		Dir[] dirs = Dir.values();
		for(Dir dir:dirs){
			t.tFrame.bullets.add(new Bullet(t.bx, t.by, dir, t.group, t.tFrame));
		}
		if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
}
