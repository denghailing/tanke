/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.cor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.dhl.tanke.GameObject;

/**
 * 
 * @author DHL
 * @version 2020年6月15日
 */
public class ColliderChain implements Collider{
	private List<Collider> colliders = new LinkedList<>();
	public ColliderChain(){
		add(new BulletTankeCollider());
		//add(new TankeTankeCollider());
		add(new BulletWallCollider());
		add(new TankeWallCollider());
	}
	public void add(Collider c){
		colliders.add(c);
	}
	public boolean collide(GameObject o1, GameObject o2) {
		for(int i = 0;i < colliders.size();i++){
			if(!colliders.get(i).collide(o1, o2)){
				return false;
			}
		}
		return true;
	}

}
