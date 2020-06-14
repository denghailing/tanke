/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.strategy;

import com.dhl.tanke.Audio;
import com.dhl.tanke.Bullet;
import com.dhl.tanke.Group;
import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月3日
 */
public class DefaultFireStrategy implements FireStrategy{
//	@Override
//	public void fire(BaseTanke t) {
//		t.tFrame.bullets.add(t.tFrame.gf.creatBullet(t.bx, t.by, t.dir, t.group, t.tFrame));
//		if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
//	}
	
	@Override
	public void BulletType(Tanke t) {
		t.gModel.bullets.add(new Bullet(t.bx, t.by, t.dir, t.group, t.gModel));
		if(t.group == Group.GOOD){
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		}
	}
}
