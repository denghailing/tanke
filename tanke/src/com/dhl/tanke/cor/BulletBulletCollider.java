/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.cor;

import com.dhl.tanke.Bullet;
import com.dhl.tanke.GameObject;
import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月14日
 */
public class BulletBulletCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Bullet){
			Bullet b1 = (Bullet) o1;
			Bullet b2 = (Bullet) o2;
			if(b1.getRect().intersects(b2.getRect()))
				return false;
		}
		return true;

	}
	
}
