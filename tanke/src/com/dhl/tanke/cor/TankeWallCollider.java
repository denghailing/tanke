/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.cor;

import com.dhl.tanke.Bullet;
import com.dhl.tanke.GameObject;
import com.dhl.tanke.Tanke;
import com.dhl.tanke.Wall;

/**
 * 
 * @author DHL
 * @version 2020年6月14日
 */
public class TankeWallCollider implements Collider {
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tanke && o2 instanceof Wall){
			Tanke tanke = (Tanke) o1;
			Wall wall = (Wall) o2;
			if(tanke.rect.intersects(wall.rect)){
				tanke.afterPosition();
			}	
		}else if(o1 instanceof Wall && o2 instanceof Tanke){
			return collide(o2, o1);
		}
		return true;
	}
}
