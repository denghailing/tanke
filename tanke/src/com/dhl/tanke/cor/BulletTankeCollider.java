/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.cor;

import com.dhl.tanke.Audio;
import com.dhl.tanke.Bullet;
import com.dhl.tanke.Explode;
import com.dhl.tanke.GameModel;
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
			if(bullet.rect.intersects(tanke.rect)){
				if(bullet.getGroup() == tanke.getGroup()) return false;
				if(bullet.living && tanke.isLiving()){
					tanke.die();
					bullet.die();
					int ex = tanke.getX()+Tanke.WIDTH/2 - Explode.WIDTH/2;
					int ey = tanke.getY()+Tanke.HEIGHT/2 - Explode.HEIGHT/2;
					new Explode(ex, ey);
					new Thread(()-> new Audio("audio/explode.wav").play()).start();
					return true;
				}
				return true;
			}			
		}else if(o1 instanceof Tanke && o2 instanceof Bullet){
			return collide(o2, o1);
		}
		return true;
	}
	
}
