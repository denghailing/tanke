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
public class BulletWallCollider implements Collider {
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Wall){
			Bullet bullet = (Bullet) o1;
			Wall wall = (Wall) o2;
			if(bullet.rect.intersects(wall.rect)){
				bullet.die();
				return true;
			}	
		}else if(o1 instanceof Wall && o2 instanceof Bullet){
			return collide(o2, o1);
		}
		return true;
	}
}
