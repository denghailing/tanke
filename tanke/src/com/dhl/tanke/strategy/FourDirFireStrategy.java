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
	public void BulletType(Tanke t) {
		// TODO Auto-generated method stub
		Dir[] dirs = Dir.values();
		for(Dir dir:dirs){
			t.gModel.bullets.add(new Bullet(t.bx, t.by, dir, t.group, t.gModel));
		}
		if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
//	@Override
//	public void fire(Tanke t) {
//		Dir[] dirs = Dir.values();
//		for(Dir dir:dirs){
//			t.tFrame.bullets.add(t.tFrame.gf.creatBullet(t.bx, t.by, dir, t.group, t.tFrame));
//		}
//		if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
//	}
	
}
