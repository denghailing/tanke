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
public class FourDirFireStrategy implements FireStrategy{
	@Override
	public void fire(Tanke t) {
		Dir[] dirs = Dir.values();
		for(Dir dir:dirs){
			t.tFrame.bullets.add(t.tFrame.gf.creatBullet(t.bx, t.by, dir, t.group, t.tFrame));
		}
		if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
}
