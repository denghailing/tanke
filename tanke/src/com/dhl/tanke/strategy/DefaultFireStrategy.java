/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.strategy;

import com.dhl.tanke.Audio;
import com.dhl.tanke.Bullet;
import com.dhl.tanke.Group;
import com.dhl.tanke.Tanke;
import com.dhl.tanke.abstractfactory.BaseTanke;

/**
 * 
 * @author DHL
 * @version 2020年6月3日
 */
public class DefaultFireStrategy implements FireStrategy{
	@Override
	public void fire(Tanke t) {
		new Bullet(t.bx, t.by, t.dir, t.group);
		if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
}
