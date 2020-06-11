/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import com.dhl.tanke.abstractfactory.BaseBullet;

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
		// TODO Auto-generated method stub
		t.tFrame.bullets.add(t.tFrame.gf.creatBullet(t.bx, t.by, t.dir, t.group, t.tFrame));
		if(t.group == Group.GOOD){
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		}
	}
}
