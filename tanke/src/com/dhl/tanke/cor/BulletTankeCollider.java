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
public class BulletTankeCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Tanke){
			Bullet bullet = (Bullet) o1;
			Tanke tanke = (Tanke) o2;
			if(bullet.collideWith(tanke))
				return false;
		}else if(o1 instanceof Tanke && o2 instanceof Bullet){
			return collide(o2, o1);
		}
		return true;
	}
	
}
