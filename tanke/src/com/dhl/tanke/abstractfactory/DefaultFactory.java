/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.abstractfactory;

import com.dhl.tanke.Bullet;
import com.dhl.tanke.Dir;
import com.dhl.tanke.Explode;
import com.dhl.tanke.GameModel;
import com.dhl.tanke.GameObject;
import com.dhl.tanke.Group;
import com.dhl.tanke.Tanke;
import com.dhl.tanke.TankeFrame;

/**
 * 
 * @author DHL
 * @version 2020年6月9日
 */
public class DefaultFactory extends GameFactory{
	@Override
	public BaseTanke creatTanke(int x, int y, Dir dir, Group group, GameModel gm) {
		// TODO Auto-generated method stub
		//return new Tanke(x, y, dir, group, gm);
		return null;
	}
	@Override
	public BaseBullet creatBullet(int x, int y, Dir dir, Group group, GameModel gm) {
		// TODO Auto-generated method stub
		//return new Bullet(x, y, dir, group, gm);
		return null;
	}
	@Override
	public BaseExplode creatExplode(int x, int y, GameModel gm) {
		// TODO Auto-generated method stub
		//return new Explode(x, y, gm);
		return null;
	}
}
