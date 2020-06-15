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
public class TankeTankeCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tanke && o2 instanceof Tanke){
			Tanke tanke1 = (Tanke) o1;
			Tanke tanke2 = (Tanke) o2;
			if(tanke1.getRect().intersects(tanke2.getRect())){
				tanke1.afterPosition();
				tanke2.afterPosition();
			}
		}
		return true;

	}
	
}
