/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.strategy;

import com.dhl.tanke.Audio;
import com.dhl.tanke.Bullet;
import com.dhl.tanke.Group;
import com.dhl.tanke.PropertyMgr;
import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月3日
 */
public class LineFireStrategy implements FireStrategy{

	@Override
	public void BulletType(Tanke t) {
		// TODO Auto-generated method stub
		switch (t.dir) {
		case UP:
		case DOWN:
			for(int bx = 1;bx < PropertyMgr.getInt("gamewidth");bx++)
				t.gModel.add(new Bullet(bx, t.by, t.dir, t.group, t.gModel));
			if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
			break;
		case LEFT:
		case RIGHT:
			for(int by = 1;by<PropertyMgr.getInt("gamewidth");by++)
				t.gModel.add(new Bullet(t.bx,by, t.dir, t.group, t.gModel));
			if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		default:
			break;
		}
	}
//	@Override
//	public void fire(BaseTanke t) {
//		switch (t.dir) {
//		case UP:
//		case DOWN:
//			for(int bx = 1;bx<PropertyMgr.getInt("gamewidth");bx++)
//				t.tFrame.bullets.add(t.tFrame.gf.creatBullet(bx, t.by, t.dir, t.group, t.tFrame));
//			if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
//			break;
//		case LEFT:
//		case RIGHT:
//			for(int by = 1;by<PropertyMgr.getInt("gamewidth");by++)
//				t.tFrame.bullets.add(t.tFrame.gf.creatBullet(t.bx,by, t.dir, t.group, t.tFrame));
//			if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
//		default:
//			break;
//		}
//	}
}
